package br.com.ntk.jms;

import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import br.com.gateway.ejb.TransacaoService;
import br.com.gateway.ejb.UsuarioService;
import br.com.gateway.elavon.facade.ElavonFacade;
import br.com.gateway.entity.Usuario;
import br.com.ntk.model.Transacao;
import br.com.ntk.util.JMSProperty;
import br.com.ntk.util.XmlParser;


@MessageDriven(activationConfig ={
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="destination", propertyValue="java:/jms/queue/queuePagamento")
})
public class PagamentoConsumer implements MessageListener {
	
	private final Logger log = Logger.getLogger(getClass().getCanonicalName());
	
	@EJB
	private MessagePagamentoSend messageProducerSend;
	
	@EJB
	private UsuarioService usuarioService;
	
	@EJB
	private TransacaoService transacaoService;
	
	@Inject
	private XmlParser parser;
	
	@Resource
	private MessageDrivenContext context;
	
	@Inject
	private ElavonFacade elavon;
	
	public void onMessage(Message message) {

		try {
			
			String sessionID = message.getStringProperty(JMSProperty.SESSION_ID.name());
			log.info("Sessao:" + sessionID);
			
			String xml = ((TextMessage) message).getText();
			Transacao transacao = (Transacao) parser.unmarshal(Transacao.class, xml); 
			
			//OBTEN DADOS DO LOGIN E CONFIGURACAO E VALIDA
			Usuario usuario = usuarioService.getUsuario(transacao.getUsuario(), transacao.getToken());
			if (usuario == null) {
				messageProducerSend.sendMessage("<retorno>Usuario nao cadastrado!</retorno>", sessionID);
				return;
			}
			transacao.setDataHora(new Date());
			transacao.setIdUsuario(usuario.getId());
			transacao.setIdTransacaoToken(""+new Random().nextLong());

			//INSERIR TRANSACAO
			transacaoService.salvar(transacao);
			
			String tipoTransacao = message.getStringProperty(JMSProperty.TIPO_TRANSACAO.name());
			String retorno = elavon.execute(transacao, tipoTransacao);
			
			messageProducerSend.sendMessage(retorno, sessionID);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			context.setRollbackOnly();
		}
	}
	
}

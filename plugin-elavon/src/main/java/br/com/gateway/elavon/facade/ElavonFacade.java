package br.com.gateway.elavon.facade;

import java.sql.Timestamp;
import java.util.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import br.com.gateway.elavon.model.CardECIType;
import br.com.gateway.elavon.model.DoPayment;
import br.com.gateway.elavon.util.HttpUtil;
import br.com.ntk.model.Operacao;
import br.com.ntk.model.Transacao;
import br.com.ntk.util.XmlParser;

@Dependent
public class ElavonFacade implements Operacao {
	
	private Logger log = Logger.getLogger(getClass().getCanonicalName());
	
	@Inject
	private XmlParser parser;
	
	@Inject
	private HttpUtil httpUtil;
	
	@Override
	public String autorizacao(Transacao transacao)  {
		log.info("Operacao autorizacao");
		String retorno = null;
		try {
			DoPayment payment = DoPayment.create()
				.withTransactionID(transacao.getIdTransacaoToken())
				.withIPAddress(transacao.getComprador().getEnderecoIP())
				.withTerminalID("0019410000000000000001")
				.withRegKey("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF")
				.withAdditionalID(transacao.getNumeroDocumento())
				.withTotalAmount(transacao.getValorTransacao())
				.withDateTime(new Timestamp(transacao.getDataHora().getTime()))
				.withOrderDescription(transacao.getDescVenda())
				.withCard(transacao.getCartao().getBandeira())
				.withCardNumber(transacao.getCartao().getNumeroCartao())
				.withCardExpiration(transacao.getCartao().getMesValidade().concat(transacao.getCartao().getAnoValidade().substring(2, 4)))
				.withCVV2(transacao.getCartao().getCodigoSeguranca())
				.withAuthorizationAmount(transacao.getValorTransacao())
				.withInstallments(transacao.getQtdeParcelas())
				.withECI(CardECIType.AUTHENTICATION_STANDARD_SSL)
				.build();
			
			String xml = parser.marshal(DoPayment.class, payment);
			retorno = httpUtil.postParameter("https://qaswsgate.elavon.com.br/wsgate/requesthandler", xml);
		} catch (Exception e) {
			log.severe(e.getMessage());
			e.printStackTrace();
		}
		
		return retorno;
		
	}

	@Override
	public String captura(Transacao transacao) {
		log.info("Operacao captura");
		return "<retorno>Operacao realizada com sucesso!</retorno>";
	}

	@Override
	public String cancelamento(Transacao transacao) {
		log.info("Operacao cancelamento");
		return "<retorno>Operacao realizada com sucesso!</retorno>";
	}

	@Override
	public String consulta(Transacao transacao) {
		log.info("Operacao consulta");
		return "<retorno>Operacao realizada com sucesso!</retorno>";
	}

}

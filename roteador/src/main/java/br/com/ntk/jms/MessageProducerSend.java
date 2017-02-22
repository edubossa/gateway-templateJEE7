package br.com.ntk.jms;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

import br.com.ntk.servlet.Processor;
import br.com.ntk.util.JMSProperty;

/**
 * EJB - para envio de JMS.
 * 
 * @author Eduardo Wallace
 * @since 05/09/2015
 */
@Stateless
public class MessageProducerSend {
	
	@Inject
	private JMSContext context;
	
	/**
	 * Envia mensagem pra fila.
	 * 
	 * @param message - mensagem a ser enviada
	 * @param processor - OBJ Processor
	 */
	public void sendMessage(String message, Processor processor) {
		JMSProducer  producer = context.createProducer();
		producer.setProperty(JMSProperty.TIPO_TRANSACAO.name(), processor.getTipoTransacao());
		producer.setProperty(JMSProperty.SESSION_ID.name(), processor.getSessionID());
		Queue createQueue = context.createQueue(processor.getFilaDestino());
		producer.send(createQueue, message);
	}
	
}
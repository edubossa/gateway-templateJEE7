package br.com.ntk.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

import br.com.ntk.util.JMSProperty;


/**
 * EJB - para envio de JMS.
 * 
 * @author Eduardo Wallace
 * @since 05/09/2015
 */
@Stateless
public class MessagePagamentoSend {
	
	@Inject
	private JMSContext context;
	
	@Resource(lookup = "java:/jms/queue/httpReturn")
	private Queue queue;
	
	/**
	 * Envia mensagem pra fila.
	 * 
	 * @param message - mensagem a ser enviada
	 * @param processor - OBJ Processor
	 */
	public void sendMessage(String message, String sessionID) {
		JMSProducer  producer = context.createProducer();
		producer.setProperty(JMSProperty.SESSION_ID.name(), sessionID);
		producer.send(queue, message);
	}
	
}
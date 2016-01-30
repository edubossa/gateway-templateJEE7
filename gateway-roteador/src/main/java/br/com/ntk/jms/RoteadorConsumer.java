package br.com.ntk.jms;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import br.com.ntk.listener.CallbackContext;
import br.com.ntk.util.JMSProperty;


@MessageDriven(activationConfig ={
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="destination", propertyValue="java:/jms/queue/httpReturn")
})
public class RoteadorConsumer implements MessageListener {
	
	@Resource
	private MessageDrivenContext context;
	
	@EJB
	private CallbackContext callbackContext;
	
	public void onMessage(Message message) {
		try {
			callbackContext.complete(((TextMessage) message).getText(), message.getStringProperty(JMSProperty.SESSION_ID.name()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			context.setRollbackOnly();
		}	
	}
	
}
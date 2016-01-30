package br.com.ntk.servlet;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import br.com.ntk.jms.MessageProducerSend;
import br.com.ntk.listener.CallbackContext;
import br.com.ntk.util.ValidaXSD;

/**
 * Classe responsavel pelo processamento das requisicoes.
 * 
 * @author Eduardo Wallace
 * @author NTK Solutions
 * @since 02/12/2014
 */
@Dependent
public class RequestProcessor implements Runnable {
		
	private final Logger log = Logger.getLogger(getClass().getCanonicalName());
	
	@EJB
	private MessageProducerSend messageProducerSend;
	
	@EJB
	private CallbackContext callbackContext;
	
	@Inject
	private ValidaXSD validaXSD;
	
	/** @see Processor  **/
	private Processor processor;
	
	public void setProcessor(Processor processor) {
		this.processor = processor;
	}
	
	public void run() {
		
		String xml = processor.isAttrParam() ? (String) processor.getAsyncContext().getRequest().getAttribute("xml")
				: (String) processor.getAsyncContext().getRequest().getParameter("xml");
		
		log.info("IP: " + processor.getAsyncContext().getRequest().getRemoteAddr());
		log.info("Sessao: " + processor.getSessionID());
		log.info("Tipo Transacao: " + processor.getTipoTransacao());
		log.info(xml);
		
		callbackContext.put(processor.getSessionID(), processor.getAsyncContext());
		
		if (!validaXSD.validar(processor.getXsd(), xml)) {
			callbackContext.complete(validaXSD.getError().toString(), processor.getSessionID());
			return;
		}
		
		messageProducerSend.sendMessage(xml, processor);
		
	}
}
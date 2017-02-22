package br.com.ntk.listener;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;


public class CallbackAsyncListener implements AsyncListener {
	
	private final Logger log = Logger.getLogger(getClass().getCanonicalName());

	public void onComplete(AsyncEvent event) throws IOException {
		PrintWriter pw =  event.getAsyncContext().getResponse().getWriter();
		String xml = (String) event.getAsyncContext().getRequest().getAttribute("xml");
		HttpServletRequest req = (HttpServletRequest) event.getAsyncContext().getRequest();
		log.info(req.getSession().getId());
		log.info(xml);
		pw.write(xml);
	}

	public void onTimeout(AsyncEvent event) throws IOException {
		
		HttpServletRequest req = (HttpServletRequest) event.getAsyncContext().getRequest();
		log.info(req.getSession().getId());
		
		//CallbackContext.getInstance().remove(sessionID); //TODO EWS ADD EJB 
		
		StringBuilder sb = new StringBuilder();		
		sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		sb.append("<erro>");
		sb.append("<codigo>").append("504").append("</codigo>");
		sb.append("<mensagem>").append("TEMPO EXCEDIDO AO OBTER A RESPOSTA, CONSULTE ESTA TRANSACAO").append("</mensagem>");
		sb.append("</erro>");
		
		event.getAsyncContext().getRequest().setAttribute("xml", sb.toString());
		
	}

	public void onError(AsyncEvent event) throws IOException {
		//log.error("AsyncListener Error");
		StringBuilder sb = new StringBuilder();		
		sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		sb.append("<erro>");
		sb.append("<codigo>").append("500").append("</codigo>");
		sb.append("<mensagem>").append("ERRO INTERNO, CONSULTE ESTA TRANSACAO OU CONTATE O SUPORTE").append("</mensagem>");
		sb.append("</erro>");
		
		event.getAsyncContext().getRequest().setAttribute("xml", sb.toString());
		
	}

	public void onStartAsync(AsyncEvent event) throws IOException {	
		//--
	}

}
package br.com.ntk.listener;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.servlet.AsyncContext;

/**
 * EJB Singleton, utilizado para controlar o armazenamento e remocao dos Callbacks.
 * 
 * @author Eduardo Wallace
 * @since 05/09/2015
 */
@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class CallbackContext {
	
	private final Logger log = Logger.getLogger(getClass().getCanonicalName());
	
	private ConcurrentHashMap<String, AsyncContext> mapRequests;
		
	@PostConstruct
	private void init() {
		log.info("Singleton EJB CallbackContext - Iniciado!");
		mapRequests = new ConcurrentHashMap<String, AsyncContext>();
	}
	
	/** Armazena o  AsyncContext **/
	public void put(String sessionID, AsyncContext asyncContext) {
		mapRequests.put(sessionID, asyncContext);
	}
	
	/** Remove o AsyncContext **/
	public void remove(String sessionID) {
		mapRequests.remove(sessionID);
	}
	
	/**
	 * Conclui o processamento da transacao do gateway chamando o Callback
	 * 
	 * @param xml - contem os dados da transacao
	 * @param sessionID - id da sessao
	 */
	@Lock(LockType.WRITE)
	public void complete(String xml, String sessionID) {
		if (mapRequests.containsKey(sessionID)) {
			AsyncContext asyncContext = (AsyncContext) mapRequests.get(sessionID);
			mapRequests.remove(sessionID);
			asyncContext.getRequest().setAttribute("xml", xml);
			asyncContext.complete();			
		} else {
			log.warning("Timeout " + xml);
		}
	}
	
}
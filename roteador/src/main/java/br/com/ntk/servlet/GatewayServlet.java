package br.com.ntk.servlet;

import java.util.concurrent.Executor;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ntk.listener.CallbackAsyncListener;

public abstract class GatewayServlet extends HttpServlet {
	private static final long serialVersionUID = -4294404416746373387L;
	
	@Resource(lookup = "java:jboss/ee/concurrency/executor/default")
	private Executor executor;

	@Inject
	private RequestProcessor requestProcessor;
	
	/** @see Processor  **/
	protected abstract Processor getProcessor();
	
	/** 
	 * Utilizado caso seja necessario obter parametros da request, para possiveis 
	 * tratamento do metodo getProcessor() 
	 **/
	protected HttpServletRequest httpServletRequest;

	public void doPost(final HttpServletRequest request, final HttpServletResponse response) {
		request.getSession().invalidate();
		final AsyncContext asyncContext = request.startAsync();
		asyncContext.setTimeout(100 * 1000);
		asyncContext.addListener(new CallbackAsyncListener());
		httpServletRequest = request;
		Processor processor = getProcessor();
		processor.setSessionID(request.getSession().getId());
		processor.setAsyncContext(asyncContext); 
		this.requestProcessor.setProcessor(processor);
		executor.execute(this.requestProcessor);
	}
		
}
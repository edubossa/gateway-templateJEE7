package br.com.ntk.servlet;

import javax.servlet.AsyncContext;

/**
 * Contem os parametros necessarios para realizar a transacao/requisicao do gateway.
 * 
 * @author Eduardo Wallace
 * @author NTK Solutions
 * @since 02/12/2014
 */
public class Processor {
	
	/** AsyncContext - necessario para completar a requisicao  **/
	private AsyncContext asyncContext;
	
	/** Tipo da Transacao - usado para identificacao dos modulos do gateway **/
	private String tipoTransacao;
	
	/** Fila de destino a ser enviada para o provider **/
	String filaDestino;
	
	/** ID da sessao **/
	private String sessionID;
	
	/** Nome do xsd a ser validado **/
	private String xsd;
	
	/** Define se parametro é enviado por atributo **/
	private boolean attrParam;

	public Processor() {
	}
	
	/**
	 * Construtor - Processor
	 * @param asyncContext - necessario para completar a requisicao
	 * @param tipoTransacao - usado para identificacao dos modulos do gateway
	 * @param filaDestino - Fila de destino a ser enviada para o provider
	 * @param sessionID - ID da sessao
	 * @param xsd - Nome do xsd a ser validado
	 */
	public Processor(AsyncContext asyncContext, String tipoTransacao, String filaDestino, String sessionID, String xsd) {
		this.asyncContext = asyncContext;
		this.tipoTransacao = tipoTransacao;
		this.filaDestino = filaDestino;
		this.sessionID = sessionID;
		this.xsd = xsd;
	}
	
	/**
	 * Construtor - Processor
	 * @param tipoTransacao - usado para identificacao dos modulos do gateway
	 * @param filaDestino - Fila de destino a ser enviada para o provider
	 * @param xsd - Nome do xsd a ser validado
	 */
	public Processor(String tipoTransacao, String filaDestino, String xsd) {
		this.tipoTransacao = tipoTransacao;
		this.filaDestino = filaDestino;
		this.xsd = xsd;
	}
	
	/**
	 * Construtor - Processor
	 * @param tipoTransacao - usado para identificacao dos modulos do gateway
	 * @param filaDestino - Fila de destino a ser enviada para o provider
	 * @param xsd - Nome do xsd a ser validado
	 * @param attrParam - Define se parametro é enviado por atributo
	 */
	public Processor(String tipoTransacao, String filaDestino, String xsd, boolean attrParam) {
		this.tipoTransacao = tipoTransacao;
		this.filaDestino = filaDestino;
		this.xsd = xsd;
		this.attrParam = attrParam;
	}

	/** AsyncContext - necessario para completar a requisicao  **/
	public AsyncContext getAsyncContext() {
		return asyncContext;
	}
	
	/** AsyncContext - necessario para completar a requisicao  **/
	public void setAsyncContext(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}
	
	/** Tipo da Transacao - usado para identificacao dos modulos do gateway **/
	public String getTipoTransacao() {
		return tipoTransacao;
	}
	
	/** Tipo da Transacao - usado para identificacao dos modulos do gateway **/
	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	
	/** Fila de destino, a ser enviada para o provider **/
	public String getFilaDestino() {
		return filaDestino;
	}
	
	/** Fila de destino, a ser enviada para o provider **/
	public void setFilaDestino(String filaDestino) {
		this.filaDestino = filaDestino;
	}
	
	/** ID da sessao **/
	public String getSessionID() {
		return sessionID;
	}
	
	/** ID da sessao **/
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
	/** Nome do xsd a ser validado **/
	public String getXsd() {
		return xsd;
	}
	
	/** Nome do xsd a ser validado **/
	public void setXsd(String xsd) {
		this.xsd = xsd;
	}

	public boolean isAttrParam() {
		return attrParam;
	}

	public void setAttrParam(boolean attrParam) {
		this.attrParam = attrParam;
	}

}
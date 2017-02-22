package br.com.ntk.model;

import java.lang.reflect.Method;


public interface Operacao {
	
	public String autorizacao(Transacao transacao);
	
	public String captura(Transacao transacao);
	
	public String cancelamento(Transacao transacao);
	
	public String consulta(Transacao transacao);
	
	/** Invoca as operacoes dinamicamente de acordo com o tipo da transacao **/
	public default String execute(Transacao transacao, String tipoTransacao) throws OperacaoException {
		String retorno = null;
		try {
			Method method = getClass().getDeclaredMethod(tipoTransacao.toLowerCase(), Transacao.class);
			retorno = (String) method.invoke(this, transacao);
		} catch (Exception e) {
			throw new OperacaoException("Operacao nao encontrada!");
		}
		return retorno;
	}
	
}

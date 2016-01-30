package br.com.ntk.servlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/aprovacao"}, asyncSupported=true)
public class Aprovacao extends GatewayServlet {
	private static final long serialVersionUID = -1693062302826105330L;
	
	protected Processor getProcessor() {
		return new Processor("AUTORIZACAO", "queuePagamento", "/xsd/TransacaoCartaoAprovacao.xsd");
	}
	
}
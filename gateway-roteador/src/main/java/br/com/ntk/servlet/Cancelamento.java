package br.com.ntk.servlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/cancelamento"}, asyncSupported=true)
public class Cancelamento extends GatewayServlet {
	private static final long serialVersionUID = -1870630726608492811L;

	protected Processor getProcessor() {
		return new Processor("CANCELAMENTO", "queuePagamento", "/xsd/TransacaoCancelamento.xsd");
	}
	
}
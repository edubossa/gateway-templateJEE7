package br.com.ntk.servlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/captura"}, asyncSupported=true)
public class Captura extends GatewayServlet {
	private static final long serialVersionUID = 7814250814841589126L;

	protected Processor getProcessor() {
		return new Processor("CAPTURA", "queuePagamento", "/xsd/TransacaoCaptura.xsd");
	}	
}
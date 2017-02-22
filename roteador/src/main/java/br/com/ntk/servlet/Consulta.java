package br.com.ntk.servlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/consulta"}, asyncSupported=true)
//@Processor(tipoTransacao = "CONSULTA", filaDestino = "queuePagamento",  xsd = "/xsd/TransacaoConsulta.xsd" )
public class Consulta extends GatewayServlet {
	private static final long serialVersionUID = -6088823384149773790L;

	protected Processor getProcessor() {
		return new Processor("CONSULTA", "queuePagamento", "/xsd/TransacaoConsulta.xsd");
	}
}
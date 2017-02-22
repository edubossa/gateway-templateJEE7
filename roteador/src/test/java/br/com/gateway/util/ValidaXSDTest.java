package br.com.gateway.util;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.ntk.util.ValidaXSD;


public class ValidaXSDTest {
	
	private static final String XSD = "/xsd/TransacaoConsulta.xsd";
	private StringBuilder xml;
	
	@Before
	public void initXSD() {
		xml = new StringBuilder();
		xml.append("<transacao>")
			.append("<usuario>ntk</usuario>")
			.append("<token>1234</token>")
			.append("<id_transacao>932f7234-9352-4e84-9799-d407d35b6949</id_transacao>")
			.append("</transacao>");
	}

	@Test
	public void testXSD() {
		ValidaXSD validaXSD = new ValidaXSD();
		assertTrue(validaXSD.validar(XSD, xml.toString()));
	}

}

package br.com.ntk.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * Utilitareo para validacao do XML
 * 
 * @author Eduardo Wallace
 * @since 06/09/2015
 *
 */
@Dependent
public class ValidaXSD {
	
	private final Logger log = Logger.getLogger(getClass().getCanonicalName());
	private StringBuilder error;
	
	/**
	 * Valida o XML
	 * 
	 * @param xsd - para validacao
	 * @param xml - xml da transacao
	 * @return true caso XML seja compativel com o XSD passado como parametro
	 */
	public boolean validar(String xsd, String xml){
		if (xsd != null) {			
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Source schemaFile = new StreamSource(getClass().getResourceAsStream(xsd));		
			try {
				Schema schema = factory.newSchema(schemaFile);			
				Validator validator = schema.newValidator();	
				validator.validate(new StreamSource(new StringReader(xml)));
			} catch (SAXException | IOException e) {
				error = new StringBuilder();
				error.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
				error.append("<erro>");
				error.append("<codigo>001</codigo>");
				error.append("<mensagem><![CDATA[").append(e.getMessage()).append("]]>");
				error.append("</mensagem>");
				error.append("</erro>");
				log.severe(error.toString());
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Mensagem de erro caso o XML nao  seja compativel com o XSD.
	 * 
	 * @return - mensagem de erro.
	 */
	public StringBuilder getError() {
		return error;
	}

}
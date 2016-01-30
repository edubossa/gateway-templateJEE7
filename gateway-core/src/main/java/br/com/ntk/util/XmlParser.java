package br.com.ntk.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Dependent
public class XmlParser implements Parser {
	
	private final Logger log = Logger.getLogger(getClass().getCanonicalName());
	
	@Override
	public <T> Object unmarshal(Class<T> c, String xml) throws JAXBException {
		Object obj = null;
		try {
			obj = JAXBContext.newInstance(c).createUnmarshaller().unmarshal(new StringReader(xml));
		} catch (JAXBException e) {
			log.severe(e.getMessage());
			throw new JAXBException("Erro ao executar o parse do XML pro Objeto");
		}
		
		return obj;
	}

	@Override
	public <T> String marshal(Class<T> c, Object jaxbElement)
			throws JAXBException, UnsupportedEncodingException {
		String xml = null;
		try {
			StringWriter writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(c);
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(jaxbElement, writer); 
			
			xml = URLDecoder.decode(ENCODING.concat(writer.toString()), CHARSET); 
			
		} catch (JAXBException e) {
			e.printStackTrace();
			log.severe(e.getMessage());
			throw new JAXBException("Erro ao executar o parse do Objeto pro XML.");
			
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.severe(e.getMessage());
			throw new UnsupportedEncodingException("Erro ao interpretar xml com encoding inválido ou não suportado.");
		}
		
		return xml;
	}

}

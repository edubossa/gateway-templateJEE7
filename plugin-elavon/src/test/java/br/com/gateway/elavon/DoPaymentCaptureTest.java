package br.com.gateway.elavon;

import static org.junit.Assert.*;

import java.io.StringWriter;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import br.com.gateway.elavon.model.DoPaymentCapture;

public class DoPaymentCaptureTest {

	@Test
	public void test() {
		
		try {
			
			DoPaymentCapture capture = DoPaymentCapture.create()
					.withTerminalID("0019410000000000000001")
					.withRegKey("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF")
					.withTransactionID("23434556567612908786")
					.withCaptureAmount(new BigDecimal("600.00"))
					.build();
			
			StringWriter xml = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(DoPaymentCapture.class);
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(capture, xml); 
			
			System.out.println(xml.toString());
			
		} catch (Exception e) {			
			fail(e.getMessage());
		}
		
	}

}

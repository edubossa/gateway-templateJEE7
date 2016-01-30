package br.com.gateway.elavon;

import static org.junit.Assert.*;

import java.io.StringWriter;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import br.com.gateway.elavon.model.DoPaymentCancel;

public class DoPaymentCancelTest {

	@Test
	public void test() {
		
		try {
			
			DoPaymentCancel cancel = DoPaymentCancel.create()
					.withTerminalID("0019410000000000000001")
					.withRegKey("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF")
					.withCancelAmount(new BigDecimal("600.00"))
					.withTransactionID("23434556567644676323")
					.withNotifyURL("https://www.ntk2all.com.br/request.php?id=23434556567644676323")
					.build();
			
			StringWriter xml = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(DoPaymentCancel.class);
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(cancel, xml); 
			
			System.out.println(xml.toString());
			
			
		} catch(Exception e) {			
			fail(e.getMessage());
		}
		
	}

}

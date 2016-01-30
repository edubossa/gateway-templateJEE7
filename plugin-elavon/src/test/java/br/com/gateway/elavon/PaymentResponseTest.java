package br.com.gateway.elavon;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.junit.Test;

import br.com.gateway.elavon.model.PaymentResponse;
import static org.junit.Assert.*;

public class PaymentResponseTest {
	

	@Test
	public void test() {
		
		try {
			
			InputStream is = PaymentResponseTest.class.getResourceAsStream("PaymentResponse.xml");
			PaymentResponse response = (PaymentResponse) JAXBContext.newInstance(PaymentResponse.class).createUnmarshaller()
				.unmarshal(is);
			
			//System.out.println(response.transactionID);
		
		} catch (JAXBException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		
		
	}

}

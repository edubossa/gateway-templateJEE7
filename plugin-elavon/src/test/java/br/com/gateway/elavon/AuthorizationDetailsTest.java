package br.com.gateway.elavon;

import static org.junit.Assert.*;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.junit.Test;

import br.com.gateway.elavon.model.AuthorizationDetails;
import br.com.gateway.elavon.model.PaymentResponse;
import br.com.gateway.elavon.model.ResponseCodeType;

public class AuthorizationDetailsTest {

	@Test
	public void testResponseCodeTypeSuccessful() {
	try {
			
			InputStream is = PaymentResponseTest.class.getResourceAsStream("PaymentResponse.xml");
			PaymentResponse response = (PaymentResponse) JAXBContext.newInstance(PaymentResponse.class).createUnmarshaller()
				.unmarshal(is);
			
			AuthorizationDetails details = response.getPaymentResponseDetails().getCard().getAuthorizationDetails();
			ResponseCodeType codeType = details.getResponseCode();
			
			assertEquals("Transaction Declined", ResponseCodeType.AA, codeType);
		
		} catch (JAXBException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}

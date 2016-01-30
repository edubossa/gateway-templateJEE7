package br.com.gateway.elavon;

import static org.junit.Assert.fail;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;

import org.junit.Test;

import br.com.gateway.elavon.model.PaymentTransactionList;
import br.com.gateway.elavon.model.PaymentTransactionList.PaymentTransaction;



public class PaymentTransactionListTest {
	
	@Test
	public void init(){
		System.out.println();
		System.out.println("===============================================================================");
		System.out.println();
	}

	@Test
	public void testList() {
		
		try {
			
			InputStream is = PaymentTransactionListTest.class.getResourceAsStream("PaymentTransactionListFilter.xml");
			PaymentTransactionList list = (PaymentTransactionList) JAXBContext.newInstance(PaymentTransactionList.class).createUnmarshaller()
				.unmarshal(is);
			
			for(PaymentTransaction paymentTransaction : list.getPaymentTransaction()) {
				System.out.println("ID: " + paymentTransaction.getTransactionID() + " | Status: " + paymentTransaction.getStatusCode());
			}
						
		} catch (Exception e) {	
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testUnicaTransacao() {
		
		try {
			
			InputStream is = PaymentTransactionListTest.class.getResourceAsStream("PaymentTransactionList.xml");
			PaymentTransactionList list = (PaymentTransactionList) JAXBContext.newInstance(PaymentTransactionList.class).createUnmarshaller()
					.unmarshal(is);
			
			for(PaymentTransaction paymentTransaction : list.getPaymentTransaction()) {
				System.out.println("ID: " + paymentTransaction.getTransactionID() + " | Status: " + paymentTransaction.getStatusCode());
			}
			
		} catch (Exception e) {	
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

}

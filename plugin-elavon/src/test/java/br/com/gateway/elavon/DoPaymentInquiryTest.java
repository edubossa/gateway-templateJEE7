package br.com.gateway.elavon;

import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.gateway.elavon.model.DoPaymentInquiry;

public class DoPaymentInquiryTest {
	
	@Before
	public void init() {
		System.out.println();
		System.out.println("============================================================================");
		System.out.println();
	}

	@Test
	public void testDoPaymentInquiry() {
		try {
			
			DoPaymentInquiry inquiry = DoPaymentInquiry.create()
					.withTerminalID("0019410000000000000001")
					.withRegKey("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF")
					.withTransactionID("23434556567667765432")
					.build();
			
			String xml = "" ;//XmlParserUtil.getInstance().marshal(DoPaymentInquiry.class, inquiry);
			System.out.println(xml);
			
		} catch (Exception e) {			
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void testAlternativeFilterDetails() {
		try {
			
			DoPaymentInquiry inquiry = DoPaymentInquiry.create()
					.withTerminalID("0019410000000000000001")
					.withRegKey("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF")
					.withStatusCode(1)
					.withStartPurchaseDateTime(new Timestamp(new Date().getTime()))
					.withEndPurchaseDateTime(new Timestamp(new Date().getTime()))
					.withRetrievalLimit(10)
					.build();
			
			String xml = ""; // XmlParserUtil.getInstance().marshal(DoPaymentInquiry.class, inquiry);
			System.out.println(xml);
			
		} catch (Exception e) {			
			fail("Not yet implemented");
		}
	}

}

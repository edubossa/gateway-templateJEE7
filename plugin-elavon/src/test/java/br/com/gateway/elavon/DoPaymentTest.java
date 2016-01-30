package br.com.gateway.elavon;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import br.com.gateway.elavon.model.CardECIType;
import br.com.gateway.elavon.model.DoPayment;
import br.com.gateway.elavon.model.ElavonException;

/**
 * Testes - operacao envio de Autorizacao e Autorizacao com Captura.
 * 
 * @author Eduardo Wallace
 * @since 18/08/2015
 */
public class DoPaymentTest {

	@Test
	public void testAutorizacao() {
		String xml = "";
		DoPayment payment = DoPayment.create()
				.withTransactionID(UUID.randomUUID().toString())
				.withIPAddress("191.209.113.90")
				.withTerminalID("0019410000000000000001")
				.withRegKey("0019410000000000000001")
				.withAdditionalID("89876565H")
				.withTotalAmount(new BigDecimal("1250.90"))
				.withDateTime(new Timestamp(new Date().getTime()))
				.withOrderDescription("GATEWAY-TEST")
				.withCard("VISA")
				.withCardNumber("4444111122223333")
				.withCardExpiration("1230")
				.withCVV2("424")
				.withAuthorizationAmount(new BigDecimal("1250.90"))
				.withInstallments(6)
				.withECI(CardECIType.FULL_AUTHENTICATION)
				.build();
		
		assertEquals("Erro na Autorizacao", "Auth", payment.getPaymentAction());

		xml = "";//XmlParserUtil.getInstance().marshal(DoPayment.class, payment);
		
		System.out.println(xml);
		System.out.println("=================================================================================================");
		
	}
	
	@Test
	public void testAutorizacaoComCaptura() {
		String xml = "";
		DoPayment payment = DoPayment.create()
				.withTransactionID(UUID.randomUUID().toString())
				.withCapture(true)
				.withIPAddress("191.209.113.90")
				.withTerminalID("0019410000000000000001")
				.withRegKey("0019410000000000000001")
				.withAdditionalID("89876565H")
				.withTotalAmount(new BigDecimal("1250.90"))
				.withDateTime(new Timestamp(new Date().getTime()))
				.withOrderDescription("GATEWAY-TEST")
				.withCard("VISA")
				.withCardNumber("4444111122223333")
				.withCardExpiration("1230")
				.withCVV2("424")
				.withAuthorizationAmount(new BigDecimal("1250.90"))
				.withInstallments(2)
				.withECI(CardECIType.FULL_AUTHENTICATION)
				.build();
		
		assertEquals("Erro na Autorizacao com Captura", "Sale", payment.getPaymentAction());
		
		xml = "";// XmlParserUtil.getInstance().marshal(DoPayment.class, payment);
		
		System.out.println(xml);
		System.out.println("=================================================================================================");
	}
	
	//@Test(expected = ElavonException.class)
	public void testAutorizacaoComParcelasMenorQueDois() throws ElavonException, UnsupportedEncodingException, JAXBException {
		String xml = "";

		DoPayment payment = DoPayment.create()
				.withTransactionID(UUID.randomUUID().toString())
				.withCapture(true)
				.withIPAddress("191.209.113.90")
				.withTerminalID("0019410000000000000001")
				.withRegKey("0019410000000000000001")
				.withAdditionalID("89876565H")
				.withTotalAmount(new BigDecimal("1250.90"))
				.withDateTime(new Timestamp(new Date().getTime()))
				.withOrderDescription("GATEWAY-TEST")
				.withCard("VISA")
				.withCardNumber("4444111122223333")
				.withCardExpiration("1230")
				.withCVV2("424")
				.withAuthorizationAmount(new BigDecimal("1250.90"))
				.withInstallments(1)
				.withECI(CardECIType.FULL_AUTHENTICATION)
				.build();
			
			xml = "";//XmlParserUtil.getInstance().marshal(DoPayment.class, payment);
		
		System.out.println(xml);
		System.out.println("=================================================================================================");
	}
	
	//@Test
	public void testAutorizacaoParcelamentoEmissor() {
		String xml = "";
		DoPayment payment = DoPayment.create()
				.withTransactionID(UUID.randomUUID().toString())
				.withIPAddress("191.209.113.90")
				.withTerminalID("0019410000000000000001")
				.withRegKey("0019410000000000000001")
				.withAdditionalID("89876565H")
				.withTotalAmount(new BigDecimal("1250.90"))
				.withDateTime(new Timestamp(new Date().getTime()))
				.withOrderDescription("GATEWAY-TEST")
				.withCard("VISA")
				.withCVV2("424")
				.withAuthorizationAmount(new BigDecimal("1250.90"))
				.withInstallments(6)
				.withInstallmentsIssuer(true)//Parcelamento pelo emissor
				.withECI(CardECIType.FULL_AUTHENTICATION)
				.build();
		
		assertEquals("Configuracao de pagamento pelo emissor invalida", "I", payment.getPaymentRequestDetails().getCard().getInstallments().getType());

		xml = "";//XmlParserUtil.getInstance().marshal(DoPayment.class, payment);
		
		System.out.println(xml);
		System.out.println("=================================================================================================");
	}
	
	@Test
	public void testAutorizacaoComAutenticacao() {
		String xml = "";
		DoPayment payment = DoPayment.create()
				.withTransactionID(UUID.randomUUID().toString())
				.withIPAddress("191.209.113.90")
				.withTerminalID("0019410000000000000001")
				.withRegKey("0019410000000000000001")
				.withAdditionalID("89876565H")
				.withTotalAmount(new BigDecimal("1250.90"))
				.withDateTime(new Timestamp(new Date().getTime()))
				.withOrderDescription("GATEWAY-TEST")
				.withCard("VISA")
				.withCardNumber("4444111122223333")
				.withCardExpiration("1230")
				.withCVV2("424")
				.withAuthorizationAmount(new BigDecimal("1250.90"))
				.withInstallments(6)
				.withECI(CardECIType.FULL_AUTHENTICATION)
				.build();
		
		assertEquals("Erro na configuracao da autorizacao com autenticacao", 5, payment.getPaymentRequestDetails().getCard().getECI());

		xml = "";//XmlParserUtil.getInstance().marshal(DoPayment.class, payment);
		
		System.out.println(xml);
		System.out.println("=================================================================================================");
	}

}

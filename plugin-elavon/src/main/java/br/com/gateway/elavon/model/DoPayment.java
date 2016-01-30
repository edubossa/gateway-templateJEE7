package br.com.gateway.elavon.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.gateway.elavon.model.PurchaseDetails.TotalAmount;


/**
 * Realiza uma autorizacao, ou autorizacao com captura.
 * <p>
 * Types Description
 * <p>
	<u><b><i>R</i></b></u> - Required/Mandatory Field
	<p>
	<u><b><i>O</i></b></u> - Optional Field
	<p>
	<u><b><i>C</i></b></u> - Conditional Field
 * 
 * @author Eduardo Wallace
 * @since 13/08/2015
 */
@XmlRootElement(name = "DoPayment")
@XmlAccessorType(XmlAccessType.FIELD)
public class DoPayment {
	
	@XmlAttribute
	private static final String version = "1.1.0";
	
	@XmlElement(name = "Language")
	private String language = "PT-BR";
	
	@XmlElement(name = "TransactionID")
	private String transactionID;
	
	@XmlElement(name = "PaymentAction")
	private String paymentAction;
	
	@XmlElement(name = "IPAddress")
	private String ipAddress;
	
	@XmlElement(name = "MerchantDetails")
	private MerchantDetails merchantDetails;
	
	@XmlElement(name = "PurchaseDetails")
	private PurchaseDetails purchaseDetails;
	
	@XmlElement(name = "PaymentRequestDetails")
	private PaymentRequestDetails paymentRequestDetails;

	public String getTransactionID() {
		return transactionID;
	}

	public String getPaymentAction() {
		return paymentAction;
	}

	public MerchantDetails getMerchantDetails() {
		return merchantDetails;
	}

	public PurchaseDetails getPurchaseDetails() {
		return purchaseDetails;
	}

	public PaymentRequestDetails getPaymentRequestDetails() {
		return paymentRequestDetails;
	}

	private DoPayment() {} //declaracao obrigatoria para realizacao do parse com jaxb
	
	private DoPayment(DoPaymentBuilder builder) {
		this.transactionID = builder.transactionID;
		this.paymentAction = builder.capture ? "Sale" : "Auth";
		this.ipAddress = builder.ipAddress;
		this.merchantDetails = new MerchantDetails();
		this.merchantDetails.setTerminalID(builder.terminalID);
		this.merchantDetails.setRegKey(builder.regKey);
		this.purchaseDetails = new PurchaseDetails();
		this.purchaseDetails.setAdditionalID(builder.additionalID);
		TotalAmount totalAmount = new PurchaseDetails.TotalAmount();
		totalAmount.setValue(builder.totalAmount.toString().replaceAll("\\D", ""));
		this.purchaseDetails.setTotalAmount(totalAmount);
		//2015-08-12T15:00:00-03:00
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		this.purchaseDetails.setDateTime(format.format(builder.dateTime));
		this.purchaseDetails.setOrderDescription(builder.orderDescription); 
		this.paymentRequestDetails = new PaymentRequestDetails();
		PaymentRequestDetails.Card card = new PaymentRequestDetails.Card();
		card.setCardProduct(CardProductType.getBandeira(builder.card).getCard());
		card.setCardData(builder.cardNumber.concat("=").concat(builder.cardExpiration));
		card.setCVV2(builder.CVV2);
		PaymentRequestDetails.Card.AuthorizationAmount authorizationAmount = new PaymentRequestDetails.Card.AuthorizationAmount();
		authorizationAmount.setValue(builder.authorizationAmount.toString().replaceAll("\\D", ""));
		card.setAuthorizationAmount(authorizationAmount);
		if (builder.installments != null) {			
			PaymentRequestDetails.Card.Installments installments = new PaymentRequestDetails.Card.Installments();
			installments.setValue(builder.installments);
			installments.setType(builder.installmentsIssuer ? "I" : "M");
			card.setInstallments(installments);
		}
		if (builder.ECI != null) {			
			card.setECI(builder.ECI.getValue());
		}
		this.paymentRequestDetails.setCard(card);
		
	}
	
	public static DoPaymentBuilder create() {
		return new DoPaymentBuilder();
	}
	
	/*
	 * Builder - Design pattern
	 */
	public static class DoPaymentBuilder {
		
		//DoPayment
		private String transactionID;		
		private boolean capture;		
		private String ipAddress;
		
		//MerchantDetails
		private String terminalID;
		private String regKey;
		
		//PurchaseDetails
		private String additionalID;
		private BigDecimal totalAmount;
		//Merchant to Elavon - formato: 2020-04-07T23:12:12
		private Timestamp dateTime;
		private String orderDescription;
		
		//PaymentRequestDetails
		private String card;
		private String cardNumber;
		private String cardExpiration;
		private String CVV2;
		private BigDecimal authorizationAmount;
		private Integer installments;
		private Boolean installmentsIssuer = Boolean.FALSE;
		private CardECIType ECI;
		
		/**
		 * <u><b><i>R</i></b></u> - Identificador unico da transacao, OBS: Nao deve ser duplicado por terminal 
		 */
		public DoPaymentBuilder withTransactionID(String transactionID) {
			this.transactionID = transactionID;
			return this;
		}
		
		/**
		 * <u><b><i>C</i></b></u> - se informado com valor true realiza a autorizacao com captura automatica. Se nao informado realiza apenas a autorizacao 
		 */
		public DoPaymentBuilder withCapture(boolean capture) {
			this.capture = capture;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Utilizado para possiveis identificacoes de fraudes
		 */
		public DoPaymentBuilder withIPAddress(String ipAddress) {
			this.ipAddress = ipAddress;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Identificacao do Logista da Elavon
		 */
		public DoPaymentBuilder withTerminalID(String terminalID) {
			this.terminalID = terminalID;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Chave de afiliacao usada pela Elavon junto com o TerminalID para autenticacao das requisicoes.
		 */
		public DoPaymentBuilder withRegKey(String regKey) {
			this.regKey = regKey;
			return this;
		}
		
		/**
		 * <u><b><i>O</i></b></u> - Usado para referencia do cliente
		 */
		public DoPaymentBuilder withAdditionalID(String additionalID) {
			this.additionalID = additionalID;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Valor total da compra incluindo impostos, taxas de fretes, etc...
		 */
		public DoPaymentBuilder withTotalAmount(BigDecimal totalAmount) {
			this.totalAmount = totalAmount;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Data da compra
		 */
		public DoPaymentBuilder withDateTime(Timestamp dateTime) {
			this.dateTime = dateTime;
			return this;
		}
		
		/**
		 * <u><b><i>O</i></b></u> - Descricao dos itens da compra
		 */
		public DoPaymentBuilder withOrderDescription(String orderDescription) {
			this.orderDescription = orderDescription;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Tipo de (Cartao)(Bandeira) suportado pela elavon. 
		 */
		public DoPaymentBuilder withCard(String card) {
			this.card = card;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Numero do cartao.
		 */
		public DoPaymentBuilder withCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Data do vencimento do cartao, formato: <b>(MMYY)</b>
		 */
		public DoPaymentBuilder withCardExpiration(String cardExpiration) {
			this.cardExpiration = cardExpiration;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - CVV, verificacao de 3 a 4 digitos, contidos na parte de tras do cartao
		 */
		public DoPaymentBuilder withCVV2(String CVV2) {
			this.CVV2 = CVV2;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Valor a ser autorizado.
		 */
		public DoPaymentBuilder withAuthorizationAmount(BigDecimal authorizationAmount) {
			this.authorizationAmount = authorizationAmount;
			return this;
		}
		
		/**
		 * <u><b><i>C</i></b></u> - Numero de parcelas, se informado o valor deve ser maior ou igual a 2x, 
		 * caso contrario considera pagamento a vista
		 */
		public DoPaymentBuilder withInstallments(Integer installments) {
			if(installments < 2) installments = null;
			this.installments = installments;
			return this;
		}
		
		/**
		 * <u><b><i>C</i></b></u> - Se informado o valor true, o parcelamento sera efetuado pelo Emissor, caso contrario sera efetuado pelo Logista.
		 * <p> 
		 * O valor padrao e <b>"Parcelado pelo Logista"</b> 
		 * <p>
		 * TODO: OBS: nao foi possivel realizar no ambiente de testes, o tipo de pagamento pelo emissor
		 */
		public DoPaymentBuilder withInstallmentsIssuer(Boolean installmentsIssuer) {
			this.installmentsIssuer = installmentsIssuer;
			return this;
		}
		
		/**
		 * <u><b><i>C</i></b></u> - Configura o nivel de seguranca da transacao. Caso nao seja informado
		 * <p> 
		 * O valor padrao e <b>"CardECIType.AUTHENTICATION_STANDARD_SSL"</b> 
		 * <p>
		 * @see CardProductType
		 */
		public DoPaymentBuilder withECI(CardECIType ECI) {
			this.ECI = ECI;
			return this;
		}
		
		
		public DoPayment build() {
			return new DoPayment(this);
		}
		
	}
	
	
}
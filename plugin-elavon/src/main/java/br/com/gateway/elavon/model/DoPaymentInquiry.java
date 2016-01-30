package br.com.gateway.elavon.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Realiza consulta
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
 * @since 24/08/2015
 */
@XmlRootElement(name = "DoPaymentInquiry")
@XmlAccessorType(XmlAccessType.FIELD)
public class DoPaymentInquiry {
	
	@XmlAttribute
	private static final String version = "1.1.0";
	
	@XmlElement(name = "Language")
	private String language = "PT-BR";
	
	@XmlElement(name = "TransactionID")
	private String transactionID;
	
	@XmlElement(name = "AlternativeFilterDetails")
	private AlternativeFilterDetails alternativeFilterDetails;
	
	@XmlElement(name = "MerchantDetails")
	private MerchantDetails merchantDetails;
	
	private DoPaymentInquiry(){}
	
	private DoPaymentInquiry(DoPaymentInquiryBuilder builder) {
		this.transactionID = builder.transactionID;
		this.merchantDetails = new MerchantDetails();
		this.merchantDetails.setTerminalID(builder.terminalID);
		this.merchantDetails.setRegKey(builder.regKey);
		
		//aplica o filtro
		if (this.transactionID == null) {			
			this.alternativeFilterDetails = new AlternativeFilterDetails();
			this.alternativeFilterDetails.setStatusCode(builder.statusCode);
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			this.alternativeFilterDetails.setStartPurchaseDateTime(sd.format(builder.startPurchaseDateTime));
			this.alternativeFilterDetails.setEndPurchaseDateTime(sd.format(builder.endPurchaseDateTime));
			this.alternativeFilterDetails.setRetrievalLimit(builder.retrievalLimit);
		}
		
	}
	
	public static DoPaymentInquiryBuilder create() {
		return new DoPaymentInquiryBuilder();
	}
	
	public static class DoPaymentInquiryBuilder {
		
		private String transactionID;
		
		//MerchantDetails
		private String terminalID;
		private String regKey;
		
		//AlternativeFilterDetails
		private int statusCode;
		private Timestamp startPurchaseDateTime;
		private Timestamp endPurchaseDateTime;
		private int retrievalLimit;
		
		/**
		 * <u><b><i>R</i></b></u> - Identificador unico da transacao, OBS: Nao deve ser duplicado por terminal 
		 */
		public DoPaymentInquiryBuilder withTransactionID(String transactionID) {
			this.transactionID = transactionID;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Identificacao do Logista da Elavon
		 */
		public DoPaymentInquiryBuilder withTerminalID(String terminalID) {
			this.terminalID = terminalID;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Chave de afiliacao usada pela Elavon junto com o TerminalID para autenticacao das requisicoes.
		 */
		public DoPaymentInquiryBuilder withRegKey(String regKey) {
			this.regKey = regKey;
			return this;
		}
		
		/**
		 * <u><b><i>O</i></b></u> - Caso informado filtra pelo Codigo do Status
		 * <ul>
		 * 	<li>0 - Created</li>
		 * <li>1 - Authorized (capture pending)</li>
		 * <li>2 - Partial Authorized (capture pending)</li>
		 * <li>3 - Not Authorized (authorization declined)</li>
		 * <li>4 - Captured</li>
		 * <li>5 - Not Captured (Date time for capture expired. The authorization has been reversed)</li>
		 * <li>6 - Canceled or Reversed</li>
		 * <li>7 - Processing Pending (i.e.: Refund...)</li>
		 * <li>8 - Partial Canceled</li>
		 * <li>20 - Fully Authenticated</li>
		 * <li>21 - Authentication Attempted</li>
		 * <li>22 - Not Authenticated / Unable</li>
		 * <li>90 - Processed (apply for a PaymentAction=Create only)</li>
		 * <li>99 - Failure</li>
		 * </ul>
		 */
		public DoPaymentInquiryBuilder withStatusCode(int statusCode) {
			this.statusCode = statusCode;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Data inicial aplicada para o filtro da consulta
		 */
		public DoPaymentInquiryBuilder withStartPurchaseDateTime(Timestamp startPurchaseDateTime) {
			this.startPurchaseDateTime = startPurchaseDateTime;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Data final aplicada para o filtro da consulta
		 */
		public DoPaymentInquiryBuilder withEndPurchaseDateTime(Timestamp endPurchaseDateTime) {
			this.endPurchaseDateTime = endPurchaseDateTime;
			return this;
		}
		
		/**
		 * <u><b><i>O</i></b></u> - Limit the number of records returned to the client. Records are sorted by most recent
		 * datetime (descending order).
		 */
		public DoPaymentInquiryBuilder withRetrievalLimit(int retrievalLimit) {
			this.retrievalLimit = retrievalLimit;
			return this;
		}
		
		public DoPaymentInquiry build() {
			return new DoPaymentInquiry(this);
		}
		
	}
	
}
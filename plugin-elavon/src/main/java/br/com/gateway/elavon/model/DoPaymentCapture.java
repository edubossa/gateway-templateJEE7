package br.com.gateway.elavon.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Realiza a captura da transacao.
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
@XmlRootElement(name = "DoPaymentCapture")
@XmlAccessorType(XmlAccessType.FIELD)
public class DoPaymentCapture {
	
	@XmlAttribute
	private static final String version = "1.1.0";
	
	@XmlElement(name = "Language")
	private String language = "PT-BR";
	
	@XmlElement(name = "TransactionID")
	private String transactionID;
	
	@XmlElement(name = "CaptureAmount", required = true)
    protected DoPaymentCapture.CaptureAmount captureAmount;
	
	@XmlElement(name = "MerchantDetails")
	private MerchantDetails merchantDetails;

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class CaptureAmount {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "currencyCode")
        protected String currencyCode = "BRL";

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }
      
        public void setCurrencyCode(String value) {
            this.currencyCode = value;
        }

    }

	public static DoPaymentCaptureBuilder create() {
		return new DoPaymentCaptureBuilder();
	}
	
	protected DoPaymentCapture() {} //declaracao obrigatoria para realizacao do parse com jaxb
	
	private DoPaymentCapture(DoPaymentCaptureBuilder builder) {
		this.transactionID = builder.transactionID;
		
		this.captureAmount = new DoPaymentCapture.CaptureAmount();
		this.captureAmount.setValue(builder.captureAmount.toString().replaceAll("\\D", ""));
		
		this.merchantDetails = new MerchantDetails();
		this.merchantDetails.setTerminalID(builder.terminalID);
		this.merchantDetails.setRegKey(builder.regKey);
	}
	
	/*
	 * Builder - Design pattern
	 */
	public static class DoPaymentCaptureBuilder {
		private String transactionID;		
		private BigDecimal captureAmount;
		private String terminalID;
		private String regKey;
		
		/**
		 * <u><b><i>R</i></b></u> - Identificador unico da transacao, OBS: Nao deve ser duplicado por terminal 
		 */
		public DoPaymentCaptureBuilder withTransactionID(String transactionID) {
			this.transactionID = transactionID;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Valor de captura  
		 */
		public DoPaymentCaptureBuilder withCaptureAmount(BigDecimal captureAmount) {
			this.captureAmount = captureAmount;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Identificacao do Logista da Elavon
		 */
		public DoPaymentCaptureBuilder withTerminalID(String terminalID) {
			this.terminalID = terminalID;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Chave de afiliacao usada pela Elavon junto com o TerminalID para autenticacao das requisicoes.
		 */
		public DoPaymentCaptureBuilder withRegKey(String regKey) {
			this.regKey = regKey;
			return this;
		}
		
		public DoPaymentCapture build() {
			return new DoPaymentCapture(this);
		}
	}
	
}

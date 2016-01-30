package br.com.gateway.elavon.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "DoPaymentCancel")
@XmlAccessorType(XmlAccessType.FIELD)
public class DoPaymentCancel {
	
	@XmlAttribute
	private static final String version = "1.1.0";
	
	@XmlElement(name = "Language")
	private String language = "PT-BR";
	
	@XmlElement(name = "TransactionID")
	private String transactionID;
	
	@XmlElement(name = "CancelAmount", required = true)
    protected DoPaymentCancel.CancelAmount cancelAmount;
	
	@XmlElement(name="NotifyURL", required=true)
	protected String notifyURL;
	
	@XmlElement(name = "MerchantDetails")
	private MerchantDetails merchantDetails;

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class CancelAmount {

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

	public static DoPaymentCancelBuilder create() {
		return new DoPaymentCancelBuilder();
	}
	
	protected DoPaymentCancel() {} //declaracao obrigatoria para realizacao do parse com jaxb
	
	private DoPaymentCancel(DoPaymentCancelBuilder builder) {
		this.transactionID = builder.transactionID;
		this.notifyURL = builder.notifyURL;
		
		this.cancelAmount = new DoPaymentCancel.CancelAmount();
		this.cancelAmount.setValue(builder.cancelAmount.toString().replaceAll("\\D", ""));
		
		this.merchantDetails = new MerchantDetails();
		this.merchantDetails.setTerminalID(builder.terminalID);
		this.merchantDetails.setRegKey(builder.regKey);
		
	}
	
	/*
	 * Builder - Design pattern
	 */
	public static class DoPaymentCancelBuilder {
		
		private String transactionID;		
		private BigDecimal cancelAmount;
		private String terminalID;
		private String regKey;
		private String notifyURL;
		
		/**
		 * <u><b><i>R</i></b></u> - Identificador unico da transacao, OBS: Nao deve ser duplicado por terminal 
		 */
		public DoPaymentCancelBuilder withTransactionID(String transactionID) {
			this.transactionID = transactionID;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Valor de captura  
		 */
		public DoPaymentCancelBuilder withCancelAmount(BigDecimal cancelAmount) {
			this.cancelAmount = cancelAmount;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Identificacao do Logista da Elavon
		 */
		public DoPaymentCancelBuilder withTerminalID(String terminalID) {
			this.terminalID = terminalID;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - Chave de afiliacao usada pela Elavon junto com o TerminalID para autenticacao das requisicoes.
		 */
		public DoPaymentCancelBuilder withRegKey(String regKey) {
			this.regKey = regKey;
			return this;
		}
		
		/**
		 * <u><b><i>R</i></b></u> - URL - para notificacao do cancelamento 
		 */
		public DoPaymentCancelBuilder withNotifyURL(String notifyURL) {
			this.notifyURL = notifyURL;
			return this;
		}
		
		public DoPaymentCancel build() {
			return new DoPaymentCancel(this);
		}
	}
	
}
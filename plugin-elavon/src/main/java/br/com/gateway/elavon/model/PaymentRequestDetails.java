package br.com.gateway.elavon.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "card"
})
public class PaymentRequestDetails {

    @XmlElement(name = "Card", required = true)
    protected PaymentRequestDetails.Card card;

    public PaymentRequestDetails.Card getCard() {
        return card;
    }

    public void setCard(PaymentRequestDetails.Card value) {
        this.card = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cardProduct",
        "cardData",
        "cvv2Indicator",
        "cvv2",
        "authorizationAmount",
        "installments",
        "posEntryCapability",
        "cardEntryMode",
        "eci"
    })
    public static class Card {

        @XmlElement(name = "CardProduct", required = true)
        protected String cardProduct;
        @XmlElement(name = "CardData", required = true)
        protected String cardData;
        @XmlElement(name = "CVV2Indicator")
        protected byte cvv2Indicator = 1;
        @XmlElement(name = "CVV2")
        protected String cvv2;
        @XmlElement(name = "AuthorizationAmount", required = true)
        protected PaymentRequestDetails.Card.AuthorizationAmount authorizationAmount;
        @XmlElement(name = "Installments", required = true)
        protected PaymentRequestDetails.Card.Installments installments;
        @XmlElement(name = "POSEntryCapability")
        protected String posEntryCapability = "01";
        @XmlElement(name = "CardEntryMode")
        protected String cardEntryMode = "01";
        @XmlElement(name = "ECI")
        protected byte eci = 7;

        public String getCardProduct() {
            return cardProduct;
        }

        public void setCardProduct(String value) {
            this.cardProduct = value;
        }
        
        public String getCardData() {
            return cardData;
        }

        public void setCardData(String value) {
            this.cardData = value;
        }

        public byte getCVV2Indicator() {
            return cvv2Indicator;
        }

        public void setCVV2Indicator(byte value) {
            this.cvv2Indicator = value;
        }

        public String getCVV2() {
            return cvv2;
        }
        
        public void setCVV2(String value) {
            this.cvv2 = value;
        }
      
        public PaymentRequestDetails.Card.AuthorizationAmount getAuthorizationAmount() {
            return authorizationAmount;
        }
       
        public void setAuthorizationAmount(PaymentRequestDetails.Card.AuthorizationAmount value) {
            this.authorizationAmount = value;
        }

        
        public PaymentRequestDetails.Card.Installments getInstallments() {
            return installments;
        }

        public void setInstallments(PaymentRequestDetails.Card.Installments value) {
            this.installments = value;
        }

        public String getPOSEntryCapability() {
            return posEntryCapability;
        }
      
        public void setPOSEntryCapability(String value) {
            this.posEntryCapability = value;
        }
        
        public String getCardEntryMode() {
            return cardEntryMode;
        }
        
        public void setCardEntryMode(String value) {
            this.cardEntryMode = value;
        }
       
        public byte getECI() {
            return eci;
        }
       
        public void setECI(byte value) {
            this.eci = value;
        }

        
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class AuthorizationAmount {

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


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Installments {

            @XmlValue
            protected Integer value;
            @XmlAttribute(name = "type")
            protected String type;
      
            public Integer getValue() {
                return value;
            }
           
            public void setValue(Integer value) {
                this.value = value;
            }
      
            public String getType() {
                return type;
            }

            public void setType(String value) {
                this.type = value;
            }

        }

    }

}
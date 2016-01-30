package br.com.gateway.elavon.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "card"
})
public class PaymentResponseDetails {
	
	@XmlElement(name = "Card", required = true)
    protected Card card;

   
    public Card getCard() {
        return card;
    }

    public void setCard(Card value) {
        this.card = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "authorizationDetails",
        "captureDetails",
        "cancelDetails"
    })
    public static class Card {

        @XmlElement(name = "AuthorizationDetails", required = true)
        protected AuthorizationDetails authorizationDetails;
        @XmlElement(name = "CaptureDetails", required = true)
        protected CaptureDetails captureDetails;
        @XmlElement(name = "CancelDetails", required = true)
        protected CancelDetails cancelDetails;

       
        public AuthorizationDetails getAuthorizationDetails() {
            return authorizationDetails;
        }

        public void setAuthorizationDetails(AuthorizationDetails value) {
            this.authorizationDetails = value;
        }

        public CaptureDetails getCaptureDetails() {
            return captureDetails;
        }
        
        public void setCaptureDetails(CaptureDetails value) {
            this.captureDetails = value;
        }
      
        public CancelDetails getCancelDetails() {
            return cancelDetails;
        }

        public void setCancelDetails(CancelDetails value) {
            this.cancelDetails = value;
        }
        
    }

}

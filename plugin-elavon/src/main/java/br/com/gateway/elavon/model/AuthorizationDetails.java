package br.com.gateway.elavon.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nsuHost",
    "responseCode",
    "responseMessage",
    "issuerResponseCode",
    "cvv2Response",
    "remainingBalance",
    "amount",
    "dateTime",
    "approvalCode",
    "captureExpiration",
    "cancelExpiration"
})
public class AuthorizationDetails {

    @XmlElement(name = "NSUHost")
    protected long nsuHost;
    @XmlElement(name = "ResponseCode", required = true)
    protected ResponseCodeType responseCode;
    @XmlElement(name = "ResponseMessage", required = true)
    protected String responseMessage;
    @XmlElement(name = "IssuerResponseCode")
    protected String issuerResponseCode;
    @XmlElement(name = "CVV2Response", required = true)
    protected String cvv2Response;
    @XmlElement(name = "RemainingBalance", required = true)
    protected RemainingBalance remainingBalance;
    @XmlElement(name = "Amount", required = true)
    protected Amount amount;
    @XmlElement(name = "DateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    @XmlElement(name = "ApprovalCode", required = true)
    protected String approvalCode;
    @XmlElement(name = "CaptureExpiration", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar captureExpiration;
    @XmlElement(name = "CancelExpiration", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cancelExpiration;

    public long getNSUHost() {
        return nsuHost;
    }

    public void setNSUHost(long value) {
        this.nsuHost = value;
    }

    public ResponseCodeType getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCodeType value) {
        this.responseCode = value;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String value) {
        this.responseMessage = value;
    }

    public String getIssuerResponseCode() {
        return issuerResponseCode;
    }

    public void setIssuerResponseCode(String value) {
        this.issuerResponseCode = value;
    }

    public String getCVV2Response() {
        return cvv2Response;
    }

    public void setCVV2Response(String value) {
        this.cvv2Response = value;
    }

    public RemainingBalance getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(RemainingBalance value) {
        this.remainingBalance = value;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount value) {
        this.amount = value;
    }

    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String value) {
        this.approvalCode = value;
    }

    public XMLGregorianCalendar getCaptureExpiration() {
        return captureExpiration;
    }

    public void setCaptureExpiration(XMLGregorianCalendar value) {
        this.captureExpiration = value;
    }

    public XMLGregorianCalendar getCancelExpiration() {
        return cancelExpiration;
    }

    public void setCancelExpiration(XMLGregorianCalendar value) {
        this.cancelExpiration = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class RemainingBalance {

        @XmlValue
        protected BigDecimal value;
        @XmlAttribute(name = "currencyCode")
        protected String currencyCode;

        public BigDecimal getValue() {
            return value;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String value) {
            this.currencyCode = value;
        }

    }

}

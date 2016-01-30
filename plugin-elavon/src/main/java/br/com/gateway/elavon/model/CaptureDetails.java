package br.com.gateway.elavon.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "responseCode",
    "responseMessage",
    "amount",
    "dateTime",
    "cancelExpiration"
})
public class CaptureDetails {

    @XmlElement(name = "ResponseCode", required = true)
    protected String responseCode;
    @XmlElement(name = "ResponseMessage", required = true)
    protected String responseMessage;
    @XmlElement(name = "Amount", required = true)
    protected Amount amount;
    @XmlElement(name = "DateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    @XmlElement(name = "CancelExpiration", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cancelExpiration;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String value) {
        this.responseCode = value;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String value) {
        this.responseMessage = value;
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

    public XMLGregorianCalendar getCancelExpiration() {
        return cancelExpiration;
    }

    public void setCancelExpiration(XMLGregorianCalendar value) {
        this.cancelExpiration = value;
    }

}

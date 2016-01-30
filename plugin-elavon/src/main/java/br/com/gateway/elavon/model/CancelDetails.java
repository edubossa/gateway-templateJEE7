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
    "action"
})
public class CancelDetails {

    @XmlElement(name = "ResponseCode", required = true)
    protected String responseCode;
    @XmlElement(name = "ResponseMessage", required = true)
    protected String responseMessage;
    @XmlElement(name = "Amount", required = true)
    protected Amount amount;
    @XmlElement(name = "DateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    @XmlElement(name = "Action", required = true)
    protected String action;

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

    public String getAction() {
        return action;
    }

    public void setAction(String value) {
        this.action = value;
    }

}


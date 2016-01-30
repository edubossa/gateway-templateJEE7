package br.com.gateway.elavon.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "terminalID",
    "transactionID",
    "responseCode",
    "responseMessage",
    "dateTime",
    "errorMessage"
})
public class ErrorDetails {

    @XmlElement(name = "TerminalID", required = true)
    protected String terminalID;
    @XmlElement(name = "TransactionID", required = true)
    protected String transactionID;
    @XmlElement(name = "ResponseCode", required = true)
    protected String responseCode;
    @XmlElement(name = "ResponseMessage", required = true)
    protected String responseMessage;
    @XmlElement(name = "DateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    @XmlElement(name = "ErrorMessage", required = true)
    protected String errorMessage;

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String value) {
        this.terminalID = value;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String value) {
        this.transactionID = value;
    }

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

    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

}

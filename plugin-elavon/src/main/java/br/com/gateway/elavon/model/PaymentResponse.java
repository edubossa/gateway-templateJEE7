package br.com.gateway.elavon.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ack",
    "errorDetails",
    "transactionID",
    "statusCode",
    "merchantDetails",
    "paymentResponseDetails"
})
@XmlRootElement(name = "PaymentResponse")
public class PaymentResponse {

    @XmlElement(name = "Ack", required = true)
    protected String ack;
    @XmlElement(name = "ErrorDetails")
    protected ErrorDetails errorDetails;
    @XmlElement(name = "TransactionID", required = true)
    protected String transactionID;
    @XmlElement(name = "StatusCode")
    protected int statusCode;
    @XmlElement(name = "MerchantDetails", required = true)
    protected MerchantDetails merchantDetails;
    @XmlElement(name = "PaymentResponseDetails", required = true)
    protected PaymentResponseDetails paymentResponseDetails;
    @XmlAttribute(name = "version")
    protected String version;
 
    public String getAck() {
        return ack;
    }

    public void setAck(String value) {
        this.ack = value;
    }
    
    /** Transacao realizada com sucesso **/
    public boolean success() {
    	return this.ack.equals("Success");
    }
    
    /** TRansacao realizada com falha **/
    public boolean failure() {
    	return this.ack.equals("Failure");
    }
    
    public ErrorDetails getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(ErrorDetails value) {
        this.errorDetails = value;
    }

    /** Unique TransactionID created in the DoPayment transaction. **/
    public String getTransactionID() {
        return transactionID;
    }
   
    public void setTransactionID(String value) {
        this.transactionID = value;
    }

    public int getStatusCode() {
        return statusCode;
    }
    
    public void setStatusCode(int value) {
        this.statusCode = value;
    }

   
    public MerchantDetails getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(MerchantDetails value) {
        this.merchantDetails = value;
    }

    public PaymentResponseDetails getPaymentResponseDetails() {
        return paymentResponseDetails;
    }

    public void setPaymentResponseDetails(PaymentResponseDetails value) {
        this.paymentResponseDetails = value;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

}

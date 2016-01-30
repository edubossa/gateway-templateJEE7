package br.com.gateway.elavon.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ack",
    "transactionCount",
    "paymentTransaction"
})
@XmlRootElement(name = "PaymentTransactionList")
public class PaymentTransactionList {

    @XmlElement(name = "Ack", required = true)
    protected String ack;
    @XmlElement(name = "TransactionCount")
    protected byte transactionCount;
    @XmlElement(name = "PaymentTransaction")
    protected List<PaymentTransactionList.PaymentTransaction> paymentTransaction;
    @XmlAttribute(name = "version")
    protected String version;

    
    public String getAck() {
        return ack;
    }

    public void setAck(String value) {
        this.ack = value;
    }

    public byte getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(byte value) {
        this.transactionCount = value;
    }

    public List<PaymentTransactionList.PaymentTransaction> getPaymentTransaction() {
        if (paymentTransaction == null) {
            paymentTransaction = new ArrayList<PaymentTransactionList.PaymentTransaction>();
        }
        return this.paymentTransaction;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "transactionID",
        "paymentAction",
        "ipAddress",
        "language",
        "statusCode",
        "merchantDetails",
        "purchaseDetails",
        "paymentRequestDetails",
        "paymentResponseDetails"
    })
    public static class PaymentTransaction {

        @XmlElement(name = "TransactionID", required = true)
        protected String transactionID;
        @XmlElement(name = "PaymentAction", required = true)
        protected String paymentAction;
        @XmlElement(name = "IPAddress", required = true)
        protected String ipAddress;
        @XmlElement(name = "Language", required = true)
        protected String language;
        @XmlElement(name = "StatusCode")
        protected byte statusCode;
        @XmlElement(name = "MerchantDetails", required = true)
        protected PaymentTransactionList.PaymentTransaction.MerchantDetails merchantDetails;
        @XmlElement(name = "PurchaseDetails", required = true)
        protected PaymentTransactionList.PaymentTransaction.PurchaseDetails purchaseDetails;
        @XmlElement(name = "PaymentRequestDetails", required = true)
        protected PaymentRequestDetails paymentRequestDetails;
        @XmlElement(name = "PaymentResponseDetails", required = true)
        protected PaymentResponseDetails paymentResponseDetails;
        @XmlAttribute(name = "version")
        protected String version;

        public String getTransactionID() {
            return transactionID;
        }

        public void setTransactionID(String value) {
            this.transactionID = value;
        }

        public String getPaymentAction() {
            return paymentAction;
        }

        public void setPaymentAction(String value) {
            this.paymentAction = value;
        }

        public String getIPAddress() {
            return ipAddress;
        }

        public void setIPAddress(String value) {
            this.ipAddress = value;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String value) {
            this.language = value;
        }

        public byte getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(byte value) {
            this.statusCode = value;
        }

        public PaymentTransactionList.PaymentTransaction.MerchantDetails getMerchantDetails() {
            return merchantDetails;
        }

        public void setMerchantDetails(PaymentTransactionList.PaymentTransaction.MerchantDetails value) {
            this.merchantDetails = value;
        }

        public PaymentTransactionList.PaymentTransaction.PurchaseDetails getPurchaseDetails() {
            return purchaseDetails;
        }

        public void setPurchaseDetails(PaymentTransactionList.PaymentTransaction.PurchaseDetails value) {
            this.purchaseDetails = value;
        }

        public PaymentRequestDetails getPaymentRequestDetails() {
            return paymentRequestDetails;
        }

        public void setPaymentRequestDetails(PaymentRequestDetails value) {
            this.paymentRequestDetails = value;
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

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "terminalID",
            "partnerID"
        })
        public static class MerchantDetails {

            @XmlElement(name = "TerminalID", required = true)
            protected BigInteger terminalID;
            @XmlElement(name = "PartnerID")
            protected String partnerID;

            public BigInteger getTerminalID() {
                return terminalID;
            }

            public void setTerminalID(BigInteger value) {
                this.terminalID = value;
            }

            public String getPartnerID() {
                return partnerID;
            }

            public void setPartnerID(String value) {
                this.partnerID = value;
            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "additionalID",
            "totalAmount",
            "dateTime",
            "orderDescription"
        })
        public static class PurchaseDetails {

            @XmlElement(name = "AdditionalID", required = true)
            protected String additionalID;
            @XmlElement(name = "TotalAmount", required = true)
            protected PaymentTransactionList.PaymentTransaction.PurchaseDetails.TotalAmount totalAmount;
            @XmlElement(name = "DateTime", required = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dateTime;
            @XmlElement(name = "OrderDescription", required = true)
            protected String orderDescription;

            public String getAdditionalID() {
                return additionalID;
            }

            public void setAdditionalID(String value) {
                this.additionalID = value;
            }

            public PaymentTransactionList.PaymentTransaction.PurchaseDetails.TotalAmount getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(PaymentTransactionList.PaymentTransaction.PurchaseDetails.TotalAmount value) {
                this.totalAmount = value;
            }

          
            public XMLGregorianCalendar getDateTime() {
                return dateTime;
            }

            public void setDateTime(XMLGregorianCalendar value) {
                this.dateTime = value;
            }

            public String getOrderDescription() {
                return orderDescription;
            }

            public void setOrderDescription(String value) {
                this.orderDescription = value;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class TotalAmount {

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

    }

}

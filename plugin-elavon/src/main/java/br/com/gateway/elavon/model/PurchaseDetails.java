package br.com.gateway.elavon.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "additionalID",
        "totalAmount",
        "dateTime",
        "orderDescription"
    })
public class PurchaseDetails {

	@XmlElement(name = "AdditionalID")
	private String additionalID;
	
	@XmlElement(name = "TotalAmount", required = true)
    protected PurchaseDetails.TotalAmount totalAmount;

	@XmlElement(name = "DateTime")
	private String dateTime;

	@XmlElement(name = "OrderDescription")
	private String orderDescription;

	public String getAdditionalID() {
		return additionalID;
	}

	public void setAdditionalID(String additionalID) {
		this.additionalID = additionalID;
	}

	public PurchaseDetails.TotalAmount getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(PurchaseDetails.TotalAmount value) {
        this.totalAmount = value;
    }

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class TotalAmount {

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

}

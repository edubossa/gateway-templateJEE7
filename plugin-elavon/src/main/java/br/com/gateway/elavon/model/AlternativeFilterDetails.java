package br.com.gateway.elavon.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class AlternativeFilterDetails {

	@XmlElement(name = "StatusCode")
	private int statusCode;

	@XmlElement(name = "StartPurchaseDateTime")
	private String startPurchaseDateTime;

	@XmlElement(name = "EndPurchaseDateTime")
	private String endPurchaseDateTime;

	@XmlElement(name = "RetrievalLimit")
	private int retrievalLimit;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStartPurchaseDateTime() {
		return startPurchaseDateTime;
	}

	public void setStartPurchaseDateTime(String startPurchaseDateTime) {
		this.startPurchaseDateTime = startPurchaseDateTime;
	}

	public String getEndPurchaseDateTime() {
		return endPurchaseDateTime;
	}

	public void setEndPurchaseDateTime(String endPurchaseDateTime) {
		this.endPurchaseDateTime = endPurchaseDateTime;
	}

	public int getRetrievalLimit() {
		return retrievalLimit;
	}

	public void setRetrievalLimit(int retrievalLimit) {
		this.retrievalLimit = retrievalLimit;
	}

}
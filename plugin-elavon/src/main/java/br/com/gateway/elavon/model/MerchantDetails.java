package br.com.gateway.elavon.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class MerchantDetails {

	@XmlElement(name = "TerminalID")
	private String terminalID;

	@XmlElement(name = "RegKey")
	private String regKey;

	public String getTerminalID() {
		return terminalID;
	}

	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}

	public String getRegKey() {
		return regKey;
	}

	public void setRegKey(String regKey) {
		this.regKey = regKey;
	}

}

package br.com.gateway.elavon.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Transaction processing response codes. 
 * <p>
 * <b>Any code other than AA means no approval.</b>
 * 
 * @author Eduardo Wallace
 * @since 19/18/2015
 */
@XmlType(name = "ResponseCode")
@XmlEnum(String.class)
public enum ResponseCodeType {
	
	/** Successful Transaction Processing : Approval/Completion **/
	AA,
	
	/** Transaction Declined **/
	ND,
	
	/** Transaction Pending for Processing: i.e.: Refund, Batch **/
	PP,
	
	/** Declined (Invalid Message Structure or Type mismatch) **/
	E0,
	
	/** Declined (Invalid Merchant Credentials) **/
	E1,
	
	/** Declined (Merchant not enabled) **/
	E2,
	
	/** Declined (Transaction not found) **/
	E3,
	
	/** Declined (Transaction duplicated) **/
	E4,
	
	/** Declined (Transaction type is not supported or available/enabled for your merchant) **/
	E5,
	
	/** Declined (Inconsistency/Invalid value /out of business rules) **/
	E6,
	
	/** Declined (Transaction status does not allow the requested operation) **/
	E7,
	
	/** Declined (Missing required/mandatory fields) **/
	E8,
	
	/** Expired Request (Request for this transaction type has expired. i.e.: Capture Expired) **/
	EX,
	
	/** Unexpected Error (If persists, contact Elavon) **/
	UE,
	
	/** System Temporarily Unavailable ( if persists, contact Elavon) **/
	SU,
	
	/** Timed out ( If persists, contact Elavon) **/
	TO;
	
}

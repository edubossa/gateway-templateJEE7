package br.com.gateway.elavon.model;

/**
 * E-Commerce Transaction Security Level
 * <p>
 * Security level associated with an E-Commerce transaction. UCAF is the ECI
 * corresponding value from MasterCard.
 * <p>
 * Liability Shift rules may vary from market to market. Check the rules with
 * your commercial representative.
 * <p>
 * <b>This table applies for E-Commerce only.</b>
 * 
 * @author Eduardo Wallace
 * @since 18/09/2015
 */
public enum CardECIType {

	/** Issuer Liable - Suport VISA VERIFIED, MasterCard SecureCode. **/
	FULL_AUTHENTICATION((byte)5),

	/** Merchant Liable - Suport VISA VERIFIED, MasterCard SecureCode. **/
	ATTEMPT_AUTHENTICATION((byte)6),

	/** Merchant Liable - Suporte Todas as Bandeiras da Elavon **/
	AUTHENTICATION_STANDARD_SSL((byte)7);

	private byte value;

	private CardECIType(byte value) {
		this.value = value;
	}

	public byte getValue() {
		return value;
	}

}

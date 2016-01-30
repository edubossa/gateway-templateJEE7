package br.com.gateway.elavon.model;

/**
 * Representacao das bandeiras disponiveis pala Elavon.
 * 
 * @author Eduardo Wallace
 * @since 17/08/2015
 */
public enum CardProductType {
	
	VISA_CREDIT ("Visa.Credit"),
	//VISA_DEBIT ("Visa.Debit"),
	MASTERCARD_CREDIT ("MA.Credit"),
	//MASTERCARD_DEBIT ("MA.Debit"),
	DINERS_CREDIT ("Diners.Credit"),
	DISCOVER_CREDIT ("Discover.Credit"); 
	
	private String card;

	private CardProductType(String card) {
		this.card = card;
	}

	public String getCard() {
		return card;
	}	
	
	public static CardProductType getBandeira(String bandeira) {
		for(CardProductType type :  values()) {
			if (type.name().contains(bandeira)) return type;
		}
		
		return null;
	}
	
}
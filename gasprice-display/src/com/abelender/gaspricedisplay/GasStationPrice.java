package com.abelender.gaspricedisplay;

public class GasStationPrice {
	
	private String id;
	private String regularPrice;
	private String premiumPrice;
	private String dieselPrice;
	


	public String getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(String regularPrice) {
		this.regularPrice = regularPrice;
	}

	public String getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(String premiumPrice) {
		this.premiumPrice = premiumPrice;
	}

	public String getDieselPrice() {
		return dieselPrice;
	}

	public void setDieselPrice(String dieselPrice) {
		this.dieselPrice = dieselPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

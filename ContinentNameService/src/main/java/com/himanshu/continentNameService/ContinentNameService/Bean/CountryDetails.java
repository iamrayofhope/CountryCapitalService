package com.himanshu.continentNameService.ContinentNameService.Bean;

public class CountryDetails {

	private String countryName;
	private String continentName;

	public CountryDetails(String countryName, String continentName) {
		super();
		this.countryName = countryName;
		this.continentName = continentName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

}

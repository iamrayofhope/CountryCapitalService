package com.himanshu.capitalNameService.CapitalNameService.Bean;

public class ContinentDetails {

	private String countryName;
	private String countryCapital;
	private String continentName;
	
	public ContinentDetails() {
		// TODO Auto-generated constructor stub
	}

	public ContinentDetails(String countryName, String countryCapital, String continentName) {
		this.countryName = countryName;
		this.countryCapital = countryCapital;
		this.continentName = continentName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCapital() {
		return countryCapital;
	}

	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

}

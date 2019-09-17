package com.himanshu.capitalNameService.CapitalNameService.Bean;

import java.io.Serializable;

public class CountryDetails implements Serializable {

	private static final long serialVersionUID = -1243823611699512L;

	private String CountryName;
	private String CountryCapital;

	public CountryDetails() {

	}

	public CountryDetails(String countryName, String countryCapital) {
		CountryName = countryName;
		CountryCapital = countryCapital;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public String getCountryCapital() {
		return CountryCapital;
	}

	public void setCountryCapital(String countryCapital) {
		CountryCapital = countryCapital;
	}

}
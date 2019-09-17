package com.himanshu.capitalNameService.CapitalNameService.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.himanshu.capitalNameService.CapitalNameService.Bean.ContinentDetails;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import au.com.bytecode.opencsv.CSVReader;

@Service
public class CapitalService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	public String getCapitalName(String countryName) throws IOException {
		CSVReader csvReader = new CSVReader(new FileReader("E:/Himanshu/country-capitals.csv"));
		String[] nextLine;
		try {
			while ((nextLine = csvReader.readNext()) != null) {
				if (nextLine[0].equalsIgnoreCase(countryName)) {
					return nextLine[1];
				}
			}
		} finally {
			csvReader.close();
		}
		return null;
	}

	@HystrixCommand(fallbackMethod = "getCountryDetailsFallback")
	public ContinentDetails getCountryDetails(String countryName) {
		List<ServiceInstance> instances = discoveryClient.getInstances("zuul-service");
		ServiceInstance serviceInstance = instances.get(0);
		String URL = serviceInstance.getUri().toString();
		String continentURL = URL + "/api/cons/continentDetails/" + countryName;
		System.out.println(continentURL);
		/*
		 * String continentURL = "http://localhost:8084/continentDetails/"+
		 * countryName;
		*/
		ContinentDetails continentDetails = restTemplate.getForObject(continentURL, ContinentDetails.class);
		if (continentDetails != null) {
			return continentDetails;
		} else
			return null;
	}

	public ContinentDetails getCountryDetailsFallback(String countryName) {
		ContinentDetails continentDetails = new ContinentDetails("Wakanda", "Birmin Zana", "Mid-West Africa");
		return continentDetails;
	}
}

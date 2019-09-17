package com.himanshu.capitalNameService.CapitalNameService.Controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.himanshu.capitalNameService.CapitalNameService.Bean.ContinentDetails;
import com.himanshu.capitalNameService.CapitalNameService.Bean.CountryDetails;
import com.himanshu.capitalNameService.CapitalNameService.Service.CapitalService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@CrossOrigin
public class CapitalController {

	private static final Logger logger = LoggerFactory.getLogger(CapitalController.class);

	@Autowired
	private CapitalService capitalService;

	@RequestMapping(value = "/countryName/{countryName}", method = RequestMethod.GET)
	@Cacheable("capitalName")
	public ResponseEntity<CountryDetails> getCapitalName(@PathVariable String countryName) {
		String capitalName = null;
		ResponseEntity<CountryDetails> responseEntity = null;
		try {
			capitalName = capitalService.getCapitalName(countryName);
			CountryDetails countryDetails = new CountryDetails();
			countryDetails.setCountryName(countryName);
			countryDetails.setCountryCapital(capitalName);
			if (capitalName != null) {
				responseEntity = new ResponseEntity<CountryDetails>(countryDetails, HttpStatus.OK);
				logger.info(capitalName+" Testing Cache");
				return responseEntity;
			} else {
				responseEntity = new ResponseEntity<CountryDetails>(HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseEntity;
	}

	@HystrixCommand
	@GetMapping(value = "/countryDetailsAll/{countryName}")
	public ResponseEntity<ContinentDetails> getCountryDetailsAll(@PathVariable String countryName) throws IOException {
		String countryCapital = null;
		ResponseEntity<ContinentDetails> responseEntity = null;
		try {
			ContinentDetails continentDetails = capitalService.getCountryDetails(countryName);
			countryCapital = capitalService.getCapitalName(countryName);
			if (continentDetails != null) {
				if (countryCapital != null && continentDetails.getContinentName() != null) {
					continentDetails.setCountryCapital(countryCapital);
					responseEntity = new ResponseEntity<ContinentDetails>(continentDetails, HttpStatus.OK);
					return responseEntity;
				}
			} else {
				responseEntity = new ResponseEntity<ContinentDetails>(HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<ContinentDetails>(HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
		return responseEntity;
	}
}
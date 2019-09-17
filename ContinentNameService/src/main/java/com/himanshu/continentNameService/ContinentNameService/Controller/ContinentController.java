package com.himanshu.continentNameService.ContinentNameService.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.himanshu.continentNameService.ContinentNameService.Bean.CountryDetails;
import com.himanshu.continentNameService.ContinentNameService.Service.ContinentService;

@RestController
@CrossOrigin
public class ContinentController {

	@Autowired
	private ContinentService continentService;

	@GetMapping(value = "/continentDetails/{countryName}")
	public ResponseEntity<CountryDetails> getContinentDetails(@PathVariable String countryName) {
		ResponseEntity<CountryDetails> responseEntity = null;
		String continentName = null;
		try {
			continentName = continentService.getContinentName(countryName);
			if (continentName != null) {
				CountryDetails countryDetails = new CountryDetails(countryName, continentName);
				responseEntity = new ResponseEntity<CountryDetails>(countryDetails, HttpStatus.OK);
				return responseEntity;
			} else {
				responseEntity = new ResponseEntity<CountryDetails>(HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
		} catch (IOException e) {
			responseEntity = new ResponseEntity<CountryDetails>(HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
	}
}
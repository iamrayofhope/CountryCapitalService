package com.himanshu.continentNameService.ContinentNameService.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;

@Service
public class ContinentService {

	public String getContinentName(String countryName) throws IOException {
		CSVReader csvReader = new CSVReader(new FileReader("D:/Himanshu/country-capitals.csv"));
		String[] nextLine;
		try {
			while ((nextLine = csvReader.readNext()) != null) {
				if (nextLine[0].equalsIgnoreCase(countryName)) {
					return nextLine[5];
				}
			}
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		} finally {
			csvReader.close();
		}
		return null;
	}
}

package com.bluewhale.Importutils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CsvReader {

	List<String[]> allData;

	String[] actualHeader;

	String[] expectedHeader = { "tripId", "fromCity", "toCity", "busType", "totalSeats", "availSeats", "departureDate",
			"departureTime" };

	public List<String[]> readData(String file) {
		try {

			FileReader filereader = new FileReader(file);

			CSVReader csvReader = new CSVReaderBuilder(filereader).build();

			allData = csvReader.readAll();
			actualHeader = allData.get(0);

			boolean isValid = validateHeader(Arrays.asList(actualHeader), Arrays.asList(expectedHeader));

			if (isValid) {

				// print Data
				for (String[] row : allData) {

					for (String cell : row) {
						System.out.print(cell + "\t");
					}
					System.out.println();

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return allData;
	}

	boolean validateHeader(List<String> actualHeader, List<String> expectedHeader) {

		if (actualHeader.equals(expectedHeader)) {

			return true;
		}
		return false;

	}

}

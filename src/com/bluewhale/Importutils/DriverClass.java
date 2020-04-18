package com.bluewhale.Importutils;

import java.io.FileNotFoundException;
import java.util.List;

public class DriverClass {

	public static void main(String[] args) throws FileNotFoundException {
		CsvReader csvReader = new CsvReader();

		List<String[]> fileData = csvReader.readData("./src/bus.csv");

		DbWriter.writeToDb(fileData);

	}

}
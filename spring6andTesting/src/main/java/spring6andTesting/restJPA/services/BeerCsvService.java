package spring6andTesting.restJPA.services;

import java.io.File;
import java.util.List;

import spring6andTesting.restJPA.model.BeerCSVRecord;

public interface BeerCsvService {
	
	 List<BeerCSVRecord> convertCSV(File csvFile);

}

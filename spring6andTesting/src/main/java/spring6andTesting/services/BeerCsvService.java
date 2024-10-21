package spring6andTesting.services;

import java.io.File;
import java.util.List;

import spring6andTesting.model.BeerCSVRecord;

public interface BeerCsvService {
	
	 List<BeerCSVRecord> convertCSV(File csvFile);

}

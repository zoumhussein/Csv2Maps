package fr.zoumanatraore.csv.core;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import fr.zoumanatraore.csv.core.CSVParserImpl;
import junit.framework.TestCase;

public class CSVParserImplTest extends TestCase {

	private Parser serviceCSVParser = new CSVParserImpl();
	
	@Autowired
	private Parser serviceParser;
	
	public void testParseFile() throws Exception {
		File sampleFile = new File("/Users/invite/downloads/FL_insurance_sample.csv");
		serviceCSVParser.parseFile(sampleFile);
	}

}

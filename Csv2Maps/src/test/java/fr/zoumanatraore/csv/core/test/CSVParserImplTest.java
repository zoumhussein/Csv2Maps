package fr.zoumanatraore.csv.core.test;

import java.io.File;

import junit.framework.TestCase;

import org.springframework.beans.factory.annotation.Autowired;

import fr.zoumanatraore.csv.core.CSVParserImpl;
import fr.zoumanatraore.csv.core.Parser;

public class CSVParserImplTest extends TestCase {

	private Parser serviceCSVParser = new CSVParserImpl();
	
	@Autowired
	private Parser serviceParser;
	
	public void testParseFile() throws Exception {
		File sampleFile = new File("/Users/invite/downloads/FL_insurance_sample.csv");
		serviceCSVParser.parseFile(sampleFile);
	}

}

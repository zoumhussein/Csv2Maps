package fr.zoumanatraore.csv.core.test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.zoumanatraore.csv.core.CSVParserImpl;
import fr.zoumanatraore.csv.core.Parser;

public class CSVParserTestCase {

	private Parser serviceCSVParser = new CSVParserImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testParseFileFile() {
		File sampleCSV = new File("C:\\XML\\input\\test2.csv");
		File sampleCSVWithSemiColon = new File("C:\\XML\\input\\test.csv");
		try {
			serviceCSVParser.parseFile(sampleCSV);
			serviceCSVParser.parseFile(sampleCSVWithSemiColon, ';');
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("Exception caught during the test", false);
		}
	}

}

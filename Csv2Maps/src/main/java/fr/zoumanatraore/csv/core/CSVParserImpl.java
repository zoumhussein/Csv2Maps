package fr.zoumanatraore.csv.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.csvreader.CsvReader;

/**
 * 
 * @author Zoumana TRAORE
 *         <p>
 *         Implementation of {@link Parser} interface <br/>
 *         This implementation is specialized in parsing CSV file type data.
 *         </p>
 * 
 *         <p>
 *         This program is under GNU LGPL v3
 *         http://www.gnu.org/licenses/lgpl-3.0.txt
 *         </p>
 */
@Component
public class CSVParserImpl implements Parser {

	private static final Log LOGGER = LogFactory.getLog(CSVParserImpl.class);

	/**
	 * <p>
	 * Parse a CVS file and extract map for each record line.
	 * </p>
	 * 
	 * @param file
	 *            : input file
	 * @return List of maps (one map for each record line in the file)
	 * @throws IOException
	 */
	public List<HashMap<String, String>> parseFile(File file)
			throws IOException {

		// JavaCSV API reader
		CsvReader reader = null;

		// Parse the CSV
		reader = new CsvReader(file.getAbsolutePath());

		return formatCsvContent(reader);
	}

	/**
	 * <p>
	 * Parse a CVS file and extract map for each record line.
	 * </p>
	 * 
	 * @param fileFullpath
	 *            : full path of the input file
	 * @return List of maps (one map for each record line in the file)
	 * @throws IOException
	 */
	public List<HashMap<String, String>> parseFile(final String fileFullpath)
			throws IOException {
		return parseFile(new File(fileFullpath));
	}

	/**
	 * <p>
	 * Parse a CVS file and extract map for each record line.
	 * </p>
	 * 
	 * @param fileFullpath
	 *            : full path of the input file
	 * @param separator
	 *            : CSV separator character
	 * @return List of maps (one map for each record line in the file)
	 * @throws IOException
	 */
	public List<HashMap<String, String>> parseFile(final String fileFullpath,
			char separator) throws IOException {
		return parseFile(new File(fileFullpath), separator);
	}

	/**
	 * <p>
	 * Parse a CVS file (with a given separator character) and extract map for
	 * each record line.
	 * </p>
	 * 
	 * @param file
	 *            : input file
	 * @param separator
	 * @return List of maps (one map for each record line in the file)
	 * @throws IOException
	 */
	public List<HashMap<String, String>> parseFile(File file, char separator)
			throws FileNotFoundException, IOException {

		// JavaCSV API reader
		CsvReader reader = null;

		// Parse the CSV
		reader = new CsvReader(file.getAbsolutePath(), separator, StandardCharsets.UTF_8);

		return formatCsvContent(reader);
	}

	private List<HashMap<String, String>> formatCsvContent(CsvReader reader)
			throws IOException {

		// Map to contain per Line (columnName,value)
		HashMap<String, String> recordLineData = new HashMap<String, String>();

		// List to contain all lines (columnName,value) Map
		List<HashMap<String, String>> listOfLines = new ArrayList<HashMap<String, String>>();

		// Debug columns number
		LOGGER.debug("columns count: " + reader.getColumnCount());

		// Debug headers
		reader.readHeaders();
		LOGGER.debug("headers count: " + reader.getHeaderCount());

		String[] headers = reader.getHeaders();
		for (String columnName : headers) {
			LOGGER.debug("column name: " + columnName);
		}

		// Debug line by line the data
		int numberOfLines = 0;
		boolean hasRecords = reader.readRecord();
		while (hasRecords) {
			for (String columnName : headers) {

				// Put in the Map the value for each column on the record line
				recordLineData.put(columnName, reader.get(columnName));
			}

			// At the end of the record line processing: we put the line Map
			// into the list of lines Maps
			listOfLines.add(recordLineData);

			// We increment the line counter and check if there is another line
			// record to process
			numberOfLines++;
			recordLineData = new HashMap<String, String>();
			hasRecords = reader.readRecord();
		}

		LOGGER.debug("number of line in the CSV file: " + numberOfLines);

		return listOfLines;

	}

}

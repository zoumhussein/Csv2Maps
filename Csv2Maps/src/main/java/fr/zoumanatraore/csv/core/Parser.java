package fr.zoumanatraore.csv.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Zoumana TRAORE
 * <p>
 * 	This is an interface which has a method to parse file and generate List of Map data.
 *  <br/> The list contains maps
 *  <br/> Each map contains keys,values: where key is a column name and value the value of this column for a specific line of record 
 * </p>
 * <p>
 * 	This program is under GNU LGPL v3 http://www.gnu.org/licenses/lgpl-3.0.txt
 * </p>
 */
@Component
public interface Parser {
	
	/**
	 * parse a file
	 * @param input file
	 * @return List of maps (one map for each record line in the file)
	 * @throws IOException 
	 */
	List<HashMap<String, String>> parseFile(File file) throws FileNotFoundException, IOException;

	/**
	 * 
	 * @param fileFullpath
	 * @return List of maps (one map for each record line in the file)
	 * @throws FileNotFoundException
	 * @throws IOException 
	 */
	List<HashMap<String, String>> parseFile(String fileFullpath)
			throws FileNotFoundException, IOException;
	
	/**
	 * parse a file with the given separator character
	 * @param input file
	 * @param separator character
	 * @return List of maps (one map for each record line in the file)
	 * @throws IOException 
	 */
	List<HashMap<String, String>> parseFile(File file, char separator) throws FileNotFoundException, IOException;

	/**
 	 * parse a file with the given separator character
	 * @param fileFullpath
	 * @param separator
	 * @return
	 * @throws IOException
	 */
	List<HashMap<String, String>> parseFile(String fileFullpath, char separator)
			throws IOException;


}

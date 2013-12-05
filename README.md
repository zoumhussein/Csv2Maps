Csv2Maps
========

This is a free Java library which parse CSV file to List of Maps (a Map for each line of records with column, value associations)

We parse all the time CSV and such format like file in order to retreive data in many, many programms.
We have to do, each time the same block of code: open the file, parse it, retrieved headers and records lines, map header with value for each line and then do some usefull thing with this value. 

End of it with CSV2Maps !!!

In 2 lines, you can have your CSV file nicely parsed and you get in result a perfectly fit data format: 
		
		CSVParserImpl csvParser = new CSVParserImpl();
		List<HashMap<String, String>> listOfMaps = csvParser.parseFile(myCSVFile, myCSVDelimiter);

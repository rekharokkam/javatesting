package com.wine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

public class CSVDataLoader implements FileDataLoader
{
	public List<StringTable> populateStringTableRows (String fileName) 
	{
		List<StringTable> csvStringTables = new ArrayList<StringTable>();
		try
		{
			CsvReader csvReader = new CsvReader(fileName, '	' );

			//Just read the headers but do not process them
			csvReader.readHeaders();
			
			while (csvReader.readRecord())
			{
				try
				{
					StringTable stringTable = new StringTable();
					stringTable.setStringId(Integer.parseInt(csvReader.get("string_id")));
					stringTable.setLocale(csvReader.get("locale"));
					stringTable.setTextId(Integer.parseInt(csvReader.get("text_id")));
					stringTable.setStringStr(csvReader.get("string"));
					stringTable.setGroupId(csvReader.get("group_id"));
					stringTable.setUsageNotes(csvReader.get("usage_notes"));
					
					csvStringTables.add(stringTable);
				}
				catch (Exception exception)
				{
System.err.println("Logging troublesome entries : " + csvReader.get("string_id") + " \t : Text Id : " + csvReader.get("text_id"));					
				}
			}

		}
		catch (FileNotFoundException fileNotFoundException)
		{
System.err.println("fileNotFoundException occured while reading the CSV File");
fileNotFoundException.printStackTrace(System.err);
		}
		catch (IOException ioException)
		{
System.err.println("ioException occured while reading the CSV File");
ioException.printStackTrace(System.err);
		}
		return csvStringTables;		
	}

	public void writeDataToFile (List<StringTable> dev, List<StringTable> prod)
	{
		//No Implementation required
	}
}

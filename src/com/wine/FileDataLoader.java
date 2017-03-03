package com.wine;

import java.util.List;

public interface FileDataLoader 
{
	List<StringTable> populateStringTableRows(String fileName);
	
	void writeDataToFile (List<StringTable> dev, List<StringTable> prod);
}

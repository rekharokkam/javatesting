package com.wine;

import java.util.ArrayList;
import java.util.List;

public class StringTableDataComparer {

	public static void main(String[] args) 
	{
		
		FileDataLoader csvDataLoader = new CSVDataLoader();
		FileDataLoader excelDataLoader = new ExcelDataLoader();
		
		List<StringTable> dev = csvDataLoader.populateStringTableRows("db/dev_string_table.txt");
		List<StringTable> prod = excelDataLoader.populateStringTableRows("db/prod_string_table_2017-02-28.xlsx");
		
System.out.println("dev Size : " + dev.size());		
System.out.println("prod Size : " + prod.size());

		List<StringTable> devDifferent = new ArrayList<StringTable>();
		List<StringTable> prodDifferent = new ArrayList<StringTable>();

		int differentRecordCounter = 0;
		
		for (int i = 0; i < prod.size(); i ++)
		{
			//compare both String tables
			if (! dev.get(i).equals(prod.get(i)) )
			{
				differentRecordCounter ++;
				
				devDifferent.add(dev.get(i));
				prodDifferent.add(prod.get(i));
			}
		}		

System.out.println("Different record count : " + differentRecordCounter);

		excelDataLoader.writeDataToFile(devDifferent, prodDifferent);
	}
}

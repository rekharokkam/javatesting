package com.wine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataLoader implements FileDataLoader 
{
	@Override
	public List<StringTable> populateStringTableRows(String fileName) 
	{
		List<StringTable> excelStringTables = new ArrayList<StringTable>();
		try
        {
            FileInputStream file = new FileInputStream(new File(fileName));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            
            if (rowIterator.hasNext())
            {
            	rowIterator.next();
            }
            
            
            while (rowIterator.hasNext()) 
            {
            	Row row = rowIterator.next();
            
            	StringTable stringTable = new StringTable();

                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 
                Cell stringId = cellIterator.next();
				stringTable.setStringId((int)Double.parseDouble(stringId.toString()));
				
				Cell locale = cellIterator.next();
				stringTable.setLocale(locale.toString());
				
				Cell textId = cellIterator.next();
				stringTable.setTextId((int)Double.parseDouble(textId.toString()));
				
				Cell string = cellIterator.next();
				stringTable.setStringStr(string.toString());
				
				Cell groupId = cellIterator.next();
				stringTable.setGroupId(groupId.toString());
				
				Cell usageNotes = cellIterator.next();
				stringTable.setUsageNotes(usageNotes.toString());
				                
                excelStringTables.add (stringTable);               
                
            }

            file.close();
        } 
        catch (Exception e) 
        {
e.printStackTrace(System.err);
        }
		
		return excelStringTables;
	}

	public void writeDataToFile (List<StringTable> dev, List<StringTable> prod)
	{
		try
		{
			File file = new File("db/dev_prod_different.xlsx");
			file.createNewFile();
			
			FileOutputStream outputStream = new FileOutputStream(file);
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("String_table");
			
			String[] stringTableHeaders = {"Dev_String_id", "Prod_String_id", "Dev_Text_id", "Prod_Text_id", "Dev_String", "Prod_String"};
		 
			Row headerRow = sheet.createRow(0);
		    int headerRowCellCount = 0;
		    for (String eachCellHeader : stringTableHeaders)
		    {
		    	Cell headerCell = headerRow.createCell(headerRowCellCount ++);
		    	headerCell.setCellValue(eachCellHeader);
		    }
		    
		    for (int i = 0; i < dev.size(); i ++)
		    {
		    	Row bodyRow = sheet.createRow(i + 1);
			    
			    Cell devCellStringId = bodyRow.createCell(0);
			    devCellStringId.setCellValue(dev.get(i).getStringId());

			    Cell prodCellStringId = bodyRow.createCell(1);
			    prodCellStringId.setCellValue(prod.get(i).getStringId());

			    Cell devCellTextId = bodyRow.createCell(2);
			    devCellTextId.setCellValue(dev.get(i).getTextId());

			    Cell prodCellTextId = bodyRow.createCell(3);
			    prodCellTextId.setCellValue(prod.get(i).getTextId());

			    Cell devCellString = bodyRow.createCell(4);
			    devCellString.setCellValue(dev.get(i).getStringStr());

			    Cell prodCellString = bodyRow.createCell(5);
			    prodCellString.setCellValue(prod.get(i).getStringStr());
		    }
		    
		    workbook.write(outputStream);
		}
		catch (Exception exception)
		{
exception.printStackTrace(System.err);			
		}
	}
}

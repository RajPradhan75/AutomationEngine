package com.nexops.auto.remediate.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import au.com.bytecode.opencsv.CSVReader;

public class CSVtoExcel 
{
	public static void CSVtoExcelConverter(String filepath) throws Exception
	{
		File tmp = new File(filepath);
		CSVReader reader = null;
		FileOutputStream fos = null;
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet debugSheet = wb.createSheet("Debug_Log");
		XSSFRow newRow = null;
		Cell newCell = null;
		try 
		{
			reader = new CSVReader(new FileReader(tmp),'~');
			String [] nextLine;
			int rowPos=0;
			while ((nextLine = reader.readNext()) != null) 
		    {
		    	newRow = debugSheet.createRow(rowPos);
		    	int colPos=0;
		    	for(String token : nextLine)
				{
					newCell = newRow.createCell(colPos);
					newCell.setCellValue(token);
		    		colPos++;
				}
		    	rowPos++;
		    }
			fos = new FileOutputStream(filepath.substring(0, filepath.lastIndexOf(".csv"))+".xlsx");
			wb.write(fos);
			System.out.println("File converted Successfully From CSV to Excel Format");
			System.out.println("Converted .xlsx Filename: "+filepath.substring(0, filepath.lastIndexOf(".csv"))+".xlsx");	
		}
	    catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
				fos.close();
				wb.close();
				reader.close();		
		}
	}
}

/*---------------------------- Change History ------------------------------*/
/*
 * Date: 17 Sep 2016
 * By: Deepankar
 * Title: Fixed MAntis 0000382
 */
/*---------------------------- Change History ------------------------------*/
/*
 * Date: 28-Sep 2016
 * By: Deepankar
 * Title: Fixed MAntis 0000415
 */

/*---------------------------- Change History ------------------------------*/
/*
 * Date: 07 July 2017
 * By: Priti
 * Title: Fixed MAntis 0000680

/*---------------------------- Change History ------------------------------*/
/*
 * Date: 27 July 2017
 * By: Manoj
 * Title: Fixed Mantis 0000705
 */
/*---------------------------- Change History ------------------------------*/
/*
 * Date: 15 Aug 2017
 * By: Deepankar
 * Title: Mantis 0000713,0000715
 */
/* Date: 20th December 2017
 * By: Deepankar
 * Mantis ID: 0000790
 */
/*
 * Date: 26th April 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000843
 */
/*
 * Date: 29th June 2018
 * By: Deepankar
 * Title: Mantis 0000897
 */
/*
 * Date: 10th July 2018
 * By: Manoj Bamnawat
 * Title: Mantis 0000908	
 */
/*
 * Date: 04 Feb 2019
 * By: Manoj Bamnawat
 * Title: Mantis 0001073, 0001097	
 */
/*
 * Date: 28 June 2019
 * By: Zoheb Fondu
 * Mantis: 0001172	
 */
/*
 * Date: 18 July 2019
 * By: Zoheb Fondu
 * Mantis: 0001169	
 */
/*
 * Date: 22 July 2019
 * By: Zoheb Fondu
 * Mantis: 0001170
 */
/*
 * Date: 07 Aug 2019
 * By: Zoheb Fondu
 * Mantis: 0001224
 */
/*
 * Date: 22 Aug 2019
 * By: Zoheb Fondu
 * Mantis: 0001249
 */
/*
 * Date: 27 Aug 2019
 * By: Zoheb Fondu
 * Mantis: 0001261,0001262
 */
/*
 * Date: 31 Oct 2019
 * By: Zoheb Fondu
 * Mantis: 0001417
 */
/*
 * Date: 14 Nov 2019
 * By: Zoheb Fondu
 * Mantis: 0001436, 0001456
 */
/*
 * Date: 22 Nov 2019
 * By: Zoheb Fondu
 * Mantis: 0001487,0001508
 */
/*
 * Date: 17 Dec 2019
 * By: Zoheb Fondu
 * Mantis: 0001573
 */
/*
 * Date: 21 Feb 2020
 * By: Zoheb Fondu
 * Mantis 0001721
 */
/*
 * Date: 11 May 2020
 * By: Zoheb Fondu
 * Mantis 0001806
 */
/*
 * Date: 15 May 2020
 * By: Anum Shaikh
 * Mantis 0001816
 */
/*
 * Date: 26 May 2020
 * By: Manoj Bamnawat
 * Mantis 0001764
 */
/*
 * Date: 19 Aug 2020
 * By: Anum Shaikh
 * Mantis 0001911
 */
/*
 * Date: 23 Sept 2020
 * By: Anum Shaikh
 * Mantis 0001939
 */
/*
 * Date: 24 Nov 2020
 * By: Zoheb Fondu
 * Mantis 0001960, 1961, 1962
 */
/*
 * Date: 03 Dec 2020
 * By: Anum Shaikh
 * Mantis 0001966
 */
/*
 * Date: 15 Jan 2021
 * By: Anum Shaikh
 * Mantis 0001951,0001950
 */
/*
 * Date: 13 April 2021
 * By: Anum Shaikh
 * Mantis 0001949,0001948
 */
/*
* Date: 27 May 2021
* By: Anum Shaikh
* Mantis 0002020
*/

package com.nexops.auto.remediate.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Font;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;
import org.bson.json.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.nexops.auto.remediate.constants.APIConnectionsColumnHeader;
import com.nexops.auto.remediate.constants.APITestingColumnHeader;
import com.nexops.auto.remediate.constants.AbbreviationColumnHeader;
import com.nexops.auto.remediate.constants.ConfigColumnHeader;
import com.nexops.auto.remediate.constants.CustomizeDataColumnHeader;
import com.nexops.auto.remediate.constants.DataFormatColumnHeader;
import com.nexops.auto.remediate.constants.DatabaseConnectionsColumnHeader;
import com.nexops.auto.remediate.constants.DynamicDataColumnHeader;
import com.nexops.auto.remediate.constants.ExecutionDataColumnHeader;
import com.nexops.auto.remediate.constants.ImageVerificationJsonKeys;
import com.nexops.auto.remediate.webautomation.KeywordDrivenFramework;

import jdk.internal.org.jline.utils.Log;

@Service
public class ExcelConnection {

	// Mongodb Connection config

	private static String uri = "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
	private static com.mongodb.client.MongoClient mongoClient = MongoClients.create(uri);

//	@org.springframework.beans.factory.annotation.Value("${spring.data.mongodb.database}")
	private static String database = "qtaf";

	private static MongoCollection<Document> collection;
	private static MongoDatabase db = null;
	private static BasicDBObject whereQuery = new BasicDBObject();

	GsonBuilder gsonBuilder = new GsonBuilder();
	Gson gson = gsonBuilder.create();
	static Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
	static ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

	static JSONObject jsonObj = null;
	static int releaseId, machineId, projectId, exec_id;
	static boolean unitTest = false;

	public static Connection getExcelConnection(String sDatabasePath) {
		Connection con;
		try {
			System.out.println("Inside Excel Connections:" + sDatabasePath);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection(
					"jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DriverId=790;DBQ="
							+ sDatabasePath + ";DriverID=22;ReadOnly=False;");
			System.out.println("Connection object:-" + con);
			return con;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}

	}

	public static Connection getDatabaseConnection(String sDatabaseDriver, String sConnectionString, String sUsername,
			String sPassword) // Mantis 0000843
	{
		System.out.println("Connection String to Server Database" + sConnectionString);
		Connection con;
		try {
			con = DriverManager.getConnection(sConnectionString, sUsername, sPassword);
			System.out.println("Connection to server database successful:-" + con);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Mantis 0001073, 0001097
	public static void createExcelConnection(String excelFilePath, String SheetName) throws Exception {
		Workbook workbook = null;
		Sheet sheet = null;
		FileOutputStream out = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		} else {
			workbook = new XSSFWorkbook();
		}

		sheet = workbook.createSheet(SheetName);
		out = new FileOutputStream(new File(excelFilePath));
		workbook.write(out);
		out.close();
		workbook.close();
		System.out.println("Excel File created successfully");
	}

	// Mantis 0001073, 0001097
	public static void createHeaders(String excelFilePath, String SheetName, List<String> dataRS) throws Exception {
		Workbook workbook = null;
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		Font font = null;
		CellStyle style = null;

		if (excelFilePath.endsWith("xlsx")) {
			font = (XSSFFont) font;
		} else if (excelFilePath.endsWith("xls")) {
			font = (HSSFFont) font;
		}

		workbook = funExcelConnection(excelFilePath);
		sheet = workbook.getSheet(SheetName);
		row = sheet.createRow(0);

		font = workbook.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setFontName("Calibri");
		font.setItalic(false);
		font.setBold(true);
		font.setColor(HSSFColor.BLACK.index);

		style = workbook.createCellStyle();
		((XSSFCellStyle) style).setFillForegroundColor(new XSSFColor(new java.awt.Color(155, 194, 230)));
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(font);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);

		for (int i = 0; i < dataRS.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(dataRS.get(i));
			cell.setCellStyle(style);
		}

		FileOutputStream fileOut = new FileOutputStream(new File(excelFilePath));
		workbook.write(fileOut);
		fileOut.close();
		System.out.println("Column Headers cretaed successfully");
	}

	// Mantis 0001073, 0001097
	public static void funPutDataRecord(Workbook wb, String sFileName, String sheetName, List<String> dataRS)
			throws Exception {
		System.out.println("Inside POI Get Sheet Name:" + sheetName);
		Sheet sheet = wb.getSheet(sheetName);
		Row row;
		Cell cell;
		Font font = null;
		CellStyle style = null;

		if (sFileName.endsWith("xlsx")) {
			font = (XSSFFont) font;
		} else if (sFileName.endsWith("xls")) {
			font = (HSSFFont) font;
		}

		System.out.println("Last Row Number in " + sheetName + " is:" + sheet.getLastRowNum());

		System.out.println("Inside POI Get Creating new record");
		row = sheet.createRow(sheet.getLastRowNum() + 1);

		style = wb.createCellStyle();

		for (int i = 0; i < dataRS.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(dataRS.get(i));

			if (dataRS.get(i).contains("Data not found")) {
				font = wb.createFont();
				font.setFontHeightInPoints((short) 11);
				font.setFontName("Calibri");
				font.setItalic(false);
				font.setBold(true);
				font.setColor(HSSFColor.RED.index);

				style = wb.createCellStyle();
				style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
				style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
				style.setBorderRight(XSSFCellStyle.BORDER_THIN);
				style.setBorderTop(XSSFCellStyle.BORDER_THIN);
				((XSSFCellStyle) style).setFillForegroundColor(new XSSFColor(new java.awt.Color(221, 235, 247)));
				style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			} else {
				font = wb.createFont();
				font.setFontHeightInPoints((short) 11);
				font.setFontName("Calibri");
				font.setItalic(false);
				font.setBold(false);
				font.setColor(HSSFColor.BLACK.index);

				style = wb.createCellStyle();
				style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
				style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
				style.setBorderRight(XSSFCellStyle.BORDER_THIN);
				style.setBorderTop(XSSFCellStyle.BORDER_THIN);
				((XSSFCellStyle) style).setFillForegroundColor(new XSSFColor(new java.awt.Color(221, 235, 247)));
				style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			}
			style.setFont(font);
			cell.setCellStyle(style);
		}

		FileOutputStream fileOut = new FileOutputStream(sFileName);
		wb.write(fileOut);
		fileOut.close();
	}

	/*---------------------------------- START : funExcelConnection -----------------------------------*/
	public static Workbook funExcelConnection(String excelFilePath) throws IllegalFormatException, IOException {
		Workbook workbook = null;
		FileInputStream file = null;
		if (excelFilePath.endsWith("xlsx")) {
			file = new FileInputStream(new File(excelFilePath));
			workbook = new XSSFWorkbook(file);
		} else if (excelFilePath.endsWith("xls")) {
			file = new FileInputStream(new File(excelFilePath));
			workbook = new HSSFWorkbook(file);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}
		file.close();
		return workbook;
	}

	/*---------------------------------- START : funGetSheetData -----------------------------------*/

	public static List<List<String>> funGetSheetData(Workbook wb, String sSheetName) throws IOException {
		List<List<String>> tableRS = new ArrayList<List<String>>();
		List<String> listRow;
		Sheet sheet = wb.getSheet(sSheetName);
		Row row, headerRow;
		Cell cell;

		if (sheet != null) {
			int numOfRows = sheet.getLastRowNum();
			headerRow = sheet.getRow(0);
			int FirstCol = headerRow.getFirstCellNum();
			int LastCol = headerRow.getLastCellNum();

			for (int i = 1; i <= numOfRows; i++) {
				listRow = new ArrayList<String>();
				row = sheet.getRow(i);
				if (row == null) // Mantis 0000415
					break;
				for (int j = FirstCol; j < LastCol; j++) {
					cell = row.getCell(j);
					if (cell == null || cell.toString().trim().isEmpty())
						listRow.add(null);
					else {
						// Mantis 0000539
						listRow.add(cell.toString()); // Mantis 0000897
					}
				}
				tableRS.add(listRow);
			}
		} else {
			NullPointerException exception = new NullPointerException("Sheet " + sSheetName + " not found"); // Mantis:0000382
			throw exception;
		}

		return tableRS;
	}

	/*---------------------------------- START : funGetSheetColumns -----------------------------------*/
	public static Map<String, Integer> funGetSheetColumns(Workbook wb, String sSheetName) {
		Map<String, Integer> mapColumns = new HashMap<String, Integer>();
		Sheet sheet = wb.getSheet(sSheetName);
		Row headerRow = sheet.getRow(0);
		int FirstCol = headerRow.getFirstCellNum();
		int LastCol = headerRow.getLastCellNum();
		for (int colId = FirstCol; colId < LastCol; colId++) {
			Cell cell = headerRow.getCell(colId);
			if (cell != null)// Mantis 0000705
			{
				mapColumns.put(cell.getStringCellValue().toString().trim(), cell.getColumnIndex());
			}

		}
		return mapColumns;
	}

	/*--------------------------------- START: funGetColumnIndex ---------------------------------*/
	public static int funGetColumnIndex(String columnName, Map<String, Integer> mapColumn) {

		int columnIndex = mapColumn.get(columnName);
		return columnIndex;
	}

	/*--------------------------------- START: funGetTestDataRecordNumber --------------------------------*/
	public static int funGetTestDataRecordNumber(int testCaseColumnIndex, String testCaseData,
			List<List<String>> dataRS) {
		int recordNumber = -1;
		for (int i = 0; i < dataRS.size(); i++) {
			String actualTestCaseNumber = dataRS.get(i).get(testCaseColumnIndex);
			if (actualTestCaseNumber.equalsIgnoreCase(testCaseData)) {
				recordNumber = i;
				break;
			}
		}
		return recordNumber;
	}

	/*--------------------------------- START: funGetExecutionDataRecordNumber --------------------------------*/
	public static int funGetExecutionDataRecordNumber(int testCaseColumnIndex, int fieldNameColumnIndex,
			String testCase, String fieldName, List<List<String>> dataRS) {
		int recordNumber = -1;
		for (int i = 0; i < dataRS.size(); i++) {
			String actualTestCaseNumber = dataRS.get(i).get(testCaseColumnIndex);
			String actualFieldName = dataRS.get(i).get(fieldNameColumnIndex);
			if (actualTestCaseNumber != null && actualFieldName != null) // Manoj xxx
			{
				if (actualTestCaseNumber.equalsIgnoreCase(testCase) && actualFieldName.equals(fieldName)) {
					recordNumber = i;
					break;
				}
			}
		}
		System.out.println("Test Data Record Number:" + recordNumber);
		return recordNumber;
	}

	public static void funPutExecutionDataRecord(Workbook wb, String sheetName, int recordnumber,
			int testCaseColumnIndex, int fieldNameColumnIndex, int fieldValueColumnIndex, String sTestCase,
			String sFieldName, String sFieldValue, String sFileName, int commentColumnIndex, String comments)
			throws IOException {
		System.out.println("Inside POI Get Sheet Name:" + sheetName);
		Sheet sheet = wb.getSheet(sheetName);
		Row row;
		Cell cellTestCase, cellFieldName, cellFieldValue;

		System.out.println("Last Row Number in " + sheetName + " is:" + sheet.getLastRowNum());
		System.out.println();
		if (recordnumber == -1) {
			System.out.println("Inside POI Get Creating new record");
			row = sheet.createRow(sheet.getLastRowNum() + 1);
			cellTestCase = row.createCell(testCaseColumnIndex);
			cellTestCase.setCellValue(sTestCase);
			cellFieldName = row.createCell(fieldNameColumnIndex);
			cellFieldName.setCellValue(sFieldName);
			cellFieldValue = row.createCell(fieldValueColumnIndex);
			cellFieldValue.setCellValue(sFieldValue);
			if (commentColumnIndex != -1) // Mantis 0000713
			{
				cellFieldValue = row.createCell(commentColumnIndex);
				cellFieldValue.setCellValue(comments);
			}

		} else {
			System.out.println("Field Column Index:" + fieldNameColumnIndex);
			System.out.println("Inside POI Get Writing in existing record:" + sFieldValue);
			row = sheet.getRow(recordnumber + 1);
			System.out.println("Row number to write:" + row.getRowNum());
			System.out.println("field value column index :" + fieldValueColumnIndex);
			cellFieldValue = row.getCell(fieldValueColumnIndex);
			System.out.println("Field Value:" + cellFieldValue);
			cellFieldValue.setCellValue(sFieldValue);
			if (commentColumnIndex != -1) // Mantis 0000713
			{
				cellFieldValue = row.getCell(commentColumnIndex); // Mantis 0000713
				cellFieldValue.setCellValue(comments); // Mantis 0000713
			}
		}

		FileOutputStream fileOut = new FileOutputStream(sFileName);
		wb.write(fileOut);
		fileOut.close();
	}

	/*--------------------------------- START: funGetDynamicDataRecordNumber --------------------------------*/
	public static int funGetDynamicDataRecordNumber(int nameColumnIndex, String testCaseData,
			List<List<String>> dataRS) {
		int recordNumber = -1;
		for (int i = 0; i < dataRS.size(); i++) {
			String actualTestCaseNumber = dataRS.get(i).get(nameColumnIndex);
			// System.out.println("Test Case Number:"+actualTestCaseNumber);
			if (actualTestCaseNumber != null && actualTestCaseNumber.equalsIgnoreCase(testCaseData)) {
				recordNumber = i;
				break;
			}
		}
		// System.out.println("Test Data Record Number:"+recordNumber);
		return recordNumber;
	}

	public static String getDriversJsonfromDB(String Driver) throws Exception // Mantis: 0001417
	{
		jsonObj = new JSONObject(Driver);
		String sDriver = (String) jsonObj.get("Driver");
		projectId = (Integer) jsonObj.get("Project_Id");
		unitTest = (boolean) jsonObj.get("UnitTest");
		exec_id = (int) jsonObj.get("Exec_ID");

		db = mongoClient.getDatabase(database);
		if (unitTest == true)
			collection = db.getCollection("temp_driver");
		else
			collection = db.getCollection("driver");

		Document data = null;

		String driverJson = null;

		whereQuery.put("Driver_Name", sDriver);
		whereQuery.put("Project_Id", projectId);
		MongoCursor<Document> iterDoc = collection.find(whereQuery).cursor();
//		Iterator<Document> it = iterDoc.iterator();
		try {
			while (iterDoc.hasNext()) {
				data = iterDoc.next();
				driverJson = (String) data.get("driver_data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			iterDoc.close();
		}
		return driverJson;
	}

	public static String getPollerConfiguration(String configKey) throws Exception {
		// String rootpath = System.getProperty("user.dir");

		// ClassPathResource classPathResource = new
		// ClassPathResource("SeleniumDrivers/chromedriver_old.exe");

		Resource resource = new ClassPathResource("/application.properties");

		Properties props = PropertiesLoaderUtils.loadProperties(resource);

		return (String) props.get(configKey);

		/*
		 * BufferedReader br = new BufferedReader(new
		 * FileReader(rootpath.concat("/pollerconfig.txt"))); String line =
		 * br.readLine(); String[] command; String value = ""; try { while (line !=
		 * null) { if (!line.substring(0, 1).equals("'")) { command = line.split("\\=");
		 * if (command[0].toString().trim().equalsIgnoreCase(configKey)) { value =
		 * command[1].toString().trim(); break; } } line = br.readLine(); } }
		 * catch(Exception e) { e.printStackTrace(); } finally { br.close();
		 * if(value.isEmpty()) { if(configKey.equalsIgnoreCase("deleteresults"))
		 * //Mantis 0001456 value="no"; else throw new
		 * Exception(configKey+" is not available in PollerConfig file."); } } return
		 * value;
		 */
	}

	public static String getEmailConfiguration(String configKey) throws Exception {
		String rootpath = System.getProperty("user.dir");
		BufferedReader br = new BufferedReader(new FileReader(rootpath.concat("/emailConfig.txt")));
		String line = br.readLine();
		String[] command;
		String value = "";
		try {
			while (line != null) {
				if (!line.substring(0, 1).equals("'")) {
					command = line.split("\\=");
					if (command[0].toString().trim().equalsIgnoreCase(configKey)) {
						if (command.length > 1)
							value = command[1].toString().trim();

						break;
					}
				}
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			br.close();
			if (value.isEmpty() || value == null) {
				if (configKey.equalsIgnoreCase("emailccto") || configKey.equalsIgnoreCase("emailto")) // Mantis 0001456
																										// 0001960
																										// 0001961
					value = "";
				else if (configKey.equalsIgnoreCase("emailsubject")) // Mantis 0001962
					value = "ERROR - 100 : Script Failure Notification";
				else
					throw new Exception(configKey + " is not available in EmailConfig file.");
			}
		}
		return value;
	}

	public static List<List<String>> getDriverSheetDataFromJSON(String JSONData) throws Exception {
		ArrayList<LinkedHashMap<String, String>> jsonArrayData = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> hm = null;
		List<List<String>> sheetData = new ArrayList<List<String>>();
		ArrayList<String> rowData = null;
		Object obj = new JSONObject(JSONData);
		JSONObject jo = (JSONObject) obj;

		JSONArray ja = (JSONArray) jo.get("Driver");
		Iterator itr2 = ja.iterator();

		while (itr2.hasNext()) {
			JSONObject obj2 = (JSONObject) itr2.next();
			Iterator<String> columns = obj2.keySet().iterator();
			hm = new LinkedHashMap<String, String>();
			while (columns.hasNext()) {
				String col = columns.next();
				hm.put(col, obj2.get(col).toString());
			}
			jsonArrayData.add(hm);
		}

		for (LinkedHashMap<String, String> hashmap : jsonArrayData) {
			if (hashmap.get("Run_Flag").equalsIgnoreCase("Y")) {
				rowData = new ArrayList<String>();
				for (String str : hashmap.keySet()) {
					rowData.add(hashmap.get(str));
				}
				sheetData.add(rowData);
			}
		}
		return sheetData;
	}

	public static List<List<String>> getSheetDataFromJSON(Object jsonData, String sheetName) throws Exception {
		ArrayList<LinkedHashMap<String, String>> jsonArrayData = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> hm = null;
		List<List<String>> sheetData = new ArrayList<List<String>>();
		ArrayList<String> rowData = null;
		Object obj = new JSONObject(jsonData.toString());
		JSONObject jo = (JSONObject) obj;

		JSONArray ja = (JSONArray) jo.get(sheetName);
		Iterator itr2 = ja.iterator();

		while (itr2.hasNext()) {
			JSONObject obj2 = (JSONObject) itr2.next();
			Iterator<String> columns = obj2.keySet().iterator();
			hm = new LinkedHashMap<String, String>();
			while (columns.hasNext()) {
				String col = columns.next();
				hm.put(col, obj2.get(col).toString());
			}
			jsonArrayData.add(hm);
		}

		for (LinkedHashMap<String, String> hashmap : jsonArrayData) {
			rowData = new ArrayList<String>();
			for (String str : hashmap.keySet()) {
				rowData.add(hashmap.get(str));
			}
			sheetData.add(rowData);
		}
		return sheetData;
	}

	// Dependent on script
	public static Object getScriptJsonfromDB(String script) throws Exception // Mantis: 0001417,0001487
	{

		Object component_Data = "";
		Integer ScriptId = null;
		Document data = null;
		String json = null;
		db = mongoClient.getDatabase(database);

		if (KeywordDrivenFramework.getsScriptId() != null) // Mantis: 0001487
		{
			ScriptId = Integer.parseInt(KeywordDrivenFramework.getsScriptId());
		}

//		if (unitTest == true)
//			collection = db.getCollection("temp_component");
//		else
//			collection = db.getCollection("component");
//		if (ScriptId != null) {
//			whereQuery.put("Component_Id", 188);
//		} else {
//			whereQuery.put("Component_Name", "SFDCLead");
//		}
		whereQuery.put("Component_Name", script); // to be removed
		whereQuery.put("Project_Id", 108);
		collection = db.getCollection("component");
		MongoCursor<Document> iterDoc = collection.find(whereQuery).cursor();
//		Iterator<Document> it = iterDoc.iterator();

		try {
			while (iterDoc.hasNext()) {
				data = iterDoc.next();
				component_Data = data.get("component_data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			iterDoc.close();
		}

		try {
			json = ow.writeValueAsString(component_Data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	public static Map<String, Integer> getColumnNamesFromJson(Object jsonData, String Sheet) {
		JSONObject object = new JSONObject(jsonData);
		Map<String, Integer> columnHeader = new LinkedHashMap<String, Integer>();
		Iterator<String> sheets = object.keySet().iterator();

		while (sheets.hasNext()) {
			String SheetName = sheets.next().toString();
			if (SheetName.equalsIgnoreCase(Sheet)) {
				int i = 0;
				JSONArray array = (JSONArray) object.get(SheetName);
				Iterator<Object> arrayIterator = array.iterator();
				JSONObject jsonObj = (JSONObject) arrayIterator.next();
				Iterator<String> columns = jsonObj.keySet().iterator();

				while (columns.hasNext()) {
					String columnName = columns.next().toString().trim();
					columnHeader.put(columnName, i);
					i++;
				}
			}
		}
		return columnHeader;
	}

	public static Object getExecutionDatafromDb() {

//		projectId = (Integer) jsonObj.get("Project_Id");
//		machineId = (Integer) jsonObj.get("Machine_Id");
		Object execution_Data = "";

		db = mongoClient.getDatabase(database);

		collection = db.getCollection("executiondata");

		Document data = null;

		Document document = new Document();

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = null;

		whereQuery.put("machine_id", 7);
		whereQuery.put("project_id", 115);
		MongoCursor<Document> iterDoc = collection.find(whereQuery).cursor();
//		Iterator<Document> it = iterDoc.iterator();

		if (iterDoc.hasNext()) {
			data = iterDoc.next();
			execution_Data = data.get("execution_data");
		} else {
			execution_Data = createExecutionDataJson();
			document.put("execution_data", execution_Data);
			document.put("machine_id", machineId);
			document.put("project_id", projectId);
		}
		try {
			json = ow.writeValueAsString(execution_Data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} finally {
			iterDoc.close();
		}
		return json;
	}

	public static String getApiDetailsJsonFromDB(String filename) {

		Integer projId = projectId;

		String apiData = "";
		String file_Name = filename;
		file_Name = file_Name.substring(file_Name.lastIndexOf("\\") + 1, file_Name.lastIndexOf("."));

		db = mongoClient.getDatabase(database);

		collection = db.getCollection("apidetails");

		Document data = null;

		whereQuery.put("projId", projId);
		whereQuery.put("fileName", file_Name);

		MongoCursor<Document> iterDoc = collection.find(whereQuery).cursor();
//		Iterator<Document> it = iterDoc.iterator();
		try {
			while (iterDoc.hasNext()) {
				data = iterDoc.next();
				apiData = data.getString("api_data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			iterDoc.close();
		}
		return apiData;
	}

//	public static void updateExecutionData(String JsonData) throws Exception // Mantis: 0001169
//	{
//		projectId = (Integer) jsonObj.get("Project_Id");
//		machineId = (Integer) jsonObj.get("Machine_Id");
//
//		String sUpdateQuery = "", sInsertQuery = "";
//		String execution_Data = "";
//		Connection SQLCon = null;
//		ResultSet rs = null;
//		// int upd=0;
//
//		try {
//			SQLCon = establishDBConnection();
//
//			sUpdateQuery = "{Call qweb_modifyExecutionData(?,?,?)}";
//
//			CallableStatement cStmt = SQLCon.prepareCall(sUpdateQuery);
//
//			cStmt.setString(1, JsonData);
//			cStmt.setInt(2, machineId);
//			cStmt.setInt(3, projectId);
//
//			cStmt.executeQuery();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			SQLCon.close();
//		}
//	}

	public static void updateExecutionData(String JsonData) throws Exception // Mantis: 0001169
	{
		projectId = (Integer) jsonObj.get("Project_Id");
		machineId = (Integer) jsonObj.get("Machine_Id");

		db = mongoClient.getDatabase(database);

		collection = db.getCollection("executiondata");

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("json_data", JsonData);
		newDocument.put("machine_id", machineId);
		newDocument.put("project_id", projectId);

		BasicDBObject searchQuery = new BasicDBObject().append("execdata_id", 11);
		collection.updateOne(newDocument, searchQuery);

	}

	public static String createExecutionDataJson() // Mantis: 0001169
	{
		List<String> columnsKeys = null;
		JSONObject execDataJson = new JSONObject();

		columnsKeys = new LinkedList<String>();
		columnsKeys.add("Test_Case");
		columnsKeys.add("Field_Name");
		columnsKeys.add("Field_Value");
		columnsKeys.add("Comments");

		JSONArray sheetData = new JSONArray();

		JSONObject rowJsonObject = new JSONObject();
		for (int j = 0; j < columnsKeys.size(); j++) {
			String columnName = columnsKeys.get(j);
			String value = "";
			rowJsonObject.put(columnName, value);
		}
		sheetData.put(rowJsonObject);
		execDataJson.put("TempStorage", sheetData);
		return execDataJson.toString();
	}

	public static void putExecutionDataJson(Map<String, Integer> colHeaders, List<List<String>> sheetData,
			int testCaseColumnIndex, int fieldNameColumnIndex, int fieldValueColumnIndex, String sTestCase,
			String sFieldName, String sFieldValue, int recordNumber, String comments) throws Exception // Mantis:
																										// 0001169
	{
		LinkedHashMap<String, Integer> resultSetColumns = (LinkedHashMap<String, Integer>) colHeaders;
		List<String> columnsKeys = null;
		List<List<String>> resultSet = null;
		List<String> resultSetRecord = null;
		List<String> newRecord = null;
		int commentsColumnIndex = resultSetColumns.get(ExecutionDataColumnHeader.COMMENTS.toString()); // Mantis 0001491

		if (recordNumber == -1) {
			resultSet = sheetData;
			newRecord = new LinkedList<String>();
			System.out.println("Inside POI Get Creating new record");
			for (int i = 0; i < resultSetColumns.size(); i++) {
				if (testCaseColumnIndex == i)
					newRecord.add(sTestCase);
				else if (fieldNameColumnIndex == i)
					newRecord.add(sFieldName);
				else if (fieldValueColumnIndex == i) {
					if (sFieldValue == null || sFieldValue.equalsIgnoreCase("null")) {
						sFieldValue = "";
						newRecord.add(sFieldValue);
					} else
						newRecord.add(sFieldValue);
				} else if (commentsColumnIndex == i)
					newRecord.add(comments);
			}
			resultSet.add(newRecord);
		} else {
			System.out.println("Inside POI Get Writing in existing record:" + sFieldValue);
			resultSet = new LinkedList<List<String>>();
			for (List resultList : sheetData) {
				if (resultList.contains(sFieldName) && resultList.contains(sTestCase)) {
					if (sFieldValue == null || sFieldValue.equalsIgnoreCase("null")) {
						sFieldValue = "";
						resultList.set(fieldValueColumnIndex, sFieldValue);
						resultSet.add(resultList);
					} else {
						resultList.set(fieldValueColumnIndex, sFieldValue);
						resultSet.add(resultList);
					}
				} else {
					resultSet.add(resultList);
				}
			}
		}
		JSONObject jsonSheet = new JSONObject();
		String sheetname = "TempStorage";
		columnsKeys = new LinkedList(resultSetColumns.keySet());
		System.out.println("columns :" + columnsKeys);

		JSONArray jSheetData = new JSONArray();

		for (int i = 0; i < resultSet.size(); i++) {
			resultSetRecord = resultSet.get(i);
			JSONObject rowJsonObject = new JSONObject();

			for (int j = 0; j < resultSetColumns.size(); j++) {
				String columnName = columnsKeys.get(j);
				String value = resultSetRecord.get(resultSetColumns.get(columnName));
				rowJsonObject.put(columnName, value);
			}
			jSheetData.put(rowJsonObject);
		}
		jsonSheet.put(sheetname, jSheetData);
		System.out.println("Record added to ExecutionData");
		updateExecutionData(jsonSheet.toString());
	}

	public static Object getdbFilefromJson(String dbFile) throws Exception // Mantis: 0001170
	{
//		projectId = (Integer) jsonObj.get("Project_Id");
		if (dbFile.contains(".xlsx"))
			dbFile = dbFile.substring(dbFile.lastIndexOf("\\") + 1, dbFile.lastIndexOf(".")); // Mantis: 0001224
		else
			dbFile = dbFile.substring(dbFile.lastIndexOf("\\") + 1); // Mantis: 0001224

		Object JsonData = "";
		String json = null;

		db = mongoClient.getDatabase(database);
		collection = db.getCollection("dbquery");
		Document data = null;

		whereQuery.put("Query_Name", dbFile);
		whereQuery.put("Project_Id", 113);
		MongoCursor<Document> iterDoc = collection.find(whereQuery).cursor();

//		Iterator<Document> it = iterDoc.iterator();
		try {
			while (iterDoc.hasNext()) {
				data = iterDoc.next();
				JsonData = data.get("Query_Data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			iterDoc.close();
		}

		try {
			json = ow.writeValueAsString(JsonData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return json;
	}

	public static Map<String, Integer> getMasterDataFileColumns(String filename) {
		Map<String, Integer> columnHeader = null;

		if (filename.equalsIgnoreCase("CustomizeData")) {
			columnHeader = new LinkedHashMap<String, Integer>();
			columnHeader.put(CustomizeDataColumnHeader.NAME.toString(), 0);
			columnHeader.put(CustomizeDataColumnHeader.TYPE.toString(), 1);
			columnHeader.put(CustomizeDataColumnHeader.PARAMETER.toString(), 2);
			columnHeader.put(CustomizeDataColumnHeader.FORMAT.toString(), 3);
		} else if (filename.equalsIgnoreCase("DynamicData")) {
			columnHeader = new LinkedHashMap<String, Integer>();
			columnHeader.put(DynamicDataColumnHeader.NAME.toString(), 0);
			columnHeader.put(DynamicDataColumnHeader.TYPE.toString(), 1);
			columnHeader.put(DynamicDataColumnHeader.LENGTH.toString(), 2);
			columnHeader.put(DynamicDataColumnHeader.FORMAT.toString(), 3);
			columnHeader.put(DynamicDataColumnHeader.COMMENT.toString(), 4);
		} else if (filename.equalsIgnoreCase("DataFormat")) {
			columnHeader = new LinkedHashMap<String, Integer>();
			columnHeader.put(DataFormatColumnHeader.NAME.toString(), 0);
			columnHeader.put(DataFormatColumnHeader.TYPE.toString(), 1);
			columnHeader.put(DataFormatColumnHeader.LOCALE.toString(), 2);
		} else if (filename.equalsIgnoreCase("DatabaseConnections")) {
			columnHeader = new LinkedHashMap<String, Integer>();
			columnHeader.put(DatabaseConnectionsColumnHeader.CONNECTIONNAME.toString(), 0);
			columnHeader.put(DatabaseConnectionsColumnHeader.DATABASEDRIVER.toString(), 1);
			columnHeader.put(DatabaseConnectionsColumnHeader.CONNECTIONSTRING.toString(), 2);
			columnHeader.put(DatabaseConnectionsColumnHeader.USERNAME.toString(), 3);
			columnHeader.put(DatabaseConnectionsColumnHeader.PASSWORD.toString(), 4);
		} else if (filename.equalsIgnoreCase("APIConnections")) {
			columnHeader = new LinkedHashMap<String, Integer>();
			columnHeader.put(APIConnectionsColumnHeader.CONNECTIONNAME.toString(), 0);
			columnHeader.put(APIConnectionsColumnHeader.BASEURL.toString(), 1);
			columnHeader.put(APIConnectionsColumnHeader.USERNAME.toString(), 2);
			columnHeader.put(APIConnectionsColumnHeader.PASSWORD.toString(), 3);
		} else if (filename.equalsIgnoreCase("Abbreviation")) {
			columnHeader = new LinkedHashMap<String, Integer>();
			columnHeader.put(AbbreviationColumnHeader.NAME.toString(), 0);
			columnHeader.put(AbbreviationColumnHeader.ABBREVIATION.toString(), 1);
		} else if (filename.equalsIgnoreCase("Configuration")) // Mantis: 0001261
		{
			columnHeader = new LinkedHashMap<String, Integer>();
			columnHeader.put(ConfigColumnHeader.PAGE_WAIT_TIME.toString(), 0);
			columnHeader.put(ConfigColumnHeader.FRAME_WAIT_TIME.toString(), 1);
			columnHeader.put(ConfigColumnHeader.AUTO_CLOSE.toString(), 2);
			columnHeader.put(ConfigColumnHeader.LOAD_TIMEOUT.toString(), 3);
			columnHeader.put(ConfigColumnHeader.WINDOW_TIMEOUT.toString(), 4);
			columnHeader.put(ConfigColumnHeader.ELEMENT_WAIT.toString(), 5);
			columnHeader.put(ConfigColumnHeader.FILE_WAIT.toString(), 6);
			columnHeader.put(ConfigColumnHeader.NTLM.toString(), 7);
			columnHeader.put(ConfigColumnHeader.USERNAME.toString(), 8);
			columnHeader.put(ConfigColumnHeader.PASSWORD.toString(), 9);
			columnHeader.put(ConfigColumnHeader.SCREENSHOT.toString(), 10); // Mantis 0001249
			columnHeader.put(ConfigColumnHeader.WEBPAGE.toString(), 11); // Mantis 0001249
			columnHeader.put(ConfigColumnHeader.DOWNLOAD_FOLDER.toString(), 12); // Mantis 0001816

		}
		return columnHeader;
	}

	public static List<List<String>> readCustomizeData() {

		Integer projId = projectId;
		List<String> rowData = null;
		List<List<String>> customizeData = new ArrayList<List<String>>();

		db = mongoClient.getDatabase(database);

		collection = db.getCollection("customizedata");

		Document data = null;

		whereQuery.put("projId", projId);

		MongoCursor<Document> iterDoc = collection.find(whereQuery).cursor();
//		Iterator<Document> it = iterDoc.iterator();
		try {
			while (iterDoc.hasNext()) {
				data = iterDoc.next();
				rowData = new LinkedList<String>();
				rowData.add(data.getString(CustomizeDataColumnHeader.NAME.toString()));
				rowData.add(data.getString(CustomizeDataColumnHeader.TYPE.toString()));
				rowData.add(data.getString(CustomizeDataColumnHeader.PARAMETER.toString()));
				rowData.add(data.getString(CustomizeDataColumnHeader.FORMAT.toString()));
				customizeData.add(rowData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			iterDoc.close();
		}
		return customizeData;
	}

	public static List<List<String>> readAbbreviation() {

		Integer projId = projectId;
		List<String> rowData = null;
		List<List<String>> Abbreviation = new ArrayList<List<String>>();

		db = mongoClient.getDatabase(database);

		collection = db.getCollection("abbreviation");

		Document data = null;

		whereQuery.put("project_id", 148);
		MongoCursor<Document> iterDoc = collection.find(whereQuery).cursor();
//		Iterator<Document> it = iterDoc.iterator();
		try {
			while (iterDoc.hasNext()) {
				data = iterDoc.next();
				rowData = new LinkedList<String>();
				rowData.add(data.getString(AbbreviationColumnHeader.NAME.toString()));
				rowData.add(data.getString(AbbreviationColumnHeader.ABBREVIATION.toString()));
				Abbreviation.add(rowData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			iterDoc.close();
		}
		return Abbreviation;
	}

	public static List<List<String>> readAPIConnections() {

		Integer projId = projectId;

		List<String> rowData = null;
		List<List<String>> apiConnections = new ArrayList<List<String>>();

		db = mongoClient.getDatabase(database);

		collection = db.getCollection("apiconnections");

		Document data = null;

		whereQuery.put("projId", projId);

		MongoCursor<Document> iterDoc = collection.find(whereQuery).cursor();
//		Iterator<Document> it = iterDoc.iterator();

		try {
			while (iterDoc.hasNext()) {
				data = iterDoc.next();
				rowData = new LinkedList<String>();
				rowData.add(data.getString(APIConnectionsColumnHeader.CONNECTIONNAME.toString()));
				rowData.add(data.getString(APIConnectionsColumnHeader.BASEURL.toString()));
				rowData.add(data.getString(APIConnectionsColumnHeader.USERNAME.toString()));
				rowData.add(data.getString(APIConnectionsColumnHeader.PASSWORD.toString()));
				apiConnections.add(rowData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			iterDoc.close();
		}
		return apiConnections;

	}

	// Mantis ID 0001764
	// Column Name Not Matching
	public static Map<String, JSONObject> getDbDriverData() {
		JSONObject object = new JSONObject();

		Map<String, JSONObject> dbDriverData = new HashMap<String, JSONObject>();

		db = mongoClient.getDatabase(database);

		collection = db.getCollection("database_driver_name");

		Document data = null;

		MongoCursor<Document> iterDoc = collection.find(whereQuery).cursor();
//		Iterator<Document> it = iterDoc.iterator();
		try {
			while (iterDoc.hasNext()) {
				data = iterDoc.next();
				object.put("drivername", data.getString("drivername"));
				object.put("connectionURL", data.getString("connectionURL"));
				dbDriverData.put(data.getString("database"), object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			iterDoc.close();
		}
		return dbDriverData;
	}

	// Column Name Not Matching
	public static List<List<String>> readDatabaseConnections() {
//		Integer projId = projectId;
	
		List<String> rowData = null;
		List<List<String>> DatabaseConnections = new ArrayList<List<String>>();
		db = mongoClient.getDatabase(database);

		collection = db.getCollection("databaseconnections");

		Document data = null;

//		whereQuery.put("project_id", projId);
		whereQuery.put("project_id", 154);
		MongoCursor<Document> iterDoc = collection.find(whereQuery).cursor();
//		Iterator<Document> it = iterDoc.iterator();
		Map<String, JSONObject> dbDriverDataList = getDbDriverData();
		
		try {
			while (iterDoc.hasNext()) {
				data = iterDoc.next();
				rowData = new LinkedList<String>();
				JSONObject dbDriverData = dbDriverDataList.get(data.getString("database"));
//				String connectionURL = dbDriverData.getString("connectionURL");
//				String hostname = data.getString("hostname");
//				String port = data.getString("port");
//				String schema = data.getString("schema");

//				connectionURL = connectionURL.replace("hostname", hostname).replace("port", port).replace("database_name",
//						schema);

				rowData.add(data.getString(DatabaseConnectionsColumnHeader.CONNECTIONNAME.toString()));
				rowData.add(dbDriverData.getString("drivername"));
//				rowData.add(connectionURL);
				rowData.add(data.getString(DatabaseConnectionsColumnHeader.USERNAME.toString()));
				rowData.add(data.getString(DatabaseConnectionsColumnHeader.PASSWORD.toString()));
				DatabaseConnections.add(rowData);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			iterDoc.close();
		}
		return DatabaseConnections;
	}

	// Empty Db
	public static List<List<String>> readDataFormat() {

		Integer projId = projectId;
		String sExecutionQuery = "";
		Connection SQLCon = null;
		List<String> rowData = null;
		List<List<String>> DataFormat = new ArrayList<List<String>>();

		db = mongoClient.getDatabase(database);

		collection = db.getCollection("dataformat");

		Document data = null;

		List<List<String>> dataFormat = null;

		whereQuery.put("project_id", projId);
		FindIterable<Document> iterDoc = collection.find(whereQuery);
		Iterator<Document> it = iterDoc.iterator();

		while (it.hasNext()) {
			data = it.next();
			rowData = new LinkedList<String>();
			rowData.add(data.getString(DataFormatColumnHeader.NAME.toString()));
			rowData.add(data.getString(DataFormatColumnHeader.TYPE.toString()));
			rowData.add(data.getString(DataFormatColumnHeader.LOCALE.toString()));
			DataFormat.add(rowData);

			break;
		}
		return DataFormat;
	}

	public static List<List<String>> readDynamicData() {

		Integer projId = projectId;
		List<String> rowData = null;
		List<List<String>> DynamicData = new ArrayList<List<String>>();

		db = mongoClient.getDatabase(database);

		collection = db.getCollection("dynamicdata");

		Document data = null;

		whereQuery.put("project_id", 108);
		whereQuery.put("machine_id", 5);
		FindIterable<Document> iterDoc = collection.find(whereQuery);
		Iterator<Document> it = iterDoc.iterator();

		while (it.hasNext()) {
			data = it.next();
			rowData = new LinkedList<String>();
			rowData.add(data.getString(DynamicDataColumnHeader.NAME.toString()));
			rowData.add(data.getString(DynamicDataColumnHeader.TYPE.toString()));
			rowData.add(data.getString(DynamicDataColumnHeader.LENGTH));
			rowData.add(data.getString(DynamicDataColumnHeader.FORMAT.toString()));
			rowData.add(data.getString(DynamicDataColumnHeader.COMMENT.toString()));
			DynamicData.add(rowData);
			break;
		}
		return DynamicData;

	}

	// dependent on driver parameter
	public static List<List<String>> readConfigData(String Driver) {

		jsonObj = new JSONObject(Driver);
		projectId = (Integer) jsonObj.get("Project_Id");
		machineId = (Integer) jsonObj.get("Machine_Id");
		List<String> rowData = null;
		List<List<String>> configData = new ArrayList<List<String>>();

		db = mongoClient.getDatabase(database);

		collection = db.getCollection("");

		Document data = null;

		whereQuery.put("project_id", 108);
		whereQuery.put("Machine_id", 16);
		FindIterable<Document> iterDoc = collection.find(whereQuery);
		Iterator<Document> it = iterDoc.iterator();

		while (it.hasNext()) {
			data = it.next();
			rowData = new LinkedList<String>();
			rowData.add(data.getString(ConfigColumnHeader.PAGE_WAIT_TIME.toString()));
			rowData.add(data.getString(ConfigColumnHeader.FRAME_WAIT_TIME.toString()));
			rowData.add(data.getString(ConfigColumnHeader.AUTO_CLOSE.toString()));
			rowData.add(data.getString(ConfigColumnHeader.LOAD_TIMEOUT.toString()));
			rowData.add(data.getString(ConfigColumnHeader.WINDOW_TIMEOUT.toString()));
			rowData.add(data.getString(ConfigColumnHeader.ELEMENT_WAIT.toString()));
			rowData.add(data.getString(ConfigColumnHeader.FILE_WAIT.toString()));
			rowData.add(data.getString(ConfigColumnHeader.NTLM.toString()));
			rowData.add(data.getString(ConfigColumnHeader.USERNAME.toString()));
			rowData.add(data.getString(ConfigColumnHeader.PASSWORD.toString()));
			rowData.add(data.getString(ConfigColumnHeader.SCREENSHOT.toString())); // Mantis 0001249
			rowData.add(data.getString(ConfigColumnHeader.WEBPAGE.toString())); // Mantis 0001249
			rowData.add(data.getString(ConfigColumnHeader.DOWNLOAD_FOLDER.toString())); // MAntis 0001816
			configData.add(rowData);
			break;
		}
		return configData;

	}

	public static int getComponentIdFromName(String script_name, Integer Project_Id) {

		db = mongoClient.getDatabase(database);

		collection = db.getCollection("component");

		Document data = null;
		int componentId = -1;
		try {
			whereQuery.put("Component_Name", script_name);
			whereQuery.put("Project_Id", Project_Id);
			FindIterable<Document> iterDoc = collection.find(whereQuery);
			Iterator<Document> it = iterDoc.iterator();

			if (it.hasNext()) {
				data = it.next();
				componentId = (int) data.get("Component_Id");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error while getting component id from scipt name");
		}
		return componentId;
	}

	public static Connection establishDBConnection() throws Exception {
		String ConnectionString = "", Username = "", Password = "", sProjectQuery = "", sProjectTypeQuery = "",
				dbDriver = "";
		Connection SQLCon = null;
		ConnectionString = getPollerConfiguration("ConnectionString");
		Username = getPollerConfiguration("Username");
		Password = getPollerConfiguration("Password");
		// Password=LibraryClass.decryptpasssword(getPollerConfiguration("Password"));//0002023
		dbDriver = getPollerConfiguration("ConnectionDriver"); // Mantis 0001966
		String connectionURL = ConnectionString + "?user=" + Username + "&password=" + Password
				+ "&noAccessToProcedureBodies=true&useUnicode=true&characterEncoding=UTF-8";
		Class.forName(dbDriver);
		SQLCon = DriverManager.getConnection(connectionURL); // Mantis 0001966

		return SQLCon;
	}

//	public static boolean abortExecution() throws Exception {
//		Connection SQLCon = establishDBConnection();
//		PreparedStatement preparedStatement = null;
//		String Machine_Status = null;
//		boolean abort = false;
//
//		String machineTableQuery = "{Call poller_abortExecution(?)}";
//		CallableStatement cStmt = SQLCon.prepareCall(machineTableQuery);
//		cStmt.setInt(1, exec_id);
//		cStmt.execute();
//		ResultSet rs = cStmt.getResultSet();
//		if (rs.next())
//			Machine_Status = rs.getString("Machine_Status");
//
//		if (Machine_Status.equalsIgnoreCase("abort"))
//			abort = true;
//
//		return abort;
//	}

	public static boolean abortExecution() throws Exception {

		String Machine_Status = null;
		boolean abort = false;
		Document data = null;

		collection = db.getCollection("machine_details");

		whereQuery.put("Machine_ID", exec_id);
		FindIterable<Document> iterDoc = collection.find(whereQuery);
		Iterator<Document> it = iterDoc.iterator();

		if (it.hasNext()) {
			data = it.next();
			Machine_Status = (String) data.get("Machine_Status");

			if (Machine_Status.equalsIgnoreCase("abort"))
				abort = true;
		}
		return abort;
	}

	@SuppressWarnings("resource")
	public static void getChromePIDs() throws Exception // Mantis: 0001573
	{
		final String jvmName = ManagementFactory.getRuntimeMXBean().getName();
		final int index = jvmName.indexOf('@');
		File processIds = new File(System.getProperty("user.dir") + "/logs/ProcessId_logs.txt");
		FileOutputStream fos = FileUtils.openOutputStream(processIds);
		Scanner scan = null;

		if (index > 1) {
			try {
				String processId = Long.toString(Long.parseLong(jvmName.substring(0, index)));
				scan = new Scanner(Runtime.getRuntime()
						.exec("wmic process where (ParentProcessId=" + processId + ") get Caption,ProcessId")
						.getInputStream());
				scan.useDelimiter("\\A");
				String childProcessIds = scan.hasNext() ? scan.next() : "";
				List<String> chromeDrivers = new ArrayList<String>();
				List<String> chrome = new ArrayList<String>();
				String[] splited = childProcessIds.split("\\s+");

				for (int i = 0; i < splited.length; i++) {
					if ("chromedriver.exe".equalsIgnoreCase(splited[i])) {
						chromeDrivers.add(splited[i + 1]);
						processId = splited[i + 1];
					}
				}

				scan = new Scanner(Runtime.getRuntime()
						.exec("wmic process where (ParentProcessId=" + processId + ") get Caption,ProcessId")
						.getInputStream());
				scan.useDelimiter("\\A");
				childProcessIds = scan.hasNext() ? scan.next() : "";
				chromeDrivers = new ArrayList<String>();
				splited = childProcessIds.split("\\s+");
				for (int i = 0; i < splited.length; i++) {
					if ("chrome.exe".equalsIgnoreCase(splited[i])) {
						chrome.add(splited[i + 1]);
					}
				}

				for (int j = 0; j < chrome.size(); j++) {
					fos.write(chrome.get(j).getBytes());
				}
			} catch (Exception e) {
			} finally {
				if (fos != null) // Mantis 0001806
				{
					fos.close();
				}

				if (scan != null) // Mantis 0001806
				{
					scan.close();
				}
			}
		}
	}

	public static void killChromePIDs() throws Exception // Mantis: 0001573
	{
		List<String> pIDs = new ArrayList<String>();
		File logFile = new File(System.getProperty("user.dir") + "/logs/ProcessId_logs.txt");
		if (logFile.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(logFile));
			String readLine = br.readLine();
			while (readLine != null) {
				pIDs.add(readLine.toString().trim());
				readLine = br.readLine();
			}

			for (String pid : pIDs) {
				Runtime.getRuntime().exec("taskkill /F /PID " + pid);
				System.out.println("PID: " + pid + " Killed!!!");
			}
		}
	}

	@SuppressWarnings("resource")
	public static Boolean WriteDataInExcel(String fileName, Map<Integer, String> ColHeaders,
			ArrayList<ArrayList<String>> sheetData, String insertType) throws IllegalFormatException, IOException // Mantis
																													// 0001816
	{

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Report_Details");
		/*
		 * CellStyle backgroundStyle = workbook.createCellStyle();
		 * backgroundStyle.setFillBackgroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		 * backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		 */

		int rownum = 0;
		int cellnum = 0;
		int srno = 0;
		if (insertType.equalsIgnoreCase("new")) {
			Row row = sheet.createRow(rownum++);
			for (int i = 0; i < ColHeaders.size(); i++) {
				Cell cell = row.createCell(cellnum++);
				cell.setCellValue((String) ColHeaders.get(i));

				/* cell.setCellStyle(backgroundStyle); */
			}
		} else {
			workbook = (XSSFWorkbook) funExcelConnection(fileName);
			sheet = workbook.getSheetAt(0);
			rownum = sheet.getLastRowNum();
			srno = rownum - 1;
		}
		for (ArrayList<String> outer : sheetData) {
			Row row = sheet.createRow(rownum++);
			cellnum = 0;
			Cell cell = row.createCell(cellnum++);
			cell.setCellValue(++srno);
			for (String value : outer) {
				cell = row.createCell(cellnum++);
				cell.setCellValue((String) value);
			}
		}
		try {
			// this Writes the workbook gfgcontribute
			FileOutputStream out = new FileOutputStream(new File(fileName));
			workbook.write(out);
			out.close();
			System.out.println("Custom Report generated.");
			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	public static int checkIfBaselineImagIsPresent(String project_type, int project_id, String script_name,
			String testcase, String checkpointname, String jsondetails) throws SQLException // Mantis 0001911
	{
		Connection SQLCon = null;
		try {
			SQLCon = establishDBConnection();
			JSONArray jsonArray = null;
			JSONObject jsonObject = null;
			jsonArray = (JSONArray) new JSONTokener(jsondetails).nextValue();
			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObject = jsonArray.getJSONObject(i);
				try {
					if (jsonObject.get(ImageVerificationJsonKeys.CHECKPOINT_NAME.toString()).equals(checkpointname)) {
						return Integer.parseInt(
								jsonObject.get(ImageVerificationJsonKeys.CHECKPOINT_ID.toString()).toString());
					}
				} catch (Exception e) {
					// Mantis 0001939
					System.out.println("Error in JSON Object " + jsonObject + "\n" + e.getMessage());
				}
			}
			return -1;
		} catch (Exception e) {
			System.out.println("Error while checking if baseline image is present or not");
			e.printStackTrace();
		} finally { // Mantis 0002020
			if (SQLCon != null) {
				SQLCon.close();
			}
		}
		return -1;
	}

	public static int getLastCheckpointId(String project_type, int project_id, String script_name, String testcase,
			String jsondetails) // Mantis 0001911
	{
		try {
			JSONArray jsonArray = null;
			JSONObject jsonObject = null;
			jsonArray = (JSONArray) new JSONTokener(jsondetails).nextValue();
			int id = -1;
			jsonObject = jsonArray.getJSONObject(jsonArray.length() - 1);
			id = Integer.parseInt(jsonObject.get(ImageVerificationJsonKeys.CHECKPOINT_ID.toString()).toString());
			return id;
		} catch (Exception e) {
			System.out.println("Error while checking if baseline image is present or not");
			e.printStackTrace();
		}
		return -1;
	}

	public static String checkIfBaselineScriptIsPresent(String project_type, int project_id, String script_name,
			String testcase, String browser) throws SQLException // Mantis 0001911,0001950
	{
		try {

			int componentID = -1;
			String jsondetails = "";

			Document data = null;

			componentID = getComponentIdFromName(script_name, project_id);

			whereQuery.put("component_id", componentID);
			whereQuery.put("testcase", testcase);
			whereQuery.put("project_id", project_id);
			whereQuery.put("browser", browser);

			FindIterable<Document> iterDoc = collection.find(whereQuery);
			Iterator<Document> it = iterDoc.iterator();

			if (it.hasNext()) {
				data = it.next();
				jsondetails = ((Document) data).getString(ImageVerificationJsonKeys.CHECKPOINT_DETAILS.toString());
			}
			if (jsondetails.trim().length() == 0)
				return null;
			else
				return jsondetails;
		} catch (Exception e) {
			System.out.println("Error while checking if baseline image is present or not");
			e.printStackTrace();
		}
		return null;
	}

	public static List<HashMap<String, String>> addBaselineImage(String project_type, int project_id,
			String script_name, String testcase, List<HashMap<String, String>> hmapList, String baselinepresent,
			int userId, String browser) throws SQLException // Mantis 0001911,0001950
	{
		List<HashMap<String, String>> modifyList = null;

		try {

			int componentID = -1;
			int tempcomponentID = -1; // Mantis id 0001949
			String jsondetails = "";
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			modifyList = new ArrayList<HashMap<String, String>>();

			// get component id qweb_getComponentData
			componentID = getComponentIdFromName(script_name, project_id);
			System.out.println("Component id returned " + componentID);
			if (componentID == -1) { // Mantis id 0001949
				tempcomponentID = getTempComponentIdFromName(script_name, project_id);
			}

			if (baselinepresent.startsWith("scriptabsent")) {
				int i = 0;
				for (HashMap<String, String> hmapObj : hmapList) {
					jsonObject = new JSONObject();
					jsonObject.put(ImageVerificationJsonKeys.CHECKPOINT_ID.toString(), i);
					jsonObject.put(ImageVerificationJsonKeys.CHECKPOINT_NAME.toString(),
							hmapObj.get(ImageVerificationJsonKeys.CHECKPOINT_NAME.toString()));
					jsonObject.put(ImageVerificationJsonKeys.BASELINE_IMAGE_PATH.toString(),
							hmapObj.get(ImageVerificationJsonKeys.BASELINE_IMAGE_PATH.toString()));
					jsonObject.put(ImageVerificationJsonKeys.DYNAMIC_REGION.toString(),
							hmapObj.get(ImageVerificationJsonKeys.DYNAMIC_REGION.toString()));
					jsonArray.put(jsonObject);

					hmapObj.put(ImageVerificationJsonKeys.CHECKPOINT_ID.toString(), i + "");
					i++;
					modifyList.add(hmapObj);
				}
			} else if (baselinepresent.startsWith("checkpointabsent")) {
				int index = baselinepresent.indexOf('_');
				jsondetails = baselinepresent.substring(index + 1);
				if (jsondetails.length() > 0) {
					jsonArray = (JSONArray) new JSONTokener(jsondetails).nextValue();
				}
				int lastid = getLastCheckpointId(project_type, project_id, script_name, testcase, jsondetails);
				jsonObject.put(ImageVerificationJsonKeys.CHECKPOINT_ID.toString(), lastid + 1); // to do change here
				jsonObject.put(ImageVerificationJsonKeys.CHECKPOINT_NAME.toString(),
						hmapList.get(0).get(ImageVerificationJsonKeys.CHECKPOINT_NAME.toString()));
				jsonObject.put(ImageVerificationJsonKeys.BASELINE_IMAGE_PATH.toString(),
						hmapList.get(0).get(ImageVerificationJsonKeys.BASELINE_IMAGE_PATH.toString()));
				jsonObject.put(ImageVerificationJsonKeys.DYNAMIC_REGION.toString(),
						hmapList.get(0).get(ImageVerificationJsonKeys.DYNAMIC_REGION.toString()));
				jsonArray.put(jsonObject);
			}
			// insert entry for this script and test case

			collection = db.getCollection("baseline_images_table_details");

			Document document = new Document();
			document.put("component_id", componentID);
			document.put("testcase", testcase);
			document.put("project_id", project_id);
			document.put("checkpoint_details", jsonArray.toString());
			document.put("id", userId);
			document.put("browser", browser);
			document.put("temp_component_id", tempcomponentID);
			document.put("component_name", script_name);

			collection.insertOne(document);

		} catch (Exception e) {
			System.out.println("Error while Adding baseline image \n" + e.getMessage());
			e.printStackTrace();
		}
		return modifyList;
	}

	public static void addImageVerificationResults(String DriverPath, JSONArray array, int pass, int fail,
			String baselinebrowser, String verifymode) throws SQLException // Mantis 0001911,0001950,0001951
	{

		try {
			// System.err.println("JSON Array while adding the results \n"+array);
			JSONObject jObj = new JSONObject(DriverPath);
			int results_id = jObj.getInt(ImageVerificationJsonKeys.RESULT_ID.toString());
			int project_id = jObj.getInt(ImageVerificationJsonKeys.PROJECT_ID.toString());
			int release_id = jObj.getInt(ImageVerificationJsonKeys.RELEASE_ID.toString());
			Boolean unitTest = jObj.getBoolean("UnitTest");
			String overall = "";
			if (fail > 0)
				overall = "FAIL";
			else
				overall = "PASS";

			// insert entry for this script and test case
			if (unitTest == false)
				collection = db.getCollection("imageverification_results_details");
			else
				collection = db.getCollection("imageverification_unit_results_details");

			Document document = new Document();
			document.put("web_results_id", results_id);
			document.put("project_id", project_id);
			document.put("release_id", release_id);
			document.put("checkpoint_details", array.toString());
			document.put("pass_count", pass);
			document.put("fail_count", fail);
			document.put("overall_status", overall);
			document.put("baseline_browser", baselinebrowser);
			document.put("visual_verify_mode", verifymode);
			collection.insertOne(document);

		} catch (Exception e) {
			System.out.println("Error while Adding in Image Verification Results Table \n" + e.getMessage());
			e.printStackTrace();
		}

	}

	public static Object getApiTestingData(String apiName) {

		Integer projId = projectId;

		List<String> rowData = null;

		db = mongoClient.getDatabase(database);

		collection = db.getCollection("api_testing");

		Document data;
		whereQuery.put("api_name", apiName);
		whereQuery.put("project_id", 108);

		FindIterable<Document> iterDoc = collection.find(whereQuery);
		Iterator<Document> it = iterDoc.iterator();

		while (it.hasNext()) {
			data = it.next();
			rowData = new LinkedList<String>();
			rowData.add(data.getString(APITestingColumnHeader.APINAME.toString()));
			rowData.add(data.getString(APITestingColumnHeader.AUTHTYPE.toString()));
			rowData.add(data.getString(APITestingColumnHeader.BASEURL.toString()));
			rowData.add(data.getString(APITestingColumnHeader.USERNAME.toString()));
			rowData.add(data.getString(APITestingColumnHeader.PASSWORD.toString()));
//			rowData.add(data.getString(APITestingColumnHeader.APIHEADER.toString()));
//			rowData.add(data.getString(APITestingColumnHeader.APIPARAMETER.toString()));
			rowData.add(data.getString(APITestingColumnHeader.TOKENHEADER));
			rowData.add(data.getString(APITestingColumnHeader.TOKEPARAMETER));
			rowData.add(data.getString(APITestingColumnHeader.TOKENURL.toString()));
			rowData.add(data.getString(APITestingColumnHeader.GRANTTYPE.toString()));
			rowData.add(data.getString(APITestingColumnHeader.TOKENMETHOD.toString())); // Mantis: 2025
			break;
		}
		String json = new Gson().toJson(rowData);
		return json;
	}

	public static int getTempComponentIdFromName(String Component_Name, int Project_Id) {
		db = mongoClient.getDatabase(database);
		collection = db.getCollection("temp_component");
		Document data = null;
		MongoCursor<Document> iterDoc = null;
		int tempcomponentID = -1;
		try {
			whereQuery.put("Component_Name", Component_Name);
			whereQuery.put("Project_Id", Project_Id);
			iterDoc = collection.find(whereQuery).cursor();
//			Iterator<Document> it = iterDoc.iterator();

			if (iterDoc.hasNext()) {
				data = iterDoc.next();
				tempcomponentID = (int) data.get("Component_Id");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error while getting component id from scipt name");
		} finally {
			iterDoc.close();
		}
		return tempcomponentID;
	}

}

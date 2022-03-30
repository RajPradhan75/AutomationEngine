/*---------------------------- Change History ------------------------------*/

/*
 * Date: 17 July 2017
 * By: Deepankar
 * Title: Mantis 0000696
 /*
/*
 * Date: 17 Sep 2016
 * By: Deepankar
 * Title: Mantis 0000376 and 0000380
 /*
/*
 * Date: 12 Sep 2016
 * By: Deepankar
 * Title: Set sThinkTime = 0 when no think time is passed from configuration file
 /*
 * Date: 26 July 2016
 * By: Heramb Bedekar
 * Title: Added two new functions to check whether framework folder structure is appropriate or not.
 * Changes: 
 * 			Functions Added: 1. checkFolderStructure() --> Call functions for checking various files or folders exist or not.
 * 							 2. checkFileExists(String sFilePath) --> Check if file/folder exists or not.
 * 								If yes then proceed for further execution else terminate execution.	 	
 * 			Variables Added: 
 * 							String:  sFilePath(Path to framework file/folder)
 */

/*
 * Date: 21 July 2016
 * By: Heramb Bedekar
 * Title: Added Exception Handling with Proper Messages if "configuration.xlsx" file is not present
 * Changes: 
 * 			Functions Modified: 1. getConfig() --> Check if configuration.xlsx file exists.
 * 								   If yes then proceed ahead else terminate execution.
 * 								2. getConfig() --> Check if all the mandatory columns in configuration.xlsx file exist.
 * 								   If yes then proceed ahead else terminate execution.
 * 			Variables Added: 
 * 							String:  sConfigPath
 * 							File: file  
 */

/* Date: 20 July 2016
 * By: Rohidas Kendre
 * Title: Merged code so that Remote and Standalone Execution Can be peroformed using the same Jar File.
 * Changes:
 * 			Functions Added: 1. UpdateDatabase_pass()
 * 							 2. UpdateDatabase_fail()
 * 
 * 			Functions Modified: 1. getConfig() --> Get the value for 'Remote_Execution' from the Config.xlsx into 'sRemote_Exec' String
 * 								2. executeScenario() -->Based on whether it is Remote_Execution or not, make the Entry in the Database for the Scenario pass or failure.
 * 								3. createFunctionalLogCSVFile() --> Set value for the sResultFileNameDatabase. 
 * 								4. createDebugLogCSVFile() --> Set value for the sDebugLogFileNameDb.		
 * 			Variables Added: 
 * 							String:  sRemote_Exec,sExcelFileName,sResultFileNameDatabase,sDebugLogFileNameDb,thispcip,sScenaNameForDBUpdate;
 */
/*
 * Date: 07 July 2017
 * By: Priti
 * Title: Commenting unwanted System.out.print statements 
 * Mantis 0000680		
 */
/*
 * Date: 11 August 2017
 * By: Manoj Bamnawat
 * Title: Runwebscript enhancement
 * Mantis 0000703		
 */
/*
 * Date: 21 Sept 2017
 * By: Manoj Bamnawat
 * Title: 
 * Mantis 0000742		
 */
/*
 * Date: 21 Sept 2017
 * By: Manoj Bamnawat
 * Title: 
 * Mantis ID: 0000719		
 */
/*
 * Date: 18th Oct 2017
 * By: Manoj Bamnawat
 * Title: 
 * Mantis ID: 0000753
 * 		
 */
/*
 * Date: 20th December 2017
 * By: Deepankar
 * Mantis ID: 0000790
 * 		
 */
/*
 * Date: 19th Jan 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000796
 * 		
 */
/*
 * Date: 22nd Jan 2018
 * By: Sowmya TB
 * Mantis ID: 0000797
 * 		
 */

/*
 * Date: 23rd Jan 2018
 * By: Sowmya TB
 * Mantis ID: 0000799
 * 		
 */

/*
 * Date: 1st Feb 2018
 * By: Sowmya TB
 * Mantis ID: 0000792
 * 		
 */
/*
 * Date: 20 Feb 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000798
 * 		
 */
/*
 * Date: 26 April 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000845
 * 		
 */
/*
 * Date: 11th May 2018
 * By: Anum Shaikh
 * Mantis ID: 0000854
 * 		
 */
/*
 * Date: 30th May 2018
 * By: Anum Shaikh
 * Mantis ID: 0000859
 * 		
 */
/*
 * Date: 6th June 2018
 * By: Anum Shaikh
 * Mantis ID: 0000866
 * 		
 */
/*
 * Date: 20th June 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000879
 * 
 */
/*
 * Date: 10th July 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000909
 * 
 */
/*
 * Date: 23 July 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000921
 * 
 */
/*
 * Date: 07 August 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000925,0000927,0000928,0000931
 * 
 */
/*
 * Date: 04 Sept 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000943, 0000952
 */
/*
 * Date: 18th Sept 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000953, 0000959
 */
/*
 * Date: 26th Sept 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000965
 */
/*
 * Date: 07 Dec 2018
 * By: Shaikh Anum
 * Mantis ID: 0001045
 */
/*
 * Date: 12 Dec 2018
 * By: Manoj Bamnawat
 * Changes: Added Rootpath feature.
 */
/*
 * Date: 18 Jan 2018
 * By: Anum Shaikh
 * Mantis id: 0001079,0001080
 */
/*
 * Date: 31 Jan 2019
 * By: Zoheb Fondu
 * Mantis ID: 0001094
 */
/*
 * Date: 11 March 2019
 * By: Anum Shaikh
 * Mantis ID: 0001131
 */
/*
 * Date: 25 April 2019
 * By: Anum Shaikh
 * Mantis ID: 0001153,0000903,0001156
 */
/*
 * Date: 09 July 2019
 * By: Zoheb Fondu
 * Mantis: 0001196
 */
/*
 * Date: 18 July 2019
 * By: Zoheb Fondu
 * Mantis: 0001204
 */
/*
 * Date: 22 July 2019
 * By: Zoheb Fondu
 * Mantis: 0001170
 */
/*
 * Date: 06 Aug 2019
 * By: Anum Shaikh
 * Mantis ID:  0001221
 */
/*
 * Date: 22 Aug 2019
 * By: Zoheb Fondu
 * Mantis: 0001249
 */
/*
 * Date: 27 Aug 2019
 * By: Zoheb Fondu
 * Mantis: 0001261
 */
/*
 * Date: 18 Nov 2019
 * By: Zoheb Fondu
 * Mantis: 0001470
 */
/*
 * Date: 22 Nov 2019
 * By: Zoheb Fondu
 * Mantis: 0001487
 */
/*
 * Date: 10 Feb 2019
 * By: Anum Shaikh
 * Mantis: 0001710
 */
/*
 * Date: 01 April 2020
 * By: Anum Shaikh
 * Mantis: 0001756
 */
/*
 * Date: 15 May 2020
 * By: Anum Shaikh
 * Mantis: 0001816
 */
/*
 * Date: 18 May 2020
 * By: Manoj Bamanwat
 * Mantis: 0001780
 */
/*
 * Date: 29 June 2020
 * By: Anum Shaikh
 * Mantis: 0001887,0001886
 */
/*
 * Date: 19 August 2020
 * By: Anum Shaikh
 * Mantis: 0001911
 */
/*
 * Date: 18 Nov 2020
 * By: Zoheb Fondu
 * Mantis: 0001959
 */
/*
 * Date:19 Nov 2020
 * By: Zoheb Fondu
 * Mantis: 0001960
 */
/*
 * Date:13 Jan 2021
 * By: Zoheb Fondu
 * Mantis: 0001970
 */
/*
 * Date:15 Jan 2021
 * By: Anum Shaikh
 * Mantis: 0001951,0001950
 */


package com.nexops.auto.remediate.webautomation;
import java.awt.AWTException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import org.springframework.util.FileCopyUtils;


import com.nexops.auto.remediate.constants.ConfigColumnHeader;
import com.nexops.auto.remediate.constants.DriverColumnHeader;
import com.nexops.auto.remediate.exception.CustomDataBaseException;
import com.nexops.auto.remediate.exception.CustomException;
import com.nexops.auto.remediate.exception.InvalidTypeException;
import com.nexops.auto.remediate.exception.NoSuchTagException;
import com.nexops.auto.remediate.exception.NoTempDataPresent;
import com.nexops.auto.remediate.util.CSVtoExcel;
import com.nexops.auto.remediate.util.CSVtoHTML;
import com.nexops.auto.remediate.util.ExcelConnection;
import com.nexops.auto.remediate.util.Utility;
import com.nexops.auto.remediate.util.VLCScreenRecorder;


public class KeywordDrivenFramework  
{
	Connection con;
	LibraryClass oWebSite;
	Statement st;
	ResultSet rs;
	Workbook resultSetWorkbook;
	List<List<String>> resultSet;
	ListIterator<List<String>> resultSetIterator;
	Map<String, Integer> resultSetColumns;
	List<String> resultSetRecord;
	public static String sTimeStampFormat,resultLogDirectory;  //Mantis 0000928
	public String appiumProcess = null;// Mantis 0000703 
	String sRunFlag, sScenerioName, sCurrentDir, sTestCaseNo, sTestCaseExcelPath, sProcessDebugLogFileName,
	sDebugLogFileName, sFunctionalLogFileName, sOperation, sComments, sBrowser, sBrowserPath, sPageWaitTime,
	sThinkTime, sFrameWaitTime, sAutoClose, sPageLoadTimeout, sScreenShotFilePath, sStart_Time, sEnd_Time, sWindowTimeout,sElementWait,sNTLM,sUsername,sPassword; //Mantis 0000792 //Mantis 0000854,0000879 // Mantis 0000703, 0000953	0001131
	static boolean blnError = false; // Mantis 0000703
	String exceptionMessage;// Mantis 0000703
	boolean allowSysOuts=false; // Mantis 0000792	
	int startTimeCounter=0; // Mantis 0000798
	String sRemote_Exec, sExcelFileName, sResultFileNameDatabase, sDebugLogFileNameDb, thispcip, sScenaNameForDBUpdate; //Global string sRemote_Exec declared to check and Run according to Configuration
	private static String sCurScenerioName;
	private String sWebPagePath;   //Mantis 0001221
	private static String sScriptId;
	public static String systemouts,sFileWait,gScreenshot,gWebpage,sDownloadFolder; //Mantis 0000792   //Mantis 0001045  0001079,0001816
	public static String scripts[]; //Mantis 0001911
	public static String mandatory="";		//Mantis 0001887
	public static Boolean mandatoryFlag=false, emailNotify=false,failedStatus=false;		//Mantis 0001887

	public static VLCScreenRecorder recorder;
	
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private ApplicationContext springContainer;

	public static String getsScriptId()		//Mantis: 0001487
	{
		return sScriptId;
	}

	@SuppressWarnings("static-access")
	public void setsScriptId(String sScriptId) 		//Mantis: 0001487
	{
		
		this.sScriptId = sScriptId;
	}

	public KeywordDrivenFramework(String driver) throws Exception 
	{
		sDebugLogFileName = "";
		sFunctionalLogFileName = "";
		resultLogDirectory=null; //Mantis 0000928
		oWebSite = null;
		con = null;
		getConfig(driver); //  Mantis 0000799, 0001170
		checkFolderStructure();// Mantis 0000799
		sStart_Time = "";  // Mantis 0000798

		recorder = new VLCScreenRecorder();
	}

	/*
	--------------------------------------- START : errorScreenShot----------------------------------------------
	Function Name: errorScreenShot 
	Objective: A function to take the screenshot when an error has occured. 
	Date Created:
	Input:
	Output:
	Revision History:
	Modified on:
	Comments:
	---------------------------------------------------------------------------------------------------------
	 */

	void errorScreenShot(int sStepNo)
	{
		try 
		{
			Boolean flag= false; //Mantis 0000928
			String delimiter ="/|\\\\"; //Mantis 0000928
			File scrFile = ((TakesScreenshot) oWebSite.oDriver).getScreenshotAs(OutputType.FILE);

			String excelName=sTestCaseExcelPath.split(delimiter,-1)[sTestCaseExcelPath.split(delimiter,-1).length-1]; //Mantis 0000928

			File targetFile=null;
			if (excelName.contains("."))
				targetFile= new File(KeywordDrivenFramework.resultLogDirectory+"/Screenshots/Error_"+excelName.substring(0, excelName.lastIndexOf("."))+"_"+"_Step_"+sStepNo+".jpg"); //Mantis 0000796	
			else
				targetFile= new File(KeywordDrivenFramework.resultLogDirectory+"/Screenshots/Error_"+excelName.concat("_"+"_Step_"+sStepNo+".jpg")); //Mantis 0000796


			FileUtils.copyFile(scrFile,targetFile); //Mantis 0000796, 0000928
			/*----Mantis 0000928----*/
			flag=true;
			if(flag==true)
			{
				FileUtils.forceDelete(scrFile);
			}
			/*----Mantis 0000928----*/
			if (excelName.contains("."))
				sScreenShotFilePath = KeywordDrivenFramework.resultLogDirectory+"/Screenshots/Error_"+excelName.substring(0, excelName.lastIndexOf("."))+"_"+"_Step_"+sStepNo+".jpg"; //Mantis 0000796
			else
				sScreenShotFilePath = KeywordDrivenFramework.resultLogDirectory+"/Screenshots/Error_"+excelName.concat("_"+"_Step_"+sStepNo+".jpg"); //Mantis 0000796

		} catch (UnhandledAlertException e) {
			exceptionMessage = e.getMessage();// Mantis 0000703
		} catch (Exception e) {
			e.printStackTrace();
			exceptionMessage = e.getMessage();// Mantis 0000703
		}
	}

	/*
	--------------------------------------- START : getConfig----------------------------------------------
	Function Name: getConfig 
	Objective: A function to get mandatory configuration values from the config file 
	Date Created: 
	Input: 
	Output: 
	Revision History: 
	Modified on:01/12/2015 
	Comments: Added one more parameter in the configuration file i.e "Wait_Time" (Maximum waiting time for element to be searched).
	---------------------------------------------------------------------------------------------------------
	 */

	private void getConfig(String Driver) throws Exception		//Mantis: 0001170
	{
		Map<String, Integer> colHeader;
		List<List<String>> rs;
		JSONObject jsonObj = new JSONObject(Driver);
		try
		{
			colHeader = ExcelConnection.getMasterDataFileColumns("Configuration");		//Mantis: 0001261
			rs = ExcelConnection.readConfigData(Driver);		//Mantis:0001261

			ListIterator<List<String>> rowIterator = rs.listIterator();
			if (rowIterator.hasNext())
			{
				List<String> row = rowIterator.next();
				sBrowser = jsonObj.getString("Browser");
				sTimeStampFormat = "dd-MM-yyyy";
				sPageWaitTime = row.get(colHeader.get(ConfigColumnHeader.PAGE_WAIT_TIME.toString()));
				sFrameWaitTime = row.get(colHeader.get(ConfigColumnHeader.FRAME_WAIT_TIME.toString()));
				sAutoClose = row.get(colHeader.get(ConfigColumnHeader.AUTO_CLOSE.toString()));
				sPageLoadTimeout = row.get(colHeader.get(ConfigColumnHeader.LOAD_TIMEOUT.toString()));
				sWindowTimeout = row.get(colHeader.get(ConfigColumnHeader.WINDOW_TIMEOUT.toString())); //Mantis 0000854
				sElementWait = row.get(colHeader.get(ConfigColumnHeader.ELEMENT_WAIT.toString())); //Mantis 0000879
				sFileWait=row.get(colHeader.get(ConfigColumnHeader.FILE_WAIT.toString()));   //Mantis 0001079
				sNTLM=row.get(colHeader.get(ConfigColumnHeader.NTLM.toString()));          //Mantis 0001131
				sUsername=row.get(colHeader.get(ConfigColumnHeader.USERNAME.toString()));  //Mantis 0001131
				sPassword=row.get(colHeader.get(ConfigColumnHeader.PASSWORD.toString()));  //Mantis 0001131
				gScreenshot = row.get(colHeader.get(ConfigColumnHeader.SCREENSHOT.toString()));		//Mantis: 0001249
				gWebpage =  row.get(colHeader.get(ConfigColumnHeader.WEBPAGE.toString()));		//Mantis: 0001249
				sDownloadFolder=row.get(colHeader.get(ConfigColumnHeader.DOWNLOAD_FOLDER.toString()));  //Mantis 0001045,0001816

				if (sBrowser == null || sBrowser.isEmpty() || sBrowser.equalsIgnoreCase("null"))
					sBrowser = "chrome"; //Mantis 0000921
				if (sBrowserPath == null)
					sBrowserPath = "";
				if (sTimeStampFormat != null) 
				{
					switch (sTimeStampFormat.toLowerCase().trim()) 
					{
					case "us":
						sTimeStampFormat = "MM_dd_yyyy_hh_mm_ss_a";
						break;
					case "uk":
						sTimeStampFormat = "dd_MM_yyyy_hh_mm_ss_a";
						break;
					default:
						sTimeStampFormat = "dd_MM_yyyy_hh_mm_ss_a";
						break;
					}
				}
				if (sPageWaitTime == null)
					sPageWaitTime = "5";  //Mantis 0000845, 0000921
				if (sFrameWaitTime == null)
					sFrameWaitTime = "1";  //Mantis 0000845, 0000921
				if (sAutoClose == null)
					sAutoClose = "Y";
				if (sPageLoadTimeout == null)
					sPageLoadTimeout = "300"; // Mantis 0000742
				if(sWindowTimeout==null) //Mantis 0000854
					sWindowTimeout="120"; //Mantis 0000921
				if(sElementWait==null) //Mantis 0000879
					sElementWait="60"; //Mantis 0000909
				if(sFileWait==null)   //Mantis 0001079
					sFileWait="240";
				if(sNTLM==null)   //Mantis 0001131
					sNTLM="n";
				if(sUsername==null) //Mantis 0001131
					sUsername="";
				if(sPassword==null) //Mantis 0001131
					sPassword="";
				if(sDownloadFolder == null) //Mantis 0001816
					sDownloadFolder="";
			} 
			else 
			{
				System.out.println("Missing Configuration Parameters, Suspending execution");
				System.exit(0);
			}
		} 
		catch (IllegalFormatException e1) 
		{
			System.out.println("Invalid file format, Suspending execution");
			exceptionMessage = e1.getMessage();// Mantis 0000703
			e1.printStackTrace();
			System.exit(0);
		} 
		catch (NullPointerException e3)
		{
			System.out.println("One of the mandatory column ['Browser','Firefox_Path','Time_Stamp_Format','Page_Wait_Time','Frame_Wait_Time','Auto_Close','Load_Timeout','Think_Time','Remote_Execution','SysOut','Window_Timeout','Element_Wait','File_Wait','NTLM','Username','Password','Download_Folder'"+
					"]is absent in configuration file, Suspending execution");   //Mantis 0000859 0001079 0001131 0001816 
			e3.printStackTrace();
			exceptionMessage = e3.getMessage();// Mantis 0000703
			System.exit(0);
		}
		finally {

		}
	}

	/*
	--------------------------------------- START : getCurrentScenario---------------------------------------------- 
	Function Name: getCurrentScenario 
	Objective: A function to get Current scenario for execution 
	Date Created: 
	Input: 
	Output: 
	Revision History: 
	Modified on:
	Comments: returns the current scenario name for execution.
	----------------------------------------------------------------------------------------------------------------
	 */
	public static String getCurrentScenario() 
	{
		return sCurScenerioName;
	}

	public static String checkpath(String filename,String foldername) throws Exception //Mantis 0000866  //Mantis 0001045
	{ 		
		if(filename.length()==0)    //Mantis 0001156
			throw new FileNotFoundException("Filename cannnot be blank");

		if(!filename.contains(".xls"))
			filename=filename+".xlsx";

		if((filename.startsWith("\\\\")) || (filename.charAt(1)==':'))  //Mantis 0000952
		{
			System.out.println("Absolute Path "+filename);
		}
		return filename;
	}

	/*
	--------------------------------------- START : executeScenario----------------------------------------------
	Function Name: executeScenario 
	Objective: A Function to Execute Scenarios 
	Date Created:
	Input: 
	Output: 
	Revision History: checked if the driver4 object.tostring contains + 
	Modified on: 
	Comments: Get the values of testcaseno, RunFlag,ExcelPath, if (RunFlag = Y) call library class passing browser and browserpath, 
	 		  log the steps with date and time, call function Execute Testcases, Catch the required exception if occurs. Call the 
	 		  debug and functional log
	--------------------------------------------------------------------------------------------------------------
	 */

	private void executeScenario(String Driver) throws NoSuchAlgorithmException, IOException 
	{
		boolean scenarioRunFlag = true;
		JSONObject jObj = new JSONObject(Driver);
		String project_type = (String) jObj.get("ProjectType");
		try 
		{
			do
			{
				System.out.println("Inside executeScenario");
				sRunFlag = resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.RUN_FLAG.toString()));
				sTestCaseExcelPath = resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.EXCEL_PATH.toString()));
				if(resultSetColumns.containsKey("ID"))
					setsScriptId(resultSetRecord.get(resultSetColumns.get("ID")));		//Mantis: 0001487

				if (!(Driver.startsWith("{")))
					sTestCaseExcelPath=checkpath(sTestCaseExcelPath,"Keywords_&_Data"); //Mantis 0000866  //Mantis 0001045

				sTestCaseNo = resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.TEST_CASE.toString()));

				if (sRunFlag.trim().toUpperCase().equals("Y"))
				{
					if (!(Driver.startsWith("{")))
						checkFileExists(sTestCaseExcelPath);   //Mantis 0001045 0001080

					if (oWebSite == null || oWebSite.getDriver().toString().contains("(null)"))
						oWebSite = new LibraryClass(sBrowser, sBrowserPath, sPageWaitTime, sFrameWaitTime,
								sPageLoadTimeout,sWindowTimeout,sElementWait);  //Mantis 0000879

					String svn="2280";
					System.out.println("QTAF SVN Version "+svn);
					oWebSite.debugLog("SVN_Version", svn); // SVN Version
					oWebSite.setSysouts(allowSysOuts); //Mantis 0000925

					SimpleDateFormat d1 = new SimpleDateFormat(sTimeStampFormat);
					Date dStartTimestamp = d1.parse(new SimpleDateFormat(sTimeStampFormat).format(new Date()));

					// Mantis 0000798
					if(startTimeCounter==0)
					{
						SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
						sStart_Time=localDateFormat.format(dStartTimestamp);
						System.out.println("Start Time: "+sStart_Time);
						startTimeCounter++;
					}
					oWebSite.oFunctionLog.setTestCaseName(getCurrentScenario(), sTestCaseExcelPath, dStartTimestamp);

					/*
					if(project_type.equalsIgnoreCase("SAP"))
						LibraryClass.runvbscript(sTestCaseNo, sTestCaseExcelPath, sFunctionalLogFileName);
					else 
					 */	
					if(project_type.equalsIgnoreCase("web"))
						oWebSite.executeTestCase(sTestCaseExcelPath, sTestCaseNo,sNTLM,sUsername,sPassword,Driver);   //Mantis 0001131

					oWebSite.oFunctionLog.writeFunctionalLog();
					oWebSite.oFunctionLog.clearLists();
				}
				if (resultSetIterator.hasNext()) 
				{
					resultSetRecord = resultSetIterator.next();
					sScenerioName = resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.TEST_SCENARIO.toString()));
					if(mandatoryFlag == true)  //Mantis 0001887
					{
						try 
						{
							mandatory =resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.MUST_EXECUTE.toString()));
						}
						catch(NullPointerException e) 
						{
							System.out.println("Must_Execute column not found in script "+
									resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.EXCEL_PATH.toString())));
							mandatory="n";
						}
						if(!mandatory.equalsIgnoreCase("y"))
						{
							scenarioRunFlag = false;
						}
					}
				} 
				else 
				{
					scenarioRunFlag = false;
				}

			} while ((sScenerioName == null || sScenerioName.equalsIgnoreCase("null") || sScenerioName.trim().isEmpty()) && scenarioRunFlag);		//Mantis 0001204,1470

			if(scenarioRunFlag) 
			{
				resultSetRecord = resultSetIterator.previous();
				sScenerioName = resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.TEST_SCENARIO.toString()));
				oWebSite.debugLog("", "Scenario Completed");
			}

		}

		catch (java.util.NoSuchElementException e)
		{
			exceptionMessage = e.getMessage(); // Mantis 0000703
		} 
		catch (NoSuchElementException e) 
		{
			sOperation = "Object Sync";
			sComments = "Object Not found: Identifier=" + oWebSite.sIdentifier + " Identifier Value="
					+ oWebSite.sIdentifierValue;
			if (oWebSite.sTestStepData != null)
				sComments = sComments + " Test Data=" + oWebSite.sTestStepData;
			exceptionMessage = e.getMessage(); // Mantis 0000703
			blnError = true;
		} 
		catch (NoSuchTagException e) 
		{
			blnError = true;
			sOperation = "Object Sync";
			sComments = "Object properties are invalid: Identifier=" + oWebSite.sIdentifier + " Identifier Value="
					+ oWebSite.sIdentifierValue;
			exceptionMessage = e.getMessage(); // Mantis 0000703

		} 
		catch (NumberFormatException e) 
		{
			blnError = true;
			sOperation = "Index Conversion";
			sComments = "Error while Casting";
			e.printStackTrace();
			exceptionMessage = e.getMessage();// Mantis 0000703
		} 
		catch (InterruptedException e) 
		{
			exceptionMessage = e.getMessage();// Mantis 0000703
		}
		catch (AWTException e)
		{
			exceptionMessage = e.getMessage();// Mantis 0000703
		}
		catch (ParseException e)
		{
			blnError = true;
			exceptionMessage = e.getMessage();// Mantis 0000703
		} 
		catch (NoTempDataPresent e) {
			blnError = true;
			sComments = e.getMessage();
			exceptionMessage = e.getMessage();// Mantis 0000703
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			blnError = true;
			exceptionMessage = e.getMessage();// Mantis 0000703
		}
		catch (CustomException e) //Mantis 0001780
		{
			sOperation = "Sync Operation";
			sComments = e.getMessage();
			blnError = true;
			exceptionMessage = e.getMessage();// Mantis 0000703
		} 
		catch (NoSuchWindowException e) {
			blnError = true;
			sComments = "Window not found";
			exceptionMessage = e.getMessage();// Mantis 0000703
		}
		catch (NoSuchFileException e) {
			//sComments = "File Not Found"; //Mantis 0001450
			sComments=e.getMessage(); //Mantis 0001450	
			blnError = true;
			exceptionMessage = e.getMessage();// Mantis 0000703
		} 
		catch (InvalidTypeException e) {
			sOperation = "Object Sync";
			sComments = e.getMessage();
			blnError = true;
			exceptionMessage = e.getMessage();// Mantis 0000703
		}
		catch (InvalidNameException e) {
			e.printStackTrace();
			sOperation = "Object Sync";
			sComments = e.getMessage();
			blnError = true;
			exceptionMessage = e.getMessage();// Mantis 0000703
		}
		/*
		catch (InvalidDataException e) {
			e.printStackTrace();
			sOperation = "";
			sComments = e.getMessage();
			blnError = true;
			exceptionMessage = e.getMessage();// Mantis 0000703
		} 
		 */
		catch (NoSuchFieldException e) {
			sOperation = "Object Sync";
			sComments = e.getMessage();
			blnError = true;
			exceptionMessage = e.getMessage();// Mantis 0000703
		}
		catch (UnhandledAlertException e) {
			sOperation = "Object Sync";
			sComments = "Alert is appearing and not handled";
			blnError = true;
			exceptionMessage = e.getMessage();// Mantis 0000703
		}
		catch (NullPointerException e) {
			sOperation = "Object Sync";
			sComments = e.getMessage();
			blnError = true;
			exceptionMessage = e.getMessage();// Mantis 0000703
		}
		catch (CustomDataBaseException e) {
			sOperation = "Object Sync";
			sComments = e.getMessage();
			blnError = true;
			exceptionMessage = e.getMessage();// Mantis 0000703
		}
		catch (Exception e) {
			System.out.println("Message:" + e.getMessage());
			sOperation = "Object Sync";
			sComments = "Unexpected Exception Occured "+"["+e.getMessage()+"]"; 
			oWebSite.debugLog("Unexpected Exception Occured...", e.getMessage());
			blnError = true;
			exceptionMessage = e.getMessage();// Mantis 0000703
		} 
		finally 
		{
			oWebSite.storeDataInReport();   //Mantis 0001816
			if (blnError) 
			{
				failedStatus = true;
				if(gWebpage.equalsIgnoreCase("Y"))	//Mantis 0001249
					saveWebPage();   //Mantis 0001221

				System.out.println("Inside boolean error");
				System.out.println(sOperation + sComments);
				oWebSite.debugLog(sOperation, sComments);

				if(gScreenshot.equalsIgnoreCase("Y"))	//Mantis 0001249
					errorScreenShot(oWebSite.iStepNo); //Mantis 0000928

				oWebSite.processDebugLog(blnError, exceptionMessage, ""); // Mantis 0000703
				System.out.println("Failed Scenario");

				try 
				{
					System.out.println("Finally");
					oWebSite.oFunctionLog.setTestStepDetails(oWebSite.sTestCaseData, Integer.toString(oWebSite.iStepNo),
							oWebSite.sExpectedData, oWebSite.sActualValue, "Fail", sComments, sComments,
							sScreenShotFilePath,sWebPagePath); //Mantis 0001221
					oWebSite.oFunctionLog.writeFunctionalLog();
					if (resultSetIterator.hasNext()) 
					{
						resultSetRecord = resultSetIterator.next();
						System.out.println("Error next resultset record:" + resultSetRecord);
						sScenerioName = resultSetRecord
								.get(resultSetColumns.get(DriverColumnHeader.TEST_SCENARIO.toString()));
						try    //Mantis 0001887
						{
							mandatory =resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.MUST_EXECUTE.toString()));
						}
						catch(NullPointerException e) 
						{
							System.out.println("Must_Execute column not found in script "+
									resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.EXCEL_PATH.toString())));
							mandatory="n";
						}
						if(mandatory.trim().equals(""))
							mandatory="n";
						if(mandatory.equalsIgnoreCase("y"))
							mandatoryFlag=true;
					} 
					else 
					{
						scenarioRunFlag = false;
					}
					while ((sScenerioName == null || sScenerioName.equalsIgnoreCase("null")|| sScenerioName.trim().length() ==0)
							&& scenarioRunFlag && mandatory.equalsIgnoreCase("n"))		//Mantis 0001204,0001886,0001887
					{
						System.out.println("Inside failed scenario with multiple test cases");
						sRunFlag = resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.RUN_FLAG.toString()));
						System.out.println(sRunFlag);
						if (sRunFlag.equalsIgnoreCase("y"))
						{
							SimpleDateFormat d1 = new SimpleDateFormat(sTimeStampFormat);
							Date dStartTimestamp = d1.parse(new SimpleDateFormat(sTimeStampFormat).format(new Date()));
							sTestCaseExcelPath = resultSetRecord
									.get(resultSetColumns.get(DriverColumnHeader.EXCEL_PATH.toString()));
							oWebSite.oFunctionLog.setTestCaseName(getCurrentScenario(), sTestCaseExcelPath,
									dStartTimestamp);
							oWebSite.oFunctionLog.setTestStepDetails("", "", "", "", "Skipped", "", sComments, "",""); //Mantis 0001221
							oWebSite.oFunctionLog.writeFunctionalLog();
							oWebSite.oFunctionLog.clearLists();
						}
						if (resultSetIterator.hasNext()) 
						{
							resultSetRecord = resultSetIterator.next();
							System.out.println("Error next resultset record:" + resultSetRecord);
							sScenerioName = resultSetRecord
									.get(resultSetColumns.get(DriverColumnHeader.TEST_SCENARIO.toString()));
							try 	//Mantis 0001887
							{
								mandatory =resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.MUST_EXECUTE.toString()));
							}
							catch(NullPointerException e)
							{
								System.out.println("Must_Execute column not found in script "+
										resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.EXCEL_PATH.toString())));
								mandatory="n";
							}
							if(mandatory.trim().equals(""))
								mandatory="n";
							if(mandatory.equalsIgnoreCase("y"))
								mandatoryFlag=true;
						} 
						else
						{
							scenarioRunFlag = false;
						}
					}
					if(mandatory.equalsIgnoreCase("n")) 	//Mantis 0001887
						oWebSite.debugLog("", "Scenario Completed");
					if (scenarioRunFlag) 
					{
						resultSetRecord = resultSetIterator.previous();
						sScenerioName = resultSetRecord
								.get(resultSetColumns.get(DriverColumnHeader.TEST_SCENARIO.toString()));
						System.out.println("Scenario Name Outer loop:" + sScenerioName);
					}
				} catch (ParseException e) {
					oWebSite.debugLog("Inside Failure", "Parsing Date Exception");
					System.out.println("Parsing Exception Occured Inside Failure");
				} catch (Exception e) {
					oWebSite.debugLog("Inside Failure", "Unexpected Exception Occured");
					System.out.println("Unexpected Exception Occured Inside Failure");
				}
			} 
			else // blnError
			{
				oWebSite.processDebugLog(blnError, exceptionMessage, ""); // Mantis 0000703
				System.out.println("Scenario passed");
			}
			blnError = false;
		}
	}

	/*
	--------------------------------------- START : executeDriver----------------------------------------------
 	Function Name: executeDriver 
	Objective: A function to Start Execution of Test 
	Date Created:
	Input: 
	Output: 
	Revision History: 
	Modified on: 
	Comments: create the excel connection to read the driver sheet, get scenarioName and runflag, if
	 		  (runFlag is Y ) then call executeScenario Function , close the connection.
	------------------------------------------------------------------------------------------------------------
	 */

	public void executeDriver(String sTestDriver) 
	{
		String TestDriverPath=""; //Mantis 0000952
		sCurrentDir = System.getProperty("user.dir");
		try
		{
			if (sTestDriver != null)
			{
				if (sTestDriver.startsWith("{")) 
					TestDriverPath=sTestDriver;
				else
					TestDriverPath=checkpath(sTestDriver,"Driver");   //Mantis 0001045
			}
			System.err.println("Running Driver from "+TestDriverPath);
			/*-----Mantis 0000943-----*/
			createFunctionalLogCSVFile(TestDriverPath);
			createDebugLogCSVFile();
			LibraryClass.sDebugLogFileName = sDebugLogFileName;
			LibraryClass.sFunctionalLogFileName = sFunctionalLogFileName;
			/*-----Mantis 0000943-----*/

			if(appiumProcess!=null && appiumProcess.equalsIgnoreCase("Appium"))  //Mantis 0001073
				createProcessDebugLogTextFile();

			if (sTestDriver.startsWith("{")) 
			{
				String DriverJson = ExcelConnection.getDriversJsonfromDB(TestDriverPath);
				resultSetColumns = ExcelConnection.getColumnNamesFromJson(DriverJson, "Driver");
				resultSet = ExcelConnection.getDriverSheetDataFromJSON(DriverJson);
			}
			else
			{
				resultSetWorkbook = ExcelConnection.funExcelConnection(TestDriverPath);
				resultSetColumns = ExcelConnection.funGetSheetColumns(resultSetWorkbook, "Driver");
				resultSet = ExcelConnection.funGetSheetData(resultSetWorkbook, "Driver");
			}
			resultSetIterator = resultSet.listIterator();
			while (resultSetIterator.hasNext()) 
			{				
				// Mantis 0000680
				resultSetRecord = resultSetIterator.next();
				sScenerioName = resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.TEST_SCENARIO.toString()));
				try		//Mantis 0001887
				{
					mandatory =resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.MUST_EXECUTE.toString()));
				}
				catch(NullPointerException e) 
				{
					System.out.println("Must_Execute column not found in script "+
							resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.EXCEL_PATH.toString())));
					mandatory="n";
				}
				if (sScenerioName != null && !(sScenerioName.equalsIgnoreCase("null") || sScenerioName.trim().isEmpty())) 	//Mantis: 0001196
				{
					sCurScenerioName = sScenerioName;
				}
				sRunFlag = resultSetRecord.get(resultSetColumns.get(DriverColumnHeader.RUN_FLAG.toString()));

				/*-----Mantis 0000719-----*/
				if (sRunFlag == null) 
				{
					sRunFlag = "N";
				}
				/*-----Mantis 0000719-----*/
				if (sRunFlag.trim().toUpperCase().equals("Y"))
				{
					if(mandatoryFlag == true) 	//Mantis 0001887
					{
						if(mandatory.equalsIgnoreCase("y"))
							executeScenario(sTestDriver);
						else
							continue;
					}
					else
						executeScenario(sTestDriver);
				}
			}
			if(oWebSite.isImageVerificationAdded == true)	//Mantis 0001911
				oWebSite.executeImageVerification(sTestDriver);
		}
		catch (NumberFormatException e)
		{
			if (oWebSite != null)
				oWebSite.debugLog("Number Format Reading Driver File", e.getMessage());
		} 
		catch (IllegalFormatException e1) 
		{
			if (oWebSite != null)
				oWebSite.debugLog("Invalid file format", e1.getMessage());
			System.out.println("Invalid file format, Suspending execution");
		}
		catch (IOException e2)
		{
			if (oWebSite != null)
				oWebSite.debugLog("File not found", e2.getMessage());
			System.out.println("File not found,	Suspending execution");
		}
		catch (NullPointerException e3)
		{
			if (oWebSite != null)
				oWebSite.debugLog("One of the mandatory column is absent in Driver file", e3.getMessage());
			System.out.println("One of the mandatory column is absent in Driver/Test Case file, Suspending execution");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			System.out.println("Error Message:" + e.getMessage());
			oWebSite.debugLog("Unexpected Exception Occured...", e.getMessage());
		}

		finally 
		{
			File fZipFile = null;
			try
			{
				//MyScreenRecorder.stopRecording();
				recorder.stopRecording();
				recorder.releaseRecordingResources();

				if (resultSetWorkbook!=null) 
				{
					resultSetWorkbook.close();
				}
				System.out.println("Inside Finally");
				String[] args = new String[5];
				args[0] = sFunctionalLogFileName;
				DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String date = dateFormat.format(cal.getTime());
				sEnd_Time = date;
				args[1] = sStart_Time;
				args[2] = sEnd_Time;
				args[3] = sBrowser; //Mantis 0000953
				System.out.println("Writing Result");
				CSVtoExcel.CSVtoExcelConverter(sFunctionalLogFileName);		//Mantis 0001094
				CSVtoHTML.generateHTML(args[0],args[1],args[2],args[3],"web");   //Mantis 0001221,0001710
				System.out.println("AutoClose...." + sAutoClose);

				if(emailNotify == true && failedStatus == true)
				{
					List<String> attachmentFile = new ArrayList<String>();
					String zipFile = Utility.zipFolder(sFunctionalLogFileName.substring(0, sFunctionalLogFileName.lastIndexOf("/")));
					fZipFile = new File(zipFile);
					attachmentFile.add(zipFile);
					String emailFrom = ExcelConnection.getEmailConfiguration("emailfrom");
					String emailPwd = Utility.decryptpasssword(ExcelConnection.getEmailConfiguration("emailpassword"));
					String emailSubject = ExcelConnection.getEmailConfiguration("emailsubject");
					String emailBody = "PFA of compressed zip file for details. </br></br></br>"
							+ "This is an automated email notification. Please, do not reply this Email.</br></br>"
							+ "Regards,</br>"
							+ "QTAF Support Team";
					String emailTo = ExcelConnection.getEmailConfiguration("emailto");
					String emailCC = ExcelConnection.getEmailConfiguration("emailccto");

					Utility.sendEmail(emailFrom, emailPwd, emailTo, emailCC, "smtp.office365.com", emailSubject, emailBody, "587", attachmentFile);

				}
				if (!sAutoClose.equalsIgnoreCase("N"))
				{
					oWebSite.oDriver.close();
					oWebSite.oDriver.quit();
				}
				// -----Mantis 0000753-----//
				System.out.println("TaskKill....");
				switch (sBrowser.toLowerCase()) 
				{
				case "chrome":
					System.out.println("Task kill chromedriver.exe");
					Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
					break;
				case "ie":
					System.out.println("Task kill IEDriverServer.exe");
					//Runtime.getRuntime().exec("taskkill /f /im IEDriverServer.exe"); //Mantis 0000965 //0001756
					break; 
				}
				// -----Mantis 0000753-----//
			} catch (IOException e) {
				if (oWebSite != null)
					oWebSite.debugLog("Error in reading Driver File", e.getMessage());
			} catch (Exception e) {
				if (oWebSite != null)
					oWebSite.debugLog("Closing Connection to Driver File", e.getMessage());
			} 
			finally 
			{
				if(fZipFile != null)
				{
					if (fZipFile.delete()) //Mantis 1960
						System.out.println("Email Attachment Zip file Deleted successfully");
				}

				if (oWebSite != null)
					oWebSite.debugLog("Inside Finally", "Driver Reading Completed");
			}
		}
	}

	/*
	--------------------------------------- START : checkFolderStructure----------------------------------------------
	Function Name: checkFolderStructure 
	Objective: A function to check framework folder structure is existing and appropriate.
	Date Created: 25/07/2016 
	Input: 
	Output:
	Revision History: 
	Modified on: 
	Comments: Added as a part of Mantis ID 0000796
	------------------------------------------------------------------------------------------------------------------
	 */

	static Logger logger = LoggerFactory.getLogger(KeywordDrivenFramework.class);


	public void checkFolderStructure() throws IOException {

		ClassLoader classLoader = getClass().getClassLoader();

		String fileName = "SeleniumDrivers/chromedriver.exe";

		createFolder("SeleniumDrivers");
		createFolder("QWeb_Automation_lib");
		createFolder("logs");
		createFolder("Results");
		String os = System.getProperty("os.name").toLowerCase();
		if(os.contains("windows"))
			createFile("SeleniumDrivers/chromedriver.exe");
		else if(os.contains("linux"))
			createFile("SeleniumDrivers/chromedriver");
		createFile("QWeb_Automation_lib/selenium_java_srcs.jar");

		/*
		 * System.out.println("Enter the path where you want to create a folder:---  ");
		 * Scanner sc = new Scanner(System.in); String path = sc.next();
		 * 
		 * File file = new File(path); file.getParentFile().mkdir();
		 * file.createNewFile(); String outputFile = file.getPath();
		 */


		//System.out.println(resource.getFile().getPath());
		//System.out.println(resource.getFile().getAbsolutePath());



		/*
		 * sCurrentDir = System.getProperty("user.dir"); checkFileExists(sCurrentDir +
		 * "/Results"); checkFileExists(sCurrentDir + "/Results/Resources");
		 * checkFileExists(sCurrentDir + "/SeleniumDrivers");
		 */
		//checkFileExists(sCurrentDir + "/AutoIt");  //Mantis 0001131

		/*
		 * checkFileExists(classLoader.getResource("/Results").toString());
		 * checkFileExists(classLoader.getResource("/Results/Resources").toString());
		 * checkFileExists(classLoader.getResource("/SeleniumDrivers").toString());
		 * checkFileExists(classLoader.getResource("/AutoIt").toString()); //Mantis
		 * 0001131
		 */
		// Mantis 0000797
		/*
		 * if(sBrowser.equalsIgnoreCase("chrome")) { checkFileExists(sCurrentDir +
		 * "/SeleniumDrivers/chromedriver.exe"); } else
		 * if(sBrowser.equalsIgnoreCase("IE")) { checkFileExists(sCurrentDir +
		 * "/SeleniumDrivers/IEDriverServer.exe"); }
		 */
	}

	/*
	--------------------------------------- START : checkFileExists----------------------------------------------
	Function Name: checkFileExists 
	Objective: A function to check if file exists or not 
	Date Created: 25/07/2016 
	Input: 
	Output: 
	Revision History: 
	Modified on: 
	Comments:
	--------------------------------------------------------------------------------------------------------------
	 */

	public void checkFileExists(String sFilePath) 
	{
		File sFileName = new File(sFilePath);
		if (!sFileName.exists() || sFilePath.length()==0)  //Mantis 0001156
		{
			System.out.println("Stopping Execution, File/Directory " + sFilePath + " does not exist");
			System.exit(0);
		}
	}


	public void createFolder(String folderName) throws IOException {

		File file = new File(System.getProperty("user.dir").concat("/").concat(folderName));

		if(!file.exists())
			file.mkdir();


	}


	@SuppressWarnings("unused")
	public String createFile(String folderName) throws IOException {

		Resource resource = new ClassPathResource(folderName);

		InputStream inputStream = null;

		OutputStream outputStream = null;

		String data = null;

		int BUFFER_SIZE = 4096;

		
		try {
		
			String outputFolderName = folderName.substring(0,folderName.indexOf("/"));
			
			String outputFileName = folderName.substring(folderName.indexOf("/")+1);
						
			outputStream = new FileOutputStream(System.getProperty("user.dir").concat("/").concat(outputFolderName).concat("/").concat(outputFileName));

			inputStream = resource.getInputStream();


			byte[] bdata = FileCopyUtils.copyToByteArray(resource.getInputStream());

			data = new String(bdata, StandardCharsets.UTF_8);


			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			System.out.println("successfully copied");
		} catch (IOException e1) {
			logger.info(e1.getMessage());
		}


		// ClassPathResource classPathResource = new ClassPathResource("SeleniumDrivers/chromedriver_old.exe");


		finally {

			outputStream.close();
			inputStream.close();

		}
		return data;

	}
	
	
	@SuppressWarnings("unused")
	public void loadResources() {
	    try {
	        Resource[] resources = (Resource[]) applicationContext.getResources("classpath:/*.exe");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}

	/*
	--------------------------------------- START :createDebugLogCSVFile----------------------------------------------
	Function Name: createDebugLogCSVFile 
	Objective: A function to create CSV file of Debuglog
	Date Created: 
	Input: 
	Output: 
	Revision History: 
	Modified on: 
	Comments: log the execution steps in a csv file format
	--------------------------------------------------------------------------------------------------------------------
	 */

	void createDebugLogCSVFile() 
	{
		String sCurDate = new String("Debug_Log_");
		sCurDate = sCurDate.concat(new SimpleDateFormat(sTimeStampFormat).format(new Date()));
		try 
		{
			FileWriter oFileWriter = null;
			sDebugLogFileName = new String(resultLogDirectory + sCurDate + ".csv"); //Mantis 0000928
			oFileWriter = new FileWriter(sDebugLogFileName);
			oFileWriter.append("Test_Scenario,Excel_Path,Test_Case,Step_No,Current_Object,Operations,Comments\n");
			oFileWriter.flush();
			oFileWriter.close();
		} catch (IOException e) {

		} catch (Exception e) {

		}
	}

	/*
	--------------------------------------- START :createProcessDebugLogTextFile ----------------------------------------------
	Function Name: createProcessDebugLogTextFile 
	Objective: A function to create text file of process debug log 
	Date Created: 
	Input: 
	Output: 
	Revision History:
	Modified on: 
	Comments:Added as apart of Mantis ID 0000703
	---------------------------------------------------------------------------------------------------------------------------
	 */
	public void createProcessDebugLogTextFile()
	{
		System.out.println("Inside process call");
		sProcessDebugLogFileName = "";
		String hostname = "";
		sCurrentDir = System.getProperty("user.dir");
		sCurrentDir = sCurrentDir.concat("/Log/");  //Mantis 0000796

		try 
		{
			InetAddress addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
			System.out.println("Hostname=" + hostname);

			String sCurDate = new String(hostname);

			if (!sCurrentDir.endsWith("/"))  //Mantis 0000796
				sCurrentDir = sCurrentDir + "/";  //Mantis 0000796

			String runLogDirectory = sCurrentDir;
			String newSubDirectory = sCurDate.concat("_Process_Debug_Log");
			runLogDirectory = sCurrentDir.concat(newSubDirectory);
			File dir = new File(runLogDirectory);
			if (dir.exists()) 
			{
				System.out.println("Process Log directory exists");
			} 
			else
			{
				System.out.println("Creating new directory");
				new File(runLogDirectory).mkdir();
			}

			UUID uuid = UUID.randomUUID();
			String randomUUIDString = uuid.toString();
			sCurDate = sCurDate.concat("_" + randomUUIDString);

			runLogDirectory = runLogDirectory.concat("/" + sCurDate);  //Mantis 0000796
			FileWriter oFileWriter = null;
			sProcessDebugLogFileName = new String(runLogDirectory.concat(".txt"));
			oFileWriter = new FileWriter(sProcessDebugLogFileName);
			oFileWriter.write("DebugLogFilePath|" + sDebugLogFileName + System.getProperty("line.separator")
			+ "FunctionalLogFilePath|" + sFunctionalLogFileName + System.getProperty("line.separator"));

			oFileWriter.flush();
			oFileWriter.close();

			System.out.println("Process debug log file is created");
			LibraryClass.sProcessDebugLogFileName = sProcessDebugLogFileName;
			LibraryClass.appiumProcess = appiumProcess; // Mantis 0000703
		} catch (IOException e) {

		} catch (Exception e) {

		}
	}

	/*
	--------------------------------------- START : createFunctionalLogCSVFile----------------------------------------------
	Function Name: createFunctionalLogCSVFile 
	Objective: A function to create CSV file of Functional log 
	Date Created:
	Input:
	Output:
	Revision History:
	Modified on:
	Comments: log the result step wise of scenario in a csv file format.
	------------------------------------------------------------------------------------------------------------------------
	 */
	void createFunctionalLogCSVFile(String sDriverPath)
	{
		String dateFormat ="dd_MM_yyyy_hh_mm_ss_a"; //Mantis 0000928
		String driverName=""; //Mantis 0000943
		if (!sDriverPath.startsWith("{")) 
		{
			driverName=sDriverPath.replaceFirst(".*([\\/\\\\])(\\w+).*","$2"); //Mantis 0000943
		}
		else
		{
			JSONObject jo = new JSONObject(sDriverPath);
			driverName = jo.get("Driver").toString();
		}
		sCurrentDir = System.getProperty("user.dir");
		sCurrentDir = sCurrentDir.concat("/Results/");  //Mantis 0000796

		/*----Mantis 0000928----*/
		String newSubDirectory = new SimpleDateFormat(dateFormat).format(new Date());
		new File(sCurrentDir +driverName+"_"+newSubDirectory).mkdir(); //Mantis 0000943
		resultLogDirectory=sCurrentDir.concat(driverName+"_"+newSubDirectory); //Mantis 0000943
		if (!resultLogDirectory.endsWith("/"))
			resultLogDirectory= resultLogDirectory +"/";
		/*----Mantis 0000928----*/

		String sCurDate = new String("Result_"); //Mantis 0000928
		sCurDate = sCurDate.concat(new SimpleDateFormat(sTimeStampFormat).format(new Date()));
		try 
		{
			FileWriter oFileWriter = null;
			sFunctionalLogFileName = new String(resultLogDirectory + sCurDate + ".csv"); //Mantis 0000928
			oFileWriter = new FileWriter(sFunctionalLogFileName);
			//oFileWriter.append("Test_Scenario,Test_Case,Step_No,Status,Description,Detailed Description,Expected_Data,Actual_Data,Execution_Date,Execution_Time,Error_Screenshot\n");
			oFileWriter.append("Test_Scenario~Test_Case~Step_No~Status~Description~Detailed Description~Expected_Data~Actual_Data~Execution_Date~Execution_Time~Error_Screenshot~LastWebPage\n"); //Mantis 0000959,0001221
			oFileWriter.flush();
			oFileWriter.close();
		} catch (IOException e) {

		} catch (Exception e) {

		}
	}

	void debugLog(String sComments) 
	{
		try
		{
			System.out.println("Inside Debug Log File");

			FileWriter oFileWriter = null;
			oFileWriter = new FileWriter(sDebugLogFileName, true);
			oFileWriter.append(sComments + "\n");
			oFileWriter.flush();
			oFileWriter.close();
		} catch (IOException e) {

		}
	}
	void saveWebPage() throws IOException  //Mantis 0001221
	{
		/*JavascriptExecutor jes= (JavascriptExecutor)oWebSite.oDriver;*/

		/*PageSource=(String) jes.executeScript("return document.documentElement.outerHTML");
		System.err.println(PageSource);
	     writer = new BufferedWriter(new FileWriter(resultLogDirectory+"\\Lastwebpage.html"));       
	    writer.write(PageSource);
	    writer.close();*/
		sWebPagePath=resultLogDirectory+"\\LastWebPage.html";
		String PageSource=oWebSite.oDriver.getPageSource();
		BufferedWriter writer = new BufferedWriter(new FileWriter(sWebPagePath));
		writer.write(PageSource);
		writer.close();
	}
}

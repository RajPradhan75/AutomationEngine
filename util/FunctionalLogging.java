/*---------------------------- Change History ------------------------------
	Date: 27th  September  2016
 * By: Deepankar Bandopadhya
 * Title: 
 * Changes: Mantis ID 0000385	
 /*--
  *  * Date: 20th December 2017
 * By: Deepankar
 * Mantis ID: 0000790
  */
/*
 * Date: 19th Jan 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000796
 * 		
 */
/*
 * Date: 18th Sept 2018
 * By: Manoj Bamnawat
 * Mantis ID: 0000959		
 */
/*
 * Date: 06 Aug 2019
 * By: Anum Shaikh
 * Mantis ID:  0001221
 */
  
package com.nexops.auto.remediate.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import com.nexops.auto.remediate.webautomation.LibraryClass;




public class FunctionalLogging
{
	public String sTestProcess,	sTestScenario,sTestCaseName,sStatus,sResultFileName,sTestCaseErrorScreenshot;
	Date dStartTimestamp;
	public String sTestExecutionTime;
	List<String> sStepTestCaseIdentifier,sStepNo,sStepExpectedData,sStepActualData,sStepStatus,sStepDescription,sStepExecutionDate,sExectutionDetails,sErrorScreenshot,sWebPagePath;   //Mantis 0001221

	public FunctionalLogging(String sProcessName,String sScenarioName)
	{
		sTestProcess=sProcessName;
		sTestScenario=sScenarioName;
		this.sStatus="Pass";
		sTestCaseErrorScreenshot="";
		this.sResultFileName=LibraryClass.sFunctionalLogFileName;
		sStepTestCaseIdentifier= new ArrayList<String>();
		sStepNo= new ArrayList<String>();
		sStepExpectedData= new ArrayList<String>();
		sStepActualData= new ArrayList<String>();
		sStepStatus= new ArrayList<String>();
		sStepDescription= new ArrayList<String>();
		sStepExecutionDate= new ArrayList<String>();
		sExectutionDetails= new ArrayList<String>();
		sErrorScreenshot= new ArrayList<String>();
		sWebPagePath=new ArrayList<String>();   //Mantis 0001221
	}
	/*
	--------------------------------------- START : setTestCaseName----------------------------------------------
	Function Name: setTestCaseName
	Objective: A generic function to write Test case name
	Date Created: 
	Input:
		sScenarioName = Name of the Scenario 
		sTestCaseName = Name of the test case
		dStartTimestamp = Start time of a test case
	Output:	
	Revision History:
	Modified on:		
	Comments: Set scenario name , test case name and timestamp (start time) to the required variables.
	 ---------------------------------------------------------------------------------------------------------
	 */


	public void setTestCaseName(String sScenarioName,String sTestCaseName,Date dStartTimestamp)
	{
		this.sTestScenario=sScenarioName;

		this.sTestCaseName =sTestCaseName;
		this.dStartTimestamp=dStartTimestamp;

	}
	/*
	--------------------------------------- START : clearLists----------------------------------------------
	Function Name: clearLists
	Objective: A generic function to clear the data list
	Date Created: 
	Input:
	Output:	
	Revision History:
	Modified on:		
	Comments: Clear the previous data stored to the array list (e.g.  sStepNo , sStepDescription etc.)
	 ---------------------------------------------------------------------------------------------------------
	 */

	public void clearLists()
	{
		sStepTestCaseIdentifier.clear();
		sStepNo.clear();
		sStepExpectedData.clear();
		sStepActualData.clear();
		sStepStatus.clear();
		sStepDescription.clear();
		sStepExecutionDate.clear();
		sExectutionDetails.clear();
		sErrorScreenshot.clear();
		sWebPagePath.clear();    //Mantis 0001221
		sStatus="Pass";
		sTestCaseErrorScreenshot="";
	}
	/*
	--------------------------------------- START : writeFunctionalLog----------------------------------------------
	Function Name: writeFunctionalLog
	Objective: A generic function to write functionality wise result
	Date Created: 
	Input: 
	Output:	
	Revision History:
	Modified on:		
	Comments: if (testcasename is not null) create a file writer , and write the result of functionality step by step else testcasename is null. 
	 ---------------------------------------------------------------------------------------------------------
	 */


	public void writeFunctionalLog()
	{
		BufferedWriter out=null; //Mantis: 0000385
		if(sTestCaseName != null)
		{

			try 
			{
				String sTestCaseFileName,sComments;
				sComments="";
				//FileWriter oFileWriter = null;
				//oFileWriter = new FileWriter(sResultFileName,true);
				out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sResultFileName,true), "UTF8")); //Mantis: 0000385
				sTestCaseFileName=sTestCaseName.substring(sTestCaseName.lastIndexOf("/")+1); //Mantis 0000796
				sTestScenario=sTestScenario.replaceAll("\n"," ");
				sTestExecutionTime=LibraryClass.getExecutionTime(this.dStartTimestamp);
				if(sStatus.equalsIgnoreCase("Skipped"))
				{
					System.out.println();
					sComments="Skipped due to failure in previous case";
					out.append(sTestScenario+"~"+sTestCaseFileName+"~~"+sStatus+"~"+"\""+sComments+"\""+"~~~~"+new SimpleDateFormat("MM_dd_yyyy").format(new Date())+"\n\n");  //Mantis 0000959
					//out.append(sTestScenario+","+sTestCaseFileName+",,"+sStatus+","+"\""+sComments+"\""+",,,,"+new SimpleDateFormat("MM_dd_yyyy").format(new Date())+"\n\n");
					out.append("\n");
					out.flush();

					return;
				}
				//out.append(sTestScenario+","+sTestCaseFileName+ ",,"+sStatus+",,,,,"+new SimpleDateFormat("MM_dd_yyyy").format(new Date())+","+sTestExecutionTime+","+","+"\n\n");
				out.append(sTestScenario+"~"+sTestCaseFileName+ "~~"+sStatus+"~~~~~"+new SimpleDateFormat("MM_dd_yyyy").format(new Date())+"~"+sTestExecutionTime+"~"+"~"+"\n\n"); //Mantis 0000959
				//System.out.println(sTestProcess + "," + sTestScenario + "," + sTestCaseFileName + ",,,," + sStatus + ",," + new SimpleDateFormat("dd_MM_yyyy").format(new Date()) + "," + sTestExecutionTime + "\n\n");
				for(int i=0;i<sStepNo.size();i++)
				{
					//out.append(","+sStepTestCaseIdentifier.get(i)+","+sStepNo.get(i)+","+sStepStatus.get(i)+","+"\""+sStepDescription.get(i)+"\""+","+"\""+sExectutionDetails.get(i)+"\""+","+"\""+sStepExpectedData.get(i)+"\""+","+"\""+sStepActualData.get(i)+"\""+","+new SimpleDateFormat("MM_dd_yyyy").format(new Date())+",,"+.get(i)+"\n");
					out.append("~"+sStepTestCaseIdentifier.get(i)+"~"+sStepNo.get(i)+"~"+sStepStatus.get(i)+"~"+sStepDescription.get(i)+"~"+sExectutionDetails.get(i)+"~"+sStepExpectedData.get(i)+"~"+sStepActualData.get(i)+"~"+new SimpleDateFormat("MM_dd_yyyy").format(new Date())+"~~"+sErrorScreenshot.get(i)+"~"+sWebPagePath.get(i)+"\n"); //Mantis 0000959,0001221
				}
				out.append("\n");
				out.flush();

			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					out.close(); //Mantis: 0000385
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
			System.out.println("Tescase Name = Null  :" );
		clearLists();
	}
	/*
	--------------------------------------- START : setTestStepDetails----------------------------------------------
	Function Name: setTestStepDetails
	Objective: A generic function to log technical details of each execution step
	Date Created: 
	Input:
		sTestCase = Current test case name
		iStepNo = Current execution step
		sExpectedData = Expected Data from the step
		sActualData = Actual Data from the step	
		sStatus = Current Status of the step
		sDescription = Current Test Case Description
		sExecutionDetail = Current Execution Details
		sScreenShotFileName = ScreenShot name
	Output:	
	Revision History:
	Modified on:		
	Comments: set the test step details to the array list 
	 ---------------------------------------------------------------------------------------------------------
	 */

	public void setTestStepDetails(String sTestCase,String iStepNo,String sExpectedData,String sActualData,String sStatus,String sDescription,String sExecutionDetail,String sScreenShotFileName,String sWebPagePath)   //Mantis 0001221
	{
		if(sTestCase!=null)
			sTestCase=sTestCase.replaceAll("[\n\r]"," ");

		if(sExpectedData!=null)
			sExpectedData=sExpectedData.replaceAll("[\n\r]"," ");

		if(sActualData!=null)
			sActualData=sActualData.replaceAll("[\n\r]"," ");

		//System.out.println("Description Before..."+sDescription);
		if(sDescription!=null)
			sDescription=sDescription.replaceAll("[\n\r~]"," ");  //Mantis 0000959
		//System.out.println("Description After..."+sDescription);

		//System.out.println("Detailed Description Before..."+sExecutionDetail);
		if(sExecutionDetail!=null)
			sExecutionDetail=sExecutionDetail.replaceAll("[\n\r~]"," ");  //Mantis 0000959
		//System.out.println("Detailed Description After..."+sExecutionDetail);

		this.sStepTestCaseIdentifier.add(sTestCase);

		this.sStepNo.add((iStepNo));
		this.sStepExpectedData.add(sExpectedData);
		this.sStepActualData.add(sActualData);
		this.sStepStatus.add(sStatus);
		this.sStepDescription.add(sDescription);
		this.sExectutionDetails.add(sExecutionDetail);
		if(!sScreenShotFileName.equalsIgnoreCase(""))
			this.sTestCaseErrorScreenshot = sScreenShotFileName;
		this.sErrorScreenshot.add(sScreenShotFileName);
		this.sWebPagePath.add(sWebPagePath);   //Mantis 0001221
		if(sStatus.trim().equalsIgnoreCase("fail"))
			this.sStatus = "Fail";
		if(sStatus.trim().equalsIgnoreCase("Skipped"))
			this.sStatus = "Skipped";
	}

	/*
	--------------------------------------- START : finalize----------------------------------------------
	Function Name: finalize
	Objective: A function to call Functional log
	Date Created: 
	Input:
	Output:	
	Revision History:
	Modified on:		
	Comments:
	 ---------------------------------------------------------------------------------------------------------
	 */


	public void finalize()
	{
		this.writeFunctionalLog();
	}
}
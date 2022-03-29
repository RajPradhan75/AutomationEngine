package com.nexops.auto.remediate.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CSVtoHTML 
{
	public static List<String> ImageFilePath=new ArrayList<String>();  //Mantis 0001311
	public static String slideShowFileName; //Mantis 0001311
	/**
	 * @param args
	 * @throws ParseException 
	 */
	/*public static void main(String[] args) throws Exception 
	{
		CSVtoHTML objTemp = new CSVtoHTML();
		//System.out.println(args[0]);
		generateHTML(args[0],args[1],args[2],args[3]);  //Mantis 0000953
	}*/

	public static void generateHTML(String csvFile,String sStart_Time, String sEnd_Time, String sBrowser,String projectType) throws Exception  //Mantis 0000953,0001449
	{
		System.out.println(csvFile);
		String sHTMLFileName= (csvFile.substring(0, csvFile.lastIndexOf("."))) + ".html";
		slideShowFileName=(csvFile.substring(0, csvFile.lastIndexOf("."))) + "_slideshow.html";  //Mantis 0001311
		File HTMLfile =new File(sHTMLFileName);
		BufferedReader CSVBufferedReader = null;
		FileWriter fileWritter;
		BufferedWriter HTMLWriter=null;
		String line = "";
		String sTestCaseName,sExecutionTime = "00:00:00",sStatus,sHTMLStatus,sStepID,sScreenShot,sWebPage="";  //Mantis 0001221,0001449
		String sExecTime = "00:00:00";
		String sScenarioName="";
		sScreenShot="";
		String cvsSplitBy = "~(?=([^\"]*\"[^\"]*\")*[^\"]*$)"; //Mantis 0000959
		int iTestCaseNo=0;
		int iScenarioNo,iTestStepNo,iPassCount=0,iFailCount=0;
		iScenarioNo=iTestStepNo=0;
		int iTestCasePass = 0,iTestCaseFail = 0,iTestCaseSkipped = 0;
		int iTestScenPass,iTestScenFail;
		int iArrayLength,iLoopVariable;
		iTestScenPass=iTestScenFail=0;
		String dExecutionDate="";
		String date="";
		//Float fExecutionTime =(float) 0;
		Long sumtime=0L;
		try
		{
			System.out.println("CSV file name:"+csvFile);
			HTMLfile.createNewFile();
			fileWritter = new FileWriter(HTMLfile);
			HTMLWriter = new BufferedWriter(fileWritter);
			CSVBufferedReader = new BufferedReader(new FileReader(csvFile));  
			String sStartData="<html>\n<head>\n<link rel=\"stylesheet\" href=\"../resources/TCStyle1.css\" type=\"text/css\"/>\n<script type=\"text/javascript\">\nfunction ExpandCollapse(img, stepname,tablename)\n{\n\nvar ele, val,intStep,floorIntStep,intScen,floorScen;\nele = document.getElementById(tablename);\nvar i, rowCount, rowData;\nrowCount = ele.rows.length;\nval = img.src.indexOf('plus.gif');\nintScen=parseInt(stepname)\nif(val > -1)\n{\nimg.src = '../resources/minus.gif';\nimg.alt = 'Click to collapse';\n\nrowData = 'block';\n}\nelse{\nimg.src = '../resources/plus.gif';\nimg.alt = 'Click to expand';\nrowData = 'none';\n}\nfor(i = 0; i < rowCount; i++)\n{\n\n\nintStep=Math.floor(ele.rows[i].id)\nif(intScen==intStep)\nele.rows[i].style.display = rowData;\n}\n}\n\n\n</script>\n</head>\n<html><body bgcolor='WHITE'><hr class=\"divline\"><table class=\"reportheader\" width=900px><tr><td height=120px><img width=250px height=60px src = \"../resources/TopRight_logo.gif\" ></img></tr></table><hr class=\"divline\">";//Mantis 0000928
			HTMLWriter.write(sStartData);
			CSVBufferedReader.readLine();
			System.out.println("Writing Report File");

			// Reading Result file for Test Summary
			while ((line = CSVBufferedReader.readLine()) != null) 
			{
				String[] arrDummyCurrentline = line.split(cvsSplitBy, -1);
				iArrayLength = arrDummyCurrentline.length;
				for (iLoopVariable = 0; iLoopVariable < iArrayLength; iLoopVariable++)
				{
					if (arrDummyCurrentline[iLoopVariable] != null && !arrDummyCurrentline[iLoopVariable].isEmpty()) 
					{
						if (arrDummyCurrentline[iLoopVariable].charAt(0) == '"') 
						{
							StringBuilder sbCurrentline = new StringBuilder(arrDummyCurrentline[iLoopVariable]);
							sbCurrentline.deleteCharAt(0);
							arrDummyCurrentline[iLoopVariable] = sbCurrentline.toString();
						}
						int iLastIndex = arrDummyCurrentline[iLoopVariable].length();
						if (arrDummyCurrentline[iLoopVariable].charAt(iLastIndex - 1) == '"') 
						{
							StringBuilder sbCurrentline = new StringBuilder(
									arrDummyCurrentline[iLoopVariable]);
							sbCurrentline.deleteCharAt(iLastIndex - 1);
							arrDummyCurrentline[iLoopVariable] = sbCurrentline
									.toString();
						}
					}
				}

				String[] arrCurrentLine = arrDummyCurrentline;
				if (arrCurrentLine.length != 0 && arrCurrentLine[0].length() != 0 && arrCurrentLine[1].length() != 0) 
				{
					if ((arrCurrentLine.length - 1) >= 9) 
					{
						dExecutionDate = arrCurrentLine[8];
						System.out.println("Status:"+arrCurrentLine[3]);
						date=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
						System.out.println("Date:" + date);					
						System.out.println("Exe time: "+arrCurrentLine[9]);
						SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
						timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
						Date date1 = timeFormat.parse(arrCurrentLine[9]);
						System.out.println("Date 1:" + date1);
						Date date2 = timeFormat.parse(sExecTime);
						System.out.println("Date 2:" + date2);
						long sum = date1.getTime() + date2.getTime();
						sExecTime = timeFormat.format(new Date(sum));
						System.out.println("Execution Time:" + sExecTime);
					}
					if (arrCurrentLine[0].equalsIgnoreCase(sScenarioName))
					{
						iTestCaseNo++;
						System.out.println("Inside If Scenario Name:"+ sScenarioName);
						if (arrCurrentLine[3].equalsIgnoreCase("Pass"))
						{
							iTestCasePass++;
							iPassCount++;
						}
						else 
						{
							iTestCaseFail++;
							iFailCount++;
						}
					} 
					else 
					{
						System.out.println("Inside Else Scenario Name:"+ sScenarioName);
						iScenarioNo++;
						iTestCaseNo++;
						if (iPassCount == 0 && iFailCount == 0)
							;
						else if (iFailCount > 0)
							iTestScenFail++;
						else
							iTestScenPass++;
						iPassCount = 0;
						iFailCount = 0;

						if(arrCurrentLine[3].equalsIgnoreCase("Pass"))
						{
							iTestCasePass++;
							iPassCount++;
						}
						else 
						{
							iTestCaseFail++;
							iFailCount++;
						}
						sScenarioName = arrCurrentLine[0];
						System.out.println("Scenario Name Asigned:"
								+ sScenarioName+"\n\n\n\n");
					}
				}		
			}
			if(iFailCount>0)
				iTestScenFail++;
			else
				iTestScenPass++;
			String sTestScenarios="<br><br><table border=\"1px solid black\" style= \"width: 20%\" class=\"teststeps\" >\n<tbody>\n<tr>\n<td bgcolor=\"#197C7C\"><span style='font-weight:bold;'>Execution Summary Report</span></td>\n</tr>\n</tbody>\n</table>\n<table border=\"1px solid black\" class=\"teststeps\" style=\"width: 30%\">\n<tbody>\n<tr>\n<td width=\"120\" class=\"tsgen\"><span style='font-weight:bold;'>Total Scenarios</span></td>\n<td width=\"100\" class=\"tsgen\" align=\"center\"><span style='font-weight:bold;'>"+iScenarioNo+"</span></td>\n</tr>\n<tr>\n<td width=\"120\" align=\"right\" class=\"tsgen\">Pass Scenarios</td>\n<td width=\"100\" class=\"tsgen\" style=\"color:green\" align=\"center\">"+iTestScenPass+"</td>\n</tr>\n<tr>\n<td width=\"120\" align=\"right\" class=\"tsgen\">Fail Scenarios</td>\n<td width=\"100\" class=\"tsgen\" style=\"color:red\" align=\"center\">"+iTestScenFail+"</td>\n</tr>";
			HTMLWriter.write(sTestScenarios);

			String sTestCases="\n<tr>\n<td width=\"120\" font-weight=\"bold\" class=\"tsgen\"><span style='font-weight:bold;'>Total Test Cases</span></td>\n<td width=\"100\" class=\"tsgen\" align=\"center\"><span style='font-weight:bold;'>"+iTestCaseNo+"</span></td>\n</tr>\n<tr>\n<td width=\"120\" align=\"right\" class=\"tsgen\">Pass Test Cases</td>\n<td width=\"100\" class=\"tsgen\" style=\"color:green\" align=\"center\">"+iTestCasePass+"</td>\n</tr>\n<tr>\n<td width=\"120\" align=\"right\" class=\"tsgen\">Fail Test Cases</td>\n<td width=\"100\" class=\"tsgen\" style=\"color:red\" align=\"center\">"+iTestCaseFail+"</td>\n</tr>\n<tr>\n<td width=\"120\" align=\"right\" class=\"tsgen\">Skipped Test Cases</td>\n<td width=\"100\" class=\"tsgen\" style=\"color:orange\" align=\"center\">"+iTestCaseSkipped+"</td>\n</tr>";
			HTMLWriter.write(sTestCases);
			String browserheading="Browser"; //Mantis 0001710
			if(projectType.equalsIgnoreCase("mobile")) {
				browserheading="Mobile Device";
			}
			HTMLWriter.write("\n<tr>\n<td width=\"100\" class=\"tsgen\"><span style='font-weight:bold;'>Execution Date</span></td>\n<td width=\"100\" class=\"tsgen\" align=\"center\">"+date+"</td>\n</tr>\n<tr>\n<td width=\"200\" class=\"tsgen\"><span style='font-weight:bold;'>Execution Start Time</span></td>\n<td width=\"100\" class=\"tsgen\" align=\"center\">"+sStart_Time+"</td>\n</tr>\n<tr>\n<td width=\"200\" class=\"tsgen\"><span style='font-weight:bold;'>Execution End Time</span></td>\n<td width=\"100\" class=\"tsgen\" align=\"center\">"+sEnd_Time+"</td>\n</tr>\n<tr>\n<td width=\"200\" class=\"tsgen\"><span style='font-weight:bold;'>Total Execution Time</span></td>\n<td width=\"100\" class=\"tsgen\" align=\"center\"><b>"+sExecTime+"</b></td>\n</tr>\n<tr>\n<td width=\"200\" class=\"tsgen\"><span style='font-weight:bold;'>"+browserheading+"</span></td>\n<td width=\"100\" class=\"tsgen\" align=\"center\"><b>"+sBrowser+"</b></td>\n</tr>\n</tbody>\n</table><BR>"); //Mantis 0000953 

			CSVBufferedReader.close();
			CSVBufferedReader = new BufferedReader(new FileReader(csvFile));
			CSVBufferedReader.readLine();
			sScenarioName="";
			//Reading Result file for detailed results
			while ((line = CSVBufferedReader.readLine()) != null)
			{
				// use comma as separator

				String [] arrDummyCurrentline=line.split(cvsSplitBy,-1);
				iArrayLength=arrDummyCurrentline.length;
				for(iLoopVariable=0;iLoopVariable<iArrayLength;iLoopVariable++)
				{			
					if(arrDummyCurrentline[iLoopVariable]!=null && !arrDummyCurrentline[iLoopVariable].isEmpty())
					{
						if(arrDummyCurrentline[iLoopVariable].charAt(0)=='"')
						{
							StringBuilder sbCurrentline=new StringBuilder(arrDummyCurrentline[iLoopVariable]);
							sbCurrentline.deleteCharAt(0);
							arrDummyCurrentline[iLoopVariable]=sbCurrentline.toString();
						}
						int iLastIndex=arrDummyCurrentline[iLoopVariable].length();
						if(arrDummyCurrentline[iLoopVariable].charAt(iLastIndex-1)=='"')
						{
							StringBuilder sbCurrentline=new StringBuilder(arrDummyCurrentline[iLoopVariable]);
							sbCurrentline.deleteCharAt(iLastIndex-1);
							arrDummyCurrentline[iLoopVariable]=sbCurrentline.toString();
						}
					}	
				}

				String[] arrCurrentLine = arrDummyCurrentline;
				if(arrCurrentLine.length >1)
				{
					//check if new scenario Starts

					if(arrCurrentLine[0].length() != 0)
					{
						if(!sScenarioName.equalsIgnoreCase(arrCurrentLine[0]))
						{
							iScenarioNo++;
							iTestStepNo=0;
							iTestCaseNo=1;
							if(sScenarioName!="")
							{
								//close Previous Table
								HTMLWriter.write("</table><BR><BR><hr class=\"divline\"/><BR>");
							}
							sScenarioName=arrCurrentLine[0];
							//Create Table Heading with Scenario name

							HTMLWriter.write("<hr class=\"divline\"/><BR>\n\n<table class=\"subheader\" width=900px >\n\n<tr><td width=400px class=\"subheader\">Test Scenario name : " +sScenarioName + "</td></tr></table> <hr class=\"divline\"> <BR><BR>");
							//Create new Table	
							if(projectType.equalsIgnoreCase("mobile")) //Mantis 0001449
								HTMLWriter.write("<BR><table style= \"width: 100%; white-space:normal\" class=\"teststeps\" id=\"TSResults"+iScenarioNo+"\"><tr><td class=\"tsheader\" width=5%>Step #</td><td class=\"tsheader\" width=25%>Step Description</td><td class=\"tsheader\" width=18%>Expected Result</td><td class=\"tsheader\" width=18%>Actual Result</td><td class=\"tsheader\" width=8%>Status</td><td class=\"tsheader\" width=9%>Execution Time</td><td class=\"tsheader\" width=8%>Screen Shot</td></tr>");   //Mantis 0001449
							else
								HTMLWriter.write("<BR><table style= \"width: 100%; white-space:normal\" class=\"teststeps\" id=\"TSResults"+iScenarioNo+"\"><tr><td class=\"tsheader\" width=5%>Step #</td><td class=\"tsheader\" width=25%>Step Description</td><td class=\"tsheader\" width=18%>Expected Result</td><td class=\"tsheader\" width=18%>Actual Result</td><td class=\"tsheader\" width=8%>Status</td><td class=\"tsheader\" width=9%>Execution Time</td><td class=\"tsheader\" width=8%>Screen Shot</td><td class=\"tsheader\" width=8%>Web Page</td></tr>");   //Mantis 0001221
						}
						else
						{
							iTestCaseNo++;
						}
						sTestCaseName=arrCurrentLine[1];
						if((arrCurrentLine.length-1)>=9)
							sExecutionTime=arrCurrentLine[9];
						else
							sExecutionTime="0:0:0";
						sStatus=arrCurrentLine[3];
						if(sStatus.equalsIgnoreCase("pass"))
						{
							sHTMLStatus="<td class=\"tsgen\" width=8%><font size = 2 color = green><b>PASS</b></td>";
						}
						else
						{
							sHTMLStatus="<td class=\"tsgen\" width=8%><font size = 2 color = red><b>FAIL</b></td>";
						}
						if((arrCurrentLine.length-1)>=10 && !arrCurrentLine[10].isEmpty())
						{
							int index=-1; //Mantis 0001311
							arrCurrentLine[10]=arrCurrentLine[10].substring(arrCurrentLine[10].lastIndexOf("Screenshots")); //Manoj xxx Changed screenshot path to relative path.
							if(arrCurrentLine[10]!=null) //Mantis 0001311
							{
								ImageFilePath.add("./"+arrCurrentLine[10]);
								index=ImageFilePath.size()-1;
							}

							sScreenShot="<td class=\"tsgen\" width=8%><a target=\"_blank\" onClick=\"setIndex("+index+");\" href=\"./"+slideShowFileName.substring(slideShowFileName.lastIndexOf("/")+1)+"\" class=\"anibutton\"><img class=\"screen\" src =\"..\\resources\\screenshot.gif\"></a></td>"; //Mantis 0000928 //Manoj xxx Changed screenshot path to relative path.
							//sScreenShot="<td class=\"tsgen\" width=8%><a target=\"_blank\" class=\"anibutton\" href=\"" + arrCurrentLine[10] + "\"><img class=\"screen\" src =\"..\\resources\\screenshot.gif\"></a></td></tr>"; //Mantis 0000928
						}
						else
						{
							sScreenShot="<td class=\"tsgen\" width=8%></td>";
						}

						if(projectType.equalsIgnoreCase("mobile")) //Mantis 0001449
						{
							HTMLWriter.write("<tr bgcolor=\"#AFEEEE\"><td class=\"tsgen\" width=5%><b><font color=\"black\">"+iTestCaseNo+"</b></td><td class=\"tsgen\" width=30%><b><font color=\"black\">"+sTestCaseName+"</b></td><td class=\"tsgen\" width=20%></td><td class=\"tsgen\" width=20%></td>"+sHTMLStatus+"<td class=\"tsgen\" width=9%><b><font color=\"black\">"+sExecutionTime+"</b></td>"+sScreenShot);
						}
						else 
						{	
							if((arrCurrentLine.length-1)>=11 && !arrCurrentLine[11].isEmpty() && !(arrCurrentLine[11].equals("null")))   //Mantis 0001221
							{
								arrCurrentLine[11]=arrCurrentLine[11].substring(arrCurrentLine[11].lastIndexOf("\\")); 
								sWebPage="<td class=\"tsgen\" width=5%><a target=\"_blank\" class=\"anibutton\" href=\"./" + arrCurrentLine[11] + "\"><img class=\"screen\" src =\"..\\resources\\screenshot.gif\"></a></td></tr>"; //Mantis 0000928 //Manoj xxx Changed screenshot path to relative path.
							}
							else
							{
								sWebPage="<td class=\"tsgen\" width=5%></td></tr>";
							}
							HTMLWriter.write("<tr bgcolor=\"#AFEEEE\"><td class=\"tsgen\" width=5%><b><font color=\"black\">"+iTestCaseNo+"</b></td><td class=\"tsgen\" width=30%><b><font color=\"black\">"+sTestCaseName+"</b></td><td class=\"tsgen\" width=20%></td><td class=\"tsgen\" width=20%></td>"+sHTMLStatus+"<td class=\"tsgen\" width=9%><b><font color=\"black\">"+sExecutionTime+"</b></td>"+sScreenShot+sWebPage);   //Mantis 0001221
						}//Create A new Tree

					}
					else
					{
						if(arrCurrentLine[1].length()!=0)
						{
							//Add Step to the tree
							iTestStepNo++;
							sStatus=arrCurrentLine[3];

							if((arrCurrentLine[6].length()!=0 && arrCurrentLine[7].length()!=0)||arrCurrentLine[4].length()!=0)
							{
								if((arrCurrentLine.length-1)>=10 && !arrCurrentLine[10].isEmpty())
								{
									int index=-1;  //Mantis 0001311
									arrCurrentLine[10]=arrCurrentLine[10].substring(arrCurrentLine[10].lastIndexOf("Screenshots")); //Manoj xxx Changed screenshot path to relative path.
									if(arrCurrentLine[10] != null) //Mantis 0001311
									{
										ImageFilePath.add("./"+arrCurrentLine[10]);
										index=ImageFilePath.size()-1;
									}
									sScreenShot="<td class=\"tsgen\" width=9%> </td><td class=\"tsgen\" width=8%><a target=\"_blank\" onClick=\"setIndex("+index+")\" href=\"./"+slideShowFileName.substring(slideShowFileName.lastIndexOf("/")+1)+"\" class=\"anibutton\"><img class=\"screen\" src =\"..\\resources\\screenshot.gif\"></a></td>"; //Mantis 0000928 //Manoj xxx Changed screenshot path to relative path.
									//sScreenShot="<td class=\"tsgen\" width=9%> </td><td class=\"tsgen\" width=8%><a target=\"_blank\" class=\"anibutton\" href=\"" + arrCurrentLine[10] + "\"><img class=\"screen\" src =\"..\\resources\\screenshot.gif\"></a></td></tr>"; //Mantis 0000928
								}
								else
								{
									if(!projectType.equalsIgnoreCase("mobile"))  //Mantis 0001449
										sScreenShot="<td class=\"tsgen\" width=9%> </td><td class=\"tsgen\" width=8%></td>";
									else
										sScreenShot="<td class=\"tsgen\" width=9%> </td><td class=\"tsgen\" width=8%></td></tr>";

								}
								if(!projectType.equalsIgnoreCase("mobile")) 
								{
									if((arrCurrentLine.length-1)>=11 && !arrCurrentLine[11].isEmpty() && !(arrCurrentLine[11].equals("null"))) //Mantis 0001221
									{
										arrCurrentLine[11]=arrCurrentLine[11].substring(arrCurrentLine[11].lastIndexOf("\\")); 
										sWebPage="<td class=\"tsgen\" width=5%><a target=\"_blank\" class=\"anibutton\" href=\"./" + arrCurrentLine[11] + "\"><img class=\"screen\" src =\"..\\resources\\screenshot.gif\"></a></td></tr>"; //Mantis 0000928 //Manoj xxx Changed screenshot path to relative path.
										//sScreenShot="<td class=\"tsgen\" width=8%><a target=\"_blank\" class=\"anibutton\" href=\"" + arrCurrentLine[10] + "\"><img class=\"screen\" src =\"..\\resources\\screenshot.gif\"></a></td></tr>"; //Mantis 0000928 
									}
									else
									{
										sWebPage="<td class=\"tsgen\" width=5%></td></tr>";
									}
								}


								if(sStatus.equalsIgnoreCase("pass"))
								{
									sHTMLStatus="<td class=\"tsgen\" width=8%><font size = 2 color = green><b>PASS</b></td>";
								}
								else
								{
									sHTMLStatus="<td class=\"tsgen\" width=8%><font size = 2 color = red><b>FAIL</b></td>";
								}
								sStepID=Integer.toString(iTestCaseNo) + "." + Integer.toString(iTestStepNo);
								if(!projectType.equalsIgnoreCase("mobile")) //Mantis 0001449
									HTMLWriter.write("<tr name=\""+arrCurrentLine[1]+"id=\""+sStepID+"\"><td class=\"tsgen\" width=5%>"+sStepID+"</td><td class=\"tsgen\" width=30%>"+arrCurrentLine[5]+"&nbsp;</td><td class=\"tsgen\" width=20%>"+arrCurrentLine[6]+"</td><td class=\"tsgen\" width=20%>"+arrCurrentLine[7]+"</td>"+sHTMLStatus+sScreenShot+sWebPage);  
								else
									HTMLWriter.write("<tr name=\""+arrCurrentLine[1]+"id=\""+sStepID+"\"><td class=\"tsgen\" width=5%>"+sStepID+"</td><td class=\"tsgen\" width=30%>"+arrCurrentLine[5]+"&nbsp;</td><td class=\"tsgen\" width=20%>"+arrCurrentLine[6]+"</td><td class=\"tsgen\" width=20%>"+arrCurrentLine[7]+"</td>"+sHTMLStatus+sScreenShot);  //Mantis 0001221

							}
						}
					}
				}
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			CreateImageSlideshow(); //Mantis 0001311

			if (CSVBufferedReader != null) 
			{
				try 
				{

					String htmlclose="</table></body>";
					//Mantis 0001311
					htmlclose+="<script>";
					htmlclose+="function setIndex(n)";
					htmlclose+="{  if(n <0)";
					htmlclose+=" {localStorage[\"index\"] = 0;}";
					htmlclose+=" else {  localStorage[\"index\"] = n; }";
					htmlclose+="}";
					htmlclose+="</script></html>";
					HTMLWriter.write(htmlclose);
					//Mantis 0001311
					HTMLWriter.flush();
					HTMLWriter.close();
					CSVBufferedReader.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	public static void CreateImageSlideshow() throws IOException {  //Mantis 0001311
		FileWriter fileWriter = new FileWriter(slideShowFileName);
		BufferedWriter HTMLWriter = new BufferedWriter(fileWriter);
		String html="<html><head><title>Screenshot Slideshow</title>";
		html+="<link rel=\"stylesheet\" href=\"../Resources/css/bootstrap.min.css\">";
		html+="<link rel=\"stylesheet\" href=\"../Resources/slideShow.css\">";
		html+="<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">";
		html +="</head>";
		html += "<body>";
		html+="<div class=\"container\">";
		for(int i=0;i<ImageFilePath.size();i++)
		{
			String imageName=ImageFilePath.get(i);
			imageName=imageName.substring(imageName.lastIndexOf("/")+1);
			html+="<div class=\"mySlides\">";
			int j=i+1;
			/*html+="<div class=\"numbertext\">"+j+"/"+ImageFilePath.size()+"</div>";*/
			html+="<img src=\""+ImageFilePath.get(i) +"\"style=\"width:100%\">";
			html+="<div class=\"text\" name="+imageName+"></div>";
			html+="</div>";
		}
		html+="<a class=\"prev\" onclick=\"plusSlides(-1)\">&#10094;</a>";
		html+="<a class=\"next\" onclick=\"plusSlides(1)\">&#10095;</a>";
		html+="<div class=\"caption-container\"><div class=\"row\"><div class=\"col-md-10\">";
		html+="<p id=\"caption\"></p></div>";
		html+="<div class=\"col-md-2\"><div id=\"number\" style=\"float: right;\"></div></div>";	
		html+= "</div></div>";
		html+= "</div>";
		html += "</body>";
		html+="<script src=\"../Resources/jquery.min.js\"></script>";
		html+="<script src=\"../Resources/bootstrap.min.js\"></script>";
		html+="<script src=\"../Resources/slideShow.js\"></script>";
		html+="</html>";
		HTMLWriter.write(html);
		HTMLWriter.flush();
		fileWriter.close();
		HTMLWriter.close();
	}
}  
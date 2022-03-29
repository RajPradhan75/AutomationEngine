package com.nexops.auto.remediate;

import java.io.IOException;

import com.nexops.auto.remediate.util.ExcelConnection;

/**
 * Hello world!
 *
 */
public class TestClass 
{
	public static void main(String[] args) throws Exception 
	{	
		//DateFormat dfTimestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		//String sTimestamp = dfTimestamp.format(new Date());
		//FileOutputStream fos = FileUtils.openOutputStream(new File(System.getProperty("user.dir")+"/logs/Qweb_Automation_logs/Qweb_Automation_logs_"+sTimestamp+".txt"));
		//PrintStream out = new PrintStream(fos);
		//System.setOut(out);			
		
		ExcelConnection.killChromePIDs();		//Mantis: 0001573
		//Runtime.getRuntime().exec("taskkill /f /IM IEDriverserver.exe"); //Mantis 0001756
		//Runtime.getRuntime().exec("taskkill /f /IM IExplore.exe"); //Mantis Mantis 0001756
		Runtime.getRuntime().exec("taskkill /f /IM ChromeDriver.exe");
		
		KeywordDrivenFramework key;
		try
		{
			key = new KeywordDrivenFramework(args[0]);

			if(args.length>0)
			{
				// Mantis 0000703
				if(args.length>1)
				{
					if(args[1].trim().equalsIgnoreCase("Appium"))
					{
						key.appiumProcess="Appium";
					}
				}				
					key.executeDriver(args[0]);
			}
			else
				key.executeDriver(null);			
			System.out.println("Finish");				
		} 
		catch (IOException e) 
		{
			System.out.println("Error in Configuration File/Configuration File does not exist");
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally
		{			
			System.out.println("Execution Completed");
			//out.close();
			//fos.close();
			System.exit(0);// Mantis 0000754
		}
	}
}

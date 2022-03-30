package com.nexops.auto.remediate.webautomation;

public class TestUnit {


	public void getDriverParam(String str) throws Exception {

		if(System.getProperty("os.name").toLowerCase().contains("windows"))
			Runtime.getRuntime().exec("taskkill /f /IM ChromeDriver.exe");

		//ExcelConnection.killChromePIDs();
		KeywordDrivenFramework keywordDriven = new KeywordDrivenFramework(str);

		keywordDriven.executeDriver(str);

	}
}

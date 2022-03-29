package com.nexops.auto.remediate.constants;

public enum DriverColumnHeader {

	SR_NO, TEST_SCENARIO, EXCEL_PATH, TEST_CASE, RUN_FLAG,MUST_EXECUTE;
	public String toString() 
	{
		switch (this) 
		{
		case SR_NO:
			return "Sr_No";
		case TEST_SCENARIO:
			return "Test_Scenario";
		case EXCEL_PATH:
			return "Excel_Path";
		case TEST_CASE:
			return "Test_Case";
		case RUN_FLAG:
			return "Run_Flag";
		case MUST_EXECUTE: 			//Mantis 0001887
			return "Must_Execute";
		default:
			return null;
		}
	}
}

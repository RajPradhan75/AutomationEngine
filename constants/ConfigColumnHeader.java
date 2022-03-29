package com.nexops.auto.remediate.constants;

public enum ConfigColumnHeader {

	PAGE_WAIT_TIME, FRAME_WAIT_TIME, AUTO_CLOSE, LOAD_TIMEOUT,WINDOW_TIMEOUT, ELEMENT_WAIT,
	FILE_WAIT,NTLM,USERNAME,PASSWORD,SCREENSHOT,WEBPAGE,DOWNLOAD_FOLDER;  //792 //0000854 //Mantis 0000879 0001045 0001079 0001131 0001249,0001816
	public String toString()
	{
		switch (this)
		{
		case PAGE_WAIT_TIME:
			return "Page_Wait_Time";
		case FRAME_WAIT_TIME:
			return "Frame_Wait_Time";
		case AUTO_CLOSE:
			return "Auto_Close";
		case LOAD_TIMEOUT:
			return "Load_Timeout";
		case WINDOW_TIMEOUT://Mantis 0000854
			return "Window_Timeout";
		case ELEMENT_WAIT: //Mantis 0000879
			return "Element_Wait";
		case FILE_WAIT:		//Mantis 0001079
			return "File_Wait";
		case NTLM:          //Mantis 0001131
			return "NTLM";
		case USERNAME:       //Mantis 0001131
			return "Username";
		case PASSWORD:       //Mantis 0001131
			return "Password";
		case SCREENSHOT:	//Mantis 0001249
			return "Screenshot";
		case WEBPAGE:	//Mantis 0001249
			return "webpage";	
		case DOWNLOAD_FOLDER: 	//Mantis 0001816
			return "Download_Folder";
		default:
			return null;
		}
	}
}

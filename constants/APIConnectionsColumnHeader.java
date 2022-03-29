package com.nexops.auto.remediate.constants;

public enum APIConnectionsColumnHeader {

	CONNECTIONNAME,BASEURL,USERNAME,PASSWORD;
	public String toString() 
	{
		switch (this) 
		{
		case CONNECTIONNAME:
			return "ConnectionName";
		case BASEURL:
			return "BaseURL";
		case USERNAME:
			return "Username";
		case PASSWORD:
			return "Password";		
		default:
			return null;
		}
	}
}

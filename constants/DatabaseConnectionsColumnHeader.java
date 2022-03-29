package com.nexops.auto.remediate.constants;

public enum DatabaseConnectionsColumnHeader {

	CONNECTIONNAME,DATABASEDRIVER,CONNECTIONSTRING,USERNAME,PASSWORD;
	public String toString() 
	{
		switch (this) 
		{
		case CONNECTIONNAME:
			return "ConnectionName";
		case DATABASEDRIVER:
			return "DatabaseDriver";
		case CONNECTIONSTRING:
			return "ConnectionString";
		case USERNAME:
			return "Username";
		case PASSWORD:
			return "Password";
		default:
			return null;
		}
	}
}

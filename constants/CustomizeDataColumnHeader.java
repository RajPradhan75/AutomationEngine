package com.nexops.auto.remediate.constants;

public enum CustomizeDataColumnHeader {

	NAME,TYPE,PARAMETER,FORMAT; 
	public String toString() 
	{
		switch (this) 
		{
		case NAME:
			return "Name";
		case TYPE:
			return "Type";
		case PARAMETER:
			return "Parameter";
		case FORMAT:
			return "Format";		
		default:
			return null;
		}
	}
}

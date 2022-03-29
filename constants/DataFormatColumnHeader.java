package com.nexops.auto.remediate.constants;

public enum DataFormatColumnHeader {

	NAME,TYPE,LOCALE; 
	public String toString() 
	{
		switch (this) 
		{
		case NAME:
			return "Name";
		case TYPE:
			return "Type";
		case LOCALE:
			return "Locale";		
		default:
			return null;
		}
	}
}

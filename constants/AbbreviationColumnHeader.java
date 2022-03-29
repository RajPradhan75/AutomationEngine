package com.nexops.auto.remediate.constants;

public enum AbbreviationColumnHeader {

	NAME,ABBREVIATION;
	
	public String toString() 
	{
		switch (this) 
		{
		case NAME:
			return "Name";
		case ABBREVIATION:
			return "Abbreviation";	
		default:
			return null;
		}
	}
}

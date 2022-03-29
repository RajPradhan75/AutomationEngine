package com.nexops.auto.remediate.constants;

public enum APITestingColumnHeader {

	APINAME,BASEURL,USERNAME,PASSWORD,AUTHTYPE,APIHEADER, APIPARAMETER, TOKENHEADER, TOKEPARAMETER, TOKENURL, GRANTTYPE, TOKENMETHOD;
	public String toString() 
	{
		switch (this) 
		{
		case APINAME:
			return "api_name";
		case BASEURL:
			return "base_uri";
		case USERNAME:
			return "username";
		case PASSWORD:
			return "password";
		case AUTHTYPE:
			return "auth_type";
			
//		case APIHEADER:
//			return "headers";
//		case APIPARAMETER:
//			return "query_parameters";
			
		case TOKENHEADER:
			return "token_headers";
		case TOKEPARAMETER:
			return "token_parameters";
		case TOKENURL:
			return "token_url";
		case GRANTTYPE:
			return "token_grant_type";
		case TOKENMETHOD:
			return "tokenMethod";
		default:
			return null;
		}
	}
}

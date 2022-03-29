package com.nexops.auto.remediate.constants;

public enum PageColumnHeader {

	CONTROL_TYPE, IDENTIFIER, IDENTIFIER_VALUE, INDEX, USER_ACTION, DATA_COLUMN, PROPERTY, SCREENSHOTS, DESCRIPTION;

	public String toString() {
		switch (this) {
		case CONTROL_TYPE:
			return "Control_Type";
		case IDENTIFIER:
			return "Identifier";
		case IDENTIFIER_VALUE:
			return "Identifier_Value";
		case INDEX:
			return "Index";
		case USER_ACTION:
			return "User_Action";
		case DATA_COLUMN:
			return "Data_Column";
		case PROPERTY:
			return "Property";
		case SCREENSHOTS:
			return "Screenshots";
		case DESCRIPTION:
			return "Description";
		default:
			return null;
		}
	}
}

package com.nexops.auto.remediate.constants;

public enum DynamicDataColumnHeader {

	NAME, TYPE, LENGTH, FORMAT, COMMENT; // Mantis 0000942

	public String toString() {
		switch (this) {
		case NAME:
			return "Name";
		case TYPE:
			return "Type";
		case LENGTH:
			return "Length";
		case FORMAT:
			return "Format";
		case COMMENT: // Mantis 0000942
			return "Comment";
		default:
			return null;
		}
	}
}

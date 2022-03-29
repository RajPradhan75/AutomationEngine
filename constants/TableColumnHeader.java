package com.nexops.auto.remediate.constants;

public enum TableColumnHeader {

	TEST_CASE, ROW, COLUMN, DATA, COLUMN_NAME;

	public String toString() {
		switch (this) {
		case TEST_CASE:
			return "Test_Case";
		case ROW:
			return "Row";
		case COLUMN:
			return "Column";
		case DATA:
			return "Data";
		case COLUMN_NAME:
			return "ColumnName";
		default:
			return null;
		}
	}
}

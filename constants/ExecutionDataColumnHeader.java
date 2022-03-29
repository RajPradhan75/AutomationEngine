package com.nexops.auto.remediate.constants;

public enum ExecutionDataColumnHeader {

	TEST_CASE, FIELD_NAME, FIELD_VALUE, COMMENTS;

	public String toString() {
		switch (this) {
		case TEST_CASE:
			return "Test_Case";
		case FIELD_NAME:
			return "Field_Name";
		case FIELD_VALUE:
			return "Field_Value";
		case COMMENTS:
			return "Comments"; // Mantis 0000713
		default:
			return null;
		}
	}
}

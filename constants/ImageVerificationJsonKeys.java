package com.nexops.auto.remediate.constants;

public enum ImageVerificationJsonKeys {

	CHECKPOINT_DETAILS, CHECKPOINT_NAME, BASELINE_IMAGE_PATH, ACTUAL_IMAGE_PATH, MODIFIED_BASELINE_PATH,
	MODIFIED_ACTUAL_PATH, DYNAMIC_REGION, PASS_COUNT, FAIL_COUNT, OVERALL_STATUS, DRIVER, SCRIPT, TEST_CASE,
	IS_BASELINE_PRESENT, EXEC_ID, PROJECTTYPE, PROJECT_ID, THRESHOLD, DIFFERENCES, RELEASE_ID, RESULT_ID, CHECKPOINT_ID,
	DHASH, BASE_BROWSER_IMG_PATH, BASELINE_BROWSER, VISUAL_VERIFY_MODE;

	public String toString() 
	{
		switch (this) 
		{
		case CHECKPOINT_DETAILS:
			return "Checkpoint_Details";
		case CHECKPOINT_NAME:
			return "Checkpoint_Name";
		case BASELINE_IMAGE_PATH:
			return "Baseline_Image_Path";
		case ACTUAL_IMAGE_PATH:
			return "Actual_Image_Path";
		case MODIFIED_BASELINE_PATH:  
			return "Modified_Baseline_Path";
		case MODIFIED_ACTUAL_PATH:  
			return "Modified_Actual_Path";
		case DYNAMIC_REGION:  
			return "Dynamic_Region";
		case PASS_COUNT:  
			return "Pass_Count";
		case FAIL_COUNT:  
			return "Fail_Count";
		case OVERALL_STATUS:  
			return "Overall_Status";	
		case DRIVER:
			return "Driver";
		case SCRIPT:
			return "Script";
		case TEST_CASE:
			return "Test_Case";
		case IS_BASELINE_PRESENT:
			return "Is_Baseline_Present";
		case EXEC_ID:
			return "Exec_ID";
		case PROJECTTYPE:
			return "ProjectType";
		case PROJECT_ID:
			return "Project_Id";
		case RELEASE_ID:
			return "Release_Id";
		case RESULT_ID:
			return "Results_Id";
		case CHECKPOINT_ID :
			return "Checkpoint_Id";
		case DHASH:							//Mantis 0001951,0001950
			return "DHash";
		case BASE_BROWSER_IMG_PATH:
			return "Base_Browser_Image_Path";
		case BASELINE_BROWSER:
			return "Baseline_Browser";
		case VISUAL_VERIFY_MODE:
			return "Visual_Verify_Mode";
		default:
			return null;
		}
	}
}

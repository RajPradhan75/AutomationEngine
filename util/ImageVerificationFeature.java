/*---------------------------- Change History ------------------------------*/
/*
User : Anum Shaikh
Date : 20 Aug 2020
Mantis : 0001913
 */
/*
User : Anum Shaikh
Date : 24 Aug 2020
Mantis : 0001917
 */
/*
User : Anum Shaikh
Date : 08 Sept 2020
Mantis : 0001925
 */
/*
User : Anum Shaikh
Date : 23 Sept 2020
Mantis : 0001941
 */
/*
User : Anum Shaikh
Date : 15 Jan 2021
Mantis : 0001951,0001950
 */
/*
User : Anum Shaikh
Date : 27 May 2021
Mantis :0002020
 */


package com.nexops.auto.remediate.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.nexops.auto.remediate.constants.ImageVerificationJsonKeys;
import com.nexops.auto.remediate.webautomation.KeywordDrivenFramework;


public class ImageVerificationFeature {
	static String baselineScriptTestCaseFolder = ""; // Mantis 0001917
	public static String baselineImageFolder = "";
	public static String webserver = "";
	final static int PerceptualThreshold = 2;	//Mantis 0001951,0001950

	public static List<HashMap<String, String>> updateDatabase(String Driver,
			List<HashMap<String, String>> imageCollection, List<HashMap<String, String>> scriptTestCase)
			throws IOException, SQLException { //Mantis 0002020
		JSONObject jObj = new JSONObject(Driver);
		String project_type=jObj.getString(ImageVerificationJsonKeys.PROJECTTYPE.toString());
		int project_id=jObj.getInt(ImageVerificationJsonKeys.PROJECT_ID.toString());
		int User_id = jObj.getInt("User_Id");
		String browser = jObj.getString("Browser").toLowerCase();	//Mantis 0001950

		String baseline_browser = jObj.getString(ImageVerificationJsonKeys.BASELINE_BROWSER.toString()).toLowerCase();	//Mantis 0001950,0001951
		String verify_mode = jObj.getString(ImageVerificationJsonKeys.VISUAL_VERIFY_MODE.toString()).toLowerCase();

		List<HashMap<String, String>> returnResults = new ArrayList<HashMap<String, String>>();
		String tempjsondetails; 

		for (HashMap<String, String> scriptTcObj : scriptTestCase) {
			final String script = scriptTcObj.get(ImageVerificationJsonKeys.SCRIPT.toString());
			final String testcase = scriptTcObj.get(ImageVerificationJsonKeys.TEST_CASE.toString());
			String jsondetails = ExcelConnection.checkIfBaselineScriptIsPresent(project_type, project_id, script,
					testcase, baseline_browser);
			Predicate<HashMap<String, String>> scriptcondition = obj -> obj
					.get(ImageVerificationJsonKeys.SCRIPT.toString()).equals(script);
			Predicate<HashMap<String, String>> tccondition = obj -> obj
					.get(ImageVerificationJsonKeys.TEST_CASE.toString()).equals(testcase);

			List<HashMap<String, String>> samescripts = imageCollection.stream()
					.filter(scriptcondition.and(tccondition)).collect(Collectors.toList());
			baselineScriptTestCaseFolder = browser + "/" + script + "/" + testcase;	//Mantis 0001950
			if (samescripts.size() == 0)
				continue;
			if (jsondetails == null && browser.equals(baseline_browser)) // Base line entry for script is not present  0001950
			{
				samescripts = ExcelConnection.addBaselineImage(project_type, project_id, script, testcase, samescripts,
						"scriptabsent", User_id, browser); 	//Mantis 0001950
				File f = new File(baselineImageFolder + "/" + baselineScriptTestCaseFolder); // Mantis 0001913
				if (!f.exists())
					f.mkdirs();
				for (HashMap<String, String> hashmapObj : samescripts) {
					final String cpname = hashmapObj.get(ImageVerificationJsonKeys.CHECKPOINT_NAME.toString());
					FileUtils.copyFile(new File(hashmapObj.get(ImageVerificationJsonKeys.ACTUAL_IMAGE_PATH.toString())),
							new File(baselineImageFolder + "/" + baselineScriptTestCaseFolder + "/" + cpname + ".jpg"));

					hashmapObj.put(ImageVerificationJsonKeys.IS_BASELINE_PRESENT.toString(), "New");
					returnResults.add(hashmapObj);
				}

			} else if (jsondetails != null && browser.equals(baseline_browser))// check baseline for each checkpoint 0001950
			{
				for (HashMap<String, String> hashmapObj : samescripts) {
					jsondetails = ExcelConnection.checkIfBaselineScriptIsPresent(project_type, project_id, script,
							testcase, baseline_browser); // Mantis 0001941
					ArrayList<HashMap<String, String>> addObj = new ArrayList<HashMap<String, String>>();
					addObj.add(hashmapObj);
					final String cpname = hashmapObj.get(ImageVerificationJsonKeys.CHECKPOINT_NAME.toString());
					int checkpointid = ExcelConnection.checkIfBaselineImagIsPresent(project_type, project_id, script,
							testcase, cpname, jsondetails);
					if (checkpointid == -1) {
						ExcelConnection.addBaselineImage(project_type, project_id, script, testcase, addObj,
								"checkpointabsent_" + jsondetails, User_id, browser);
						File f = new File(baselineImageFolder + "/" + baselineScriptTestCaseFolder); // Mantis
						// 0001913
						if (!f.exists())
							f.mkdirs();
						FileUtils.copyFile(
								new File(hashmapObj.get(ImageVerificationJsonKeys.ACTUAL_IMAGE_PATH.toString())),
								new File(baselineImageFolder + "/" + baselineScriptTestCaseFolder + "/" + cpname
										+ ".jpg"));

						int newindex = ExcelConnection.getLastCheckpointId(project_type, project_id, script, testcase,
								jsondetails);   //Mantis 0001950
						newindex++;
						hashmapObj.put(ImageVerificationJsonKeys.IS_BASELINE_PRESENT.toString(), "New");
						hashmapObj.put(ImageVerificationJsonKeys.CHECKPOINT_ID.toString(), newindex + "");
						returnResults.add(hashmapObj);

					} else {
						hashmapObj.put(ImageVerificationJsonKeys.IS_BASELINE_PRESENT.toString(), "Exist");
						hashmapObj.put(ImageVerificationJsonKeys.CHECKPOINT_ID.toString(), checkpointid + "");
						returnResults.add(hashmapObj);
					}
				}
			} else if (jsondetails == null && !(browser.equals(baseline_browser))) {	//Mantis 0001950
				for (HashMap<String, String> hashmapObj : samescripts) {
					hashmapObj.put(ImageVerificationJsonKeys.IS_BASELINE_PRESENT.toString(), "Base_Browser_New");
					hashmapObj.put(ImageVerificationJsonKeys.CHECKPOINT_ID.toString(), "");
					returnResults.add(hashmapObj);
				}

			} else if (jsondetails != null && !(browser.equals(baseline_browser))) { //Mantis 0001950
				for (HashMap<String, String> hashmapObj : samescripts) {
					jsondetails = ExcelConnection.checkIfBaselineScriptIsPresent(project_type, project_id, script,
							testcase, baseline_browser); // Mantis 0001941
					ArrayList<HashMap<String, String>> addObj = new ArrayList<HashMap<String, String>>();
					addObj.add(hashmapObj);
					final String cpname = hashmapObj.get(ImageVerificationJsonKeys.CHECKPOINT_NAME.toString());
					int checkpointid = ExcelConnection.checkIfBaselineImagIsPresent(project_type, project_id, script,
							testcase, cpname, jsondetails);
					if (checkpointid == -1) {
						hashmapObj.put(ImageVerificationJsonKeys.IS_BASELINE_PRESENT.toString(), "Base_Browser_New");
						returnResults.add(hashmapObj);
					} else {
						hashmapObj.put(ImageVerificationJsonKeys.IS_BASELINE_PRESENT.toString(), "Exist");
						hashmapObj.put(ImageVerificationJsonKeys.CHECKPOINT_ID.toString(), checkpointid + "");
						returnResults.add(hashmapObj);
					}
				}
			}
			if (!browser.equals(baseline_browser)) {	//Mantis 0001950
				// check if baseline is present for executing browser
				tempjsondetails = ExcelConnection.checkIfBaselineScriptIsPresent(project_type, project_id, script,
						testcase, browser);
				if (tempjsondetails == null) {
					samescripts = ExcelConnection.addBaselineImage(project_type, project_id, script, testcase,
							samescripts, "scriptabsent", User_id, browser);
					File f = new File(baselineImageFolder + "/" + baselineScriptTestCaseFolder); // Mantis 0001913
					if (!f.exists())
						f.mkdirs();
					for (HashMap<String, String> hashmapObj : samescripts) {
						final String cpname = hashmapObj.get(ImageVerificationJsonKeys.CHECKPOINT_NAME.toString());
						FileUtils.copyFile(
								new File(hashmapObj.get(ImageVerificationJsonKeys.ACTUAL_IMAGE_PATH.toString())),
								new File(baselineImageFolder + "/" + baselineScriptTestCaseFolder + "/" + cpname
										+ ".jpg"));
					}

				} else {			//Mantis 0001950
					for (HashMap<String, String> hashmapObj : samescripts) {
						tempjsondetails = ExcelConnection.checkIfBaselineScriptIsPresent(project_type, project_id,
								script, testcase, browser); // Mantis 0001941
						ArrayList<HashMap<String, String>> addObj = new ArrayList<HashMap<String, String>>();
						addObj.add(hashmapObj);
						final String cpname = hashmapObj.get(ImageVerificationJsonKeys.CHECKPOINT_NAME.toString());
						int checkpointid = ExcelConnection.checkIfBaselineImagIsPresent(project_type, project_id,
								script, testcase, cpname, tempjsondetails);
						if (checkpointid == -1) {

							ExcelConnection.addBaselineImage(project_type, project_id, script, testcase, addObj,
									"checkpointabsent_" + tempjsondetails, User_id, browser);
							File f = new File(baselineImageFolder + "/" + baselineScriptTestCaseFolder); // Mantis
							// 0001913
							if (!f.exists())
								f.mkdirs();
							FileUtils.copyFile(
									new File(hashmapObj.get(ImageVerificationJsonKeys.ACTUAL_IMAGE_PATH.toString())),
									new File(baselineImageFolder + "/" + baselineScriptTestCaseFolder + "/" + cpname
											+ ".jpg"));
						}
					}
				}

			}

		}
		return returnResults;
	}

	public static void generatePythonInputFile(List<HashMap<String, String>> ImageCollection, String pythoninput) {
		JSONObject jsonObject = new JSONObject();
		JSONArray array = new JSONArray();
		FileWriter writer = null;
		BufferedWriter bufferedWriter = null;
		try {
			for (HashMap<String, String> mp : ImageCollection) {
				jsonObject = new JSONObject();
				Iterator it = mp.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
					jsonObject.put(pair.getKey(), pair.getValue());
				}
				array.put(jsonObject);
			}
			writer = new FileWriter(pythoninput, true);
			bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(array.toString());
			System.out.println("File Generated for input to python");
			ImageCollection.clear();
		} catch (Exception e) {
			System.out.println("Error occured while creating PythonInput.txt");
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void UpdateImageResults(String Driver) {
		JSONArray array = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		JSONArray newarray = new JSONArray();
		JSONObject jObj = new JSONObject(Driver);   
		String verifymode = jObj.getString(ImageVerificationJsonKeys.VISUAL_VERIFY_MODE.toString()); //Mantis 0001951,0001950
		String baselinebrowser = jObj.getString(ImageVerificationJsonKeys.BASELINE_BROWSER.toString());

		try {
			File pythonoutput = new File(KeywordDrivenFramework.resultLogDirectory + "\\PythonOutput.txt");
			BufferedReader bf = new BufferedReader(new FileReader(pythonoutput));
			String text = "", line = "";
			while ((line = bf.readLine()) != null)
				text += line;
			// Reading from file and storing it in db
			array = (JSONArray) new JSONTokener(text).nextValue();

			int pass = 0, fail = 0;
			String individualstatus = "", individualdhashvalue = ""; //Mantis 0001951,0001950
			// Mantis 0001917
			String webServerPath = webserver.replaceAll("\\\\", "//");
			int startfolderindex = -1;
			if (webServerPath.startsWith("//")) {
				startfolderindex = webServerPath.indexOf("."); // ipaddress
				startfolderindex = webServerPath.indexOf("/", startfolderindex);
			} else if (webServerPath.charAt(1) == ':') {
				startfolderindex = webServerPath.indexOf("/");
			}
			//Mantis 0001917

			for (int i = 0; i < array.length(); i++) {
				jsonObject = array.getJSONObject(i);
				individualstatus = jsonObject.get(ImageVerificationJsonKeys.OVERALL_STATUS.toString()).toString();
				individualdhashvalue = jsonObject.get(ImageVerificationJsonKeys.DHASH.toString()).toString(); 	//Mantis 0001951,0001950

				String fullpath = jsonObject.get(ImageVerificationJsonKeys.MODIFIED_ACTUAL_PATH.toString()).toString();
				if (fullpath != null && fullpath.trim().length() != 0) {
					fullpath = fullpath.substring(fullpath.indexOf("Results")).replaceAll("\\\\", "/"); // Mantis
					// 0001091,0001917
					fullpath = webServerPath.substring(startfolderindex) + "/" + fullpath;
					jsonObject.put(ImageVerificationJsonKeys.MODIFIED_ACTUAL_PATH.toString(), fullpath);
				}

				fullpath = jsonObject.get(ImageVerificationJsonKeys.MODIFIED_BASELINE_PATH.toString()).toString();
				if (fullpath != null && fullpath.trim().length() != 0) {
					fullpath = fullpath.substring(fullpath.indexOf("Results")).replaceAll("\\\\", "/"); // Mantis
					// 0001091,0001917
					fullpath = webServerPath.substring(startfolderindex) + "/" + fullpath;
					jsonObject.put(ImageVerificationJsonKeys.MODIFIED_BASELINE_PATH.toString(), fullpath);
				}

				fullpath = jsonObject.get(ImageVerificationJsonKeys.ACTUAL_IMAGE_PATH.toString()).toString();
				if (fullpath != null && fullpath.trim().length() != 0) {
					fullpath = fullpath.substring(fullpath.indexOf("Results")).replaceAll("\\\\", "/"); // Mantis
					// 0001091,0001917
					fullpath = webServerPath.substring(startfolderindex) + "/" + fullpath;
					jsonObject.put(ImageVerificationJsonKeys.ACTUAL_IMAGE_PATH.toString(), fullpath);
				}

				fullpath = jsonObject.get(ImageVerificationJsonKeys.BASELINE_IMAGE_PATH.toString()).toString();
				if (fullpath != null && fullpath.trim().length() != 0) {
					fullpath = fullpath.substring(fullpath.indexOf("BaseLineImageFolder")).replaceAll("\\\\", "/"); // Mantis
					// 0001925
					fullpath = webServerPath.substring(startfolderindex) + "/" + fullpath; // Mantis 0001917
					System.err.println("Base line image path " + fullpath);
					jsonObject.put(ImageVerificationJsonKeys.BASELINE_IMAGE_PATH.toString(), fullpath);
				}
				newarray.put(jsonObject);
				System.out.println("Verify mode is " + verifymode); 
				if (verifymode.equalsIgnoreCase("pixel_to_pixel")) { //Mantis 0001951,0001950
					if (individualstatus.equalsIgnoreCase("PASS"))
						pass++;
					else
						fail++;
				} else if (verifymode.equalsIgnoreCase("perceptual")) { //Mantis 0001951,0001950
					if (Integer.parseInt(individualdhashvalue) <= PerceptualThreshold) {
						pass++;
						jsonObject.put(ImageVerificationJsonKeys.OVERALL_STATUS.toString(), "PASS");
					} else {
						fail++;
						jsonObject.put(ImageVerificationJsonKeys.OVERALL_STATUS.toString(), "FAIL");
					}
					//jsonObject.put(ImageVerificationJsonKeys.MODIFIED_BASELINE_PATH.toString(), fullpath);
				}
				System.out.println("Verify mode is " + verifymode + " pass " + pass + " fail " + fail);

				System.out.println("Index " + i + "\t Data " + jsonObject);
			}
			ExcelConnection.addImageVerificationResults(Driver, newarray, pass, fail,baselinebrowser,verifymode);
			System.out.println("Image Verfication Details added to db");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured while writing the image results into db");
		}
	}
}
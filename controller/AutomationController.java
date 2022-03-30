package com.nexops.auto.remediate.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexops.auto.remediate.util.ExcelConnection;


@RestController
@RequestMapping("/automation")
public class AutomationController {

	
	private ExcelConnection service;

	@SuppressWarnings({ "static-access" })
	@GetMapping(value = "/getApiTesting", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getApiTesting(@RequestParam("api_name") String api_name) {
		try {
			Object result = service.getApiTestingData(api_name);
			if (result != null) 
				return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
			else 
				return new ResponseEntity<String>("Resultant data is Empty", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
		
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/getScriptJsonfromDB", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getScriptJsonfromDB(@RequestParam("Component_Name") String Component_Name) {
		try {
			Object result = service.getScriptJsonfromDB(Component_Name);
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/getExecutionDatafromDb", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getExecutionDatafromDb() {
		try {
			Object result = service.getExecutionDatafromDb();
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/getApiDetailsJsonFromDB", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getApiDetailsJsonFromDB(@RequestParam("filename") String filename) {
		try {
			String result = service.getApiDetailsJsonFromDB(filename);
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/updateExecutionData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ExcelConnection updateExecutionData(@RequestParam("JsonData") String JsonData) {

		try {
			service.updateExecutionData(JsonData);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return service;
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/getdbFilefromJson", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getdbFilefromJson(@RequestParam("Query_Name") String dbFile) {
		try {
			Object result = service.getdbFilefromJson(dbFile);
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/getMasterDataFileColumns", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getMasterDataFileColumns(@RequestParam("filename") String filename) {
		try {
			Map<String, Integer> result = service.getMasterDataFileColumns(filename);
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/readCustomizeData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> readCustomizeData() {
		try {
			List<List<String>> result = service.readCustomizeData();
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/readAbbreviation", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> readAbbreviation() {
		try {
			List<List<String>> result = service.readAbbreviation();
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/readAPIConnections", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> readAPIConnections() {
		try {
			List<List<String>> result = service.readAPIConnections();
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/getDbDriverData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getDbDriverData() {
		try {
			Map<String, JSONObject> result = service.getDbDriverData();
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/readDatabaseConnections", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> readDatabaseConnections() {
		try {
			List<List<String>> result = service.readDatabaseConnections();
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/readDataFormat", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> readDataFormat() {
		try {
			List<List<String>> result = service.readDataFormat();
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/readDynamicData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> readDynamicData() {
		try {
			List<List<String>> result = service.readDynamicData();
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/readConfigData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> readConfigData(@RequestParam("Driver") String Driver) {
		try {
			List<List<String>> result = service.readConfigData(Driver);
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/getComponentIdFromName", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> getComponentIdFromName(@RequestParam("Component_Name") String script_name,
			@RequestParam("Project_Id") Integer Project_Id) {
		try {
			int result = service.getComponentIdFromName(script_name, Project_Id);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/abortExecution", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> abortExecution() {
		try {
			boolean result = service.abortExecution();
			return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/checkIfBaselineScriptIsPresent", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> checkIfBaselineScriptIsPresent(@RequestParam("project_type") String project_type,
			@RequestParam("project_id") Integer project_id, @RequestParam("script_name") String script_name,
			@RequestParam("testcase") String testcase, @RequestParam("browser") String browser) {
		try {
			String result = service.checkIfBaselineScriptIsPresent(project_type, project_id, script_name, testcase,
					browser);
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/addBaselineImage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBaselineImage(@RequestParam("project_type") String project_type,
			@RequestParam("project_id") Integer project_id, @RequestParam("script_name") String script_name,
			@RequestParam("testcase") String testcase, @RequestParam("hmapList") List<HashMap<String, String>> hmapList,
			@RequestParam("baselinepresent") String baselinepresent, @RequestParam("userId") Integer userId,
			@RequestParam("browser") String browser) {
		try {
			List<HashMap<String, String>> result = service.addBaselineImage(project_type, project_id, script_name,
					testcase, hmapList, baselinepresent, userId, browser);
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@SuppressWarnings("static-access")
	@GetMapping(value = "/addImageVerificationResults", produces = MediaType.APPLICATION_JSON_VALUE)
	public void addImageVerificationResults(@RequestParam("DriverPath") String DriverPath,
			@RequestParam("array") org.json.JSONArray array, @RequestParam("pass") Integer pass,
			@RequestParam("fail") Integer fail, @RequestParam("baselinebrowser") String baselinebrowser,
			@RequestParam("verifymode") String verifymode) {
		try {
			service.addImageVerificationResults(DriverPath, array, pass, fail, baselinebrowser, verifymode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unused", "static-access" })
	@GetMapping(value = "/getTempComponentIdFromName", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getTempComponentIdFromName(@RequestParam("Component_Name") String Component_Name,
			@RequestParam("Project_Id") int Project_Id) {

		try {

			Object result = service.getTempComponentIdFromName(Component_Name, Project_Id);
			if (result != null)
				return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
			else
				return new ResponseEntity<String>("Resultant data is Empty", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}

	}

}

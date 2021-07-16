package com.TestVagrant.Util;

import java.util.HashMap;

import org.testng.Assert;

import com.TestVagrant.Pages.MoreDetailsPage;
import com.TestVagrant.Reports.ExtentReportListener;
import com.TestVagrant.RestService.EnvSpecificData;
import com.TestVagrant.RestService.RestServiceHelper;
import com.relevantcodes.extentreports.LogStatus;

public class PerformWeatherDataComparison extends ExtentReportListener {

	public static void compare(HashMap<String, Integer> uiWeatherServiceData, HashMap<String, Integer>restServiceWeatherData) {
		String acceptableTempDiff=EnvSpecificData.getConfig().get("temperature");
		String acceptableHumidityDiff=EnvSpecificData.getConfig().get("humidity");
		String acceptablePressureDiff=EnvSpecificData.getConfig().get("pressure");
		String acceptablevisibilityDiff=EnvSpecificData.getConfig().get("visibility");

		uiWeatherServiceData=RestServiceHelper.getDataFromRestService();
		restServiceWeatherData=MoreDetailsPage.getCurrentWeatherDataFromUI();
		test.log(LogStatus.INFO, "Comparing UI data with REST Service data and logging result");
		boolean testResultFlag=false;
		for (String key : uiWeatherServiceData.keySet()) {
			int uiData=uiWeatherServiceData.get(key);
			int restData=restServiceWeatherData.get(key);
			
			if (key.equalsIgnoreCase("temperature")) {
				if (restData-uiData<=Integer.parseInt(acceptableTempDiff)) {
					test.log(LogStatus.PASS, "The difference between temperature in Celsius on UI and Rest service is within acceptable range");
					testResultFlag=true;
				}
				else {
					test.log(LogStatus.FAIL, "There is Temperature variance between Accuweather UI and OpenWeather API in Celsius");
					test.log(LogStatus.INFO, "UI Temp in Celsius on UI="+uiData+", Rest Temp= "+restData+" Difference is "+(restData-uiData)+" acceptable is "+acceptableTempDiff);
					testResultFlag=false;
				}
			}
			if (key.equalsIgnoreCase("humidity")) {
				if (restData-uiData<=Integer.parseInt(acceptableHumidityDiff)) {
					test.log(LogStatus.PASS, "The difference between humidity percentage on UI and Rest service is within acceptable range");
					testResultFlag=true;
				}
				else {
					test.log(LogStatus.FAIL, "There is Humidity variance between Accuweather UI and OpenWeather API in percentage");
					test.log(LogStatus.INFO, "Humidity in % on UI="+uiData+", Rest Humidity= "+restData+" Difference is "+(restData-uiData)+" acceptable is "+acceptableHumidityDiff);
					testResultFlag=false;
				}
			}
			if (key.equalsIgnoreCase("pressure")) {
				if (restData-uiData<=Integer.parseInt(acceptablePressureDiff)) {
					test.log(LogStatus.PASS, "The difference between Pressure in MB on UI and Rest service is within acceptable range");
					testResultFlag=true;
				}
				else {
					test.log(LogStatus.FAIL, "There is Pressure variance between Accuweather UI and OpenWeather API in MiiliBars (Mb)");
					test.log(LogStatus.INFO, "Pressure in MB on UI="+uiData+", Rest pressure= "+restData+" Difference is "+(restData-uiData)+" acceptable is "+acceptablePressureDiff);
					testResultFlag=false;
				}
			}
			if (key.equalsIgnoreCase("visibility")) {
				if (restData-uiData<=Integer.parseInt(acceptablevisibilityDiff)) {
					test.log(LogStatus.PASS, "The difference between Visibility in KM on UI and Rest service is within acceptable range");
					testResultFlag=true;
				}
				else {
					test.log(LogStatus.FAIL, "There is Visibility variance between Accuweather UI and OpenWeather API in KMs");
					test.log(LogStatus.INFO, "Visibility in KM on UI="+uiData+" Rest visibility= "+restData+" Difference is "+(restData-uiData)+" acceptable is "+acceptablevisibilityDiff);
					testResultFlag=false;
				}
			}
		}
		if (!testResultFlag)
			Assert.fail("Since some Weather parameters did not match the test is failed");
	}
}
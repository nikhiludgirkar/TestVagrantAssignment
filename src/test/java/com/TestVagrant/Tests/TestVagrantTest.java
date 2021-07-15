package com.TestVagrant.Tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.TestVagrant.Pages.LandingApp;
import com.TestVagrant.Pages.MoreDetailsPage;
import com.TestVagrant.RestService.RestServiceHelper;
import com.TestVagrant.Util.PerformWeatherDataComparison;
import com.TestVagrant.Reports.*;

@Listeners(ExtentReportListener.class)
public class TestVagrantTest extends LandingApp{
	
	
	@Test
	public void testVagrantTestCase() throws IOException, InterruptedException {
		startTest()
		.enterCity("Bengaluru")
		.clickCity("Bengaluru, Karnataka")
		.clickMoreDetails();
		HashMap<String, Integer> weatherDataMapFromUI=MoreDetailsPage.getCurrentWeatherDataFromUI();
		System.out.println(weatherDataMapFromUI);
		HashMap<String, Integer> weatherDataMapFromRest=RestServiceHelper.getDataFromRestService();
		System.out.println(weatherDataMapFromRest);
		PerformWeatherDataComparison.compare(weatherDataMapFromUI, weatherDataMapFromRest);
	}
	
	@AfterClass
	public void shutDown() {
		if (getDriver()!=null)
			getDriver().close();
	}
}

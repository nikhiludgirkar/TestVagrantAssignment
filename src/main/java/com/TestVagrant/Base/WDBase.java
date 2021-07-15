package com.TestVagrant.Base;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.TestVagrant.Reports.ExtentReportListener;
import com.TestVagrant.RestService.EnvSpecificData;
import com.relevantcodes.extentreports.LogStatus;


public class WDBase extends ExtentReportListener {
	private static WebDriver driver;

	public static void setDriver() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		test.log(LogStatus.INFO, "Launching browser");
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void launch() throws IOException{
		setDriver();
		test.log(LogStatus.INFO, "Launching the website");
		getDriver().get(EnvSpecificData.getConfig().get("url"));
	}

	public static void close() {
		if (getDriver()!=null) {
			test.log(LogStatus.INFO, "Closing the browser");
			getDriver().quit();
		}
	}
}

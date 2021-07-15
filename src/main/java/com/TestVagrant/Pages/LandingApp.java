package com.TestVagrant.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestVagrant.Base.WDBase;
import com.relevantcodes.extentreports.LogStatus;

public class LandingApp extends WDBase{

	public LandingApp startTest() throws IOException {
		launch();
		return this;
	}
	public LandingApp enterCity(final String cityName) {
		test.log(LogStatus.INFO, "Entering data in city");
		getDriver().findElement(By.name("query")).sendKeys(cityName);
		getDriver().findElement(By.name("query")).sendKeys(Keys.ENTER);
		return this;
	}
	
	public CurrentWeatherPage clickCity(final String cityName) throws InterruptedException {
		test.log(LogStatus.INFO, "Selecting weather data of "+cityName);
		WebDriverWait wait=new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='locations-list content-module']/child::a[contains(text(), '"+cityName+"')]")));
		getDriver().findElement(By.xpath("//div[@class='locations-list content-module']/child::a[contains(text(), '"+cityName+"')]")).click();
		getDriver().navigate().back();
		getDriver().findElement(By.xpath("//div[@class='locations-list content-module']/child::a[contains(text(), '"+cityName+"')]")).click();
		return new CurrentWeatherPage();
	}
}

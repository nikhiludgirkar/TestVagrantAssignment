package com.TestVagrant.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class CurrentWeatherPage extends LandingApp {
	
	public MoreDetailsPage clickMoreDetails() {
		JavascriptExecutor js=(JavascriptExecutor)getDriver();
		js.executeScript("window.scrollBy(0, 100)");
		getDriver().findElement(By.xpath("//span[@class='cur-con-weather-card__cta']//span[contains(text(), 'More Details')]")).click();
		return new MoreDetailsPage();
	}
}

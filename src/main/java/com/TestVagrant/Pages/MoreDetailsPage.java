package com.TestVagrant.Pages;

import java.util.HashMap;

import org.openqa.selenium.By;

public class MoreDetailsPage extends LandingApp {
	public static HashMap<String, Integer> getCurrentWeatherDataFromUI(){
		HashMap<String, Integer> weatherData=new HashMap<String, Integer>();
		String temp=getDriver().findElement(By.xpath("//div[@class='display-temp']")).getText();
		String humidityInString=getDriver().findElement(By.xpath("//div[@class='left']/child::div[3]/child::div[contains(text(), 'Humidity')]/following-sibling::div")).getText();
		String visibilityInKM=getDriver().findElement(By.xpath("//div[@class='right']/child::div[@class='detail-item spaced-content'][3]/child::div[contains(.,'Visibility')]/following-sibling::div")).getText();
		String pressureString=getDriver().findElement(By.xpath("//div[@class='right']/child::div[@class='detail-item spaced-content'][1]/child::div[contains(.,'Pressure')]/following-sibling::div")).getText();
		
		pressureString=pressureString.replaceAll("[a-zA-Z]", "");
		pressureString=pressureString.substring(2, 6);
		humidityInString=humidityInString.replaceAll("\\%", "");
		temp=temp.replace("°C", "");
		
		visibilityInKM=visibilityInKM.replaceAll("[a-zA-Z]", "");
		visibilityInKM=visibilityInKM.replace(" ", "");
		
		int temperature=Integer.parseInt(temp);
		int pressure=Integer.parseInt(pressureString);
		int visibility=Integer.parseInt(visibilityInKM);
		int humidity=Integer.parseInt(humidityInString);
		
		weatherData.put("temperature", temperature);
		weatherData.put("humidity", humidity);
		weatherData.put("pressure", pressure);
		weatherData.put("visibility", visibility);
		return weatherData;
	}
}

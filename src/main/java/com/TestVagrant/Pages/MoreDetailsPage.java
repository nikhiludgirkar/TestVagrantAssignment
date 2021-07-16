package com.TestVagrant.Pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class MoreDetailsPage extends LandingApp {
	public static HashMap<String, Integer> getCurrentWeatherDataFromUI(){
		HashMap<String, Integer> weatherData=new HashMap<String, Integer>();
		String temp=null;
		String humidityInString=null;
		String visibilityInKM=null;
		String pressureString=null;
		try {
			temp=getDriver().findElement(By.xpath("//div[@class='display-temp']")).getText();
			humidityInString=getDriver().findElement(By.xpath("//div[@class='left']/child::div/descendant::div[text()='Humidity']/following-sibling::div")).getText();
			visibilityInKM=getDriver().findElement(By.xpath("//div[@class='right']/child::div[@class='detail-item spaced-content']/descendant::div[text()='Visibility']/following-sibling::div")).getText();
			pressureString=getDriver().findElement(By.xpath("//div[@class='right']/child::div[@class='detail-item spaced-content']/descendant::div[text()='Pressure']/following-sibling::div")).getText();
		}catch (NoSuchElementException ex) {
			ex.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

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

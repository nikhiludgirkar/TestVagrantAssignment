package com.TestVagrant.RestService;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;

import java.util.HashMap;

import com.TestVagrant.Reports.ExtentReportListener;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class RestServiceHelper extends ExtentReportListener{
	
	public static HashMap<String, Integer> getDataFromRestService() {
		baseURI="https://api.openweathermap.org/";
		Response response=
		given()
		.when()
			.get(APIEndpoints.apiPath.GET_DETAIL_OF_WEATHER)
		.then()
			.extract()
			.response();
		
		JsonPath jsonPath=response.jsonPath();
		float temperatureInK=jsonPath.get("main.temp");
		float temp=temperatureInK- 273.15F;
		int tempInInt=(int)temp;
		
		int humidity=jsonPath.get("main.humidity");
		int pressure=jsonPath.get("main.pressure");
		int visi=jsonPath.get("visibility");
		int visibility=visi/1000;
		
		HashMap<String, Integer> responseFieldsMap=new HashMap<String, Integer>();
		responseFieldsMap.put("temperature", tempInInt);
		responseFieldsMap.put("humidity", humidity);
		responseFieldsMap.put("pressure", pressure);
		responseFieldsMap.put("visibility", visibility);
		return responseFieldsMap;
	}
}
package com.TestVagrant.RestService;

public class APIEndpoints {
	public static final class apiPath{
		public static final String GET_DETAIL_OF_WEATHER="/data/2.5/weather?q="+EnvSpecificData.getConfig().get("cityName")+"&appid="+EnvSpecificData.getConfig().get("apiKey");
		
	}
}

package com.TestVagrant.RestService;

import java.util.HashMap;


public class HeaderConfig {
	public HashMap<String, String> defaultHeaders(){
		HashMap<String, String> defaultHeaders=new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		return defaultHeaders;
	}
}

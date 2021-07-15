package com.TestVagrant.Base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	private static Properties prop;
	public static Properties getData() throws FileNotFoundException, IOException {
		prop=new Properties();
		prop.load(new FileReader(new File(System.getProperty("user.dir")+"/resources/application.properties")));
		return prop;
	}

}

package com.w2a.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
public static void main(String[] args) throws IOException {
	
	System.out.println(System.getProperty("user.dir"));
	FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
	Properties properties=new Properties();
	properties.load(fileInputStream);
	System.out.println(properties.get("bmlBtn"));
	
}
}

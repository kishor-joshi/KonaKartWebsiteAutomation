package com.konakart.util;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.konakart.helper.ExcelReader;


public class DataProviderClass {
	
	@DataProvider(name="userData")
	public  String[][] getdata() throws IOException {

	   return ExcelReader.getUserData(Constants.userProductDataPath);
	}
}

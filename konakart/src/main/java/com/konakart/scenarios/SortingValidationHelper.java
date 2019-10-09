package com.konakart.scenarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.konakart.helper.MonthConvertion;
import com.konakart.util.Constants;
import com.konakart.util.PageManager;

public class SortingValidationHelper {
	
	
	
	Logger log=Logger.getLogger(SortingValidationHelper.class);
MonthConvertion monthObj=new MonthConvertion();
String date,differenceOfDate,getClassName,eachRatingXpath;
String[] dateArray,actualDateList;
int totalproduct;
//List<WebElement>allRatings;


public String[] sortDate(List<WebElement>allDates) {
	String listOfDayDifference[]=new String[allDates.size()/2];
	
	
	for(int index=0;index<allDates.size()/2;index++) {
		date=allDates.get(index).getText();
		dateArray=allDates.get(index).getText().split("\\s+", 2);
		differenceOfDate=monthObj.monthDifference(dateArray[1]);
		listOfDayDifference[index]=differenceOfDate;
		log.info("date is "+date+" difference in date is "+differenceOfDate);
	}
	
	log.info(Arrays.toString(listOfDayDifference));
    return listOfDayDifference;
}
public int[] getAllRating(WebDriver driver,Properties property,int totalProductNumber) throws IOException {
	PageManager.loadpropertyFile(Constants.productPropertiesFilePath, property);
	
	totalproduct=(totalProductNumber*5)/2;
	int listOfRating[]=new int[totalProductNumber/2];
	int index=0;
	int count=0;
	
	for(int indexOfRating=0;indexOfRating<totalproduct;indexOfRating++) {
		
		
			eachRatingXpath=property.getProperty("productRatingList")+"["+(indexOfRating+1)+"]";
			getClassName=driver.findElement(By.xpath(eachRatingXpath)).getAttribute("class");
			if(getClassName.contains("full"))
				count++;
			if(indexOfRating%5==4) {
				System.out.println(indexOfRating);
				listOfRating[index++]=count;
				count=0;
			}
			
	}
	System.out.println(Arrays.toString(listOfRating));
	return listOfRating;
}


}



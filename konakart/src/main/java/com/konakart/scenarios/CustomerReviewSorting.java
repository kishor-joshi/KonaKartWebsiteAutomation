package com.konakart.scenarios;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.konakart.helper.KonakartExtendReport;
import com.konakart.util.Constants;
import com.konakart.util.PageManager;

public class CustomerReviewSorting extends ValidationOfSpecificProduct {
	SortingValidationHelper validation=new SortingValidationHelper();
	String sortingDropDownXpath,dropDownText;
	List<WebElement>dateList;
	public static String[] actualDateSorting,expectedDateSorting;
	
	
	
	
public void validateSortingByMostRecent() throws Exception {
	
	PageManager.loadpropertyFile(Constants.productPropertiesFilePath, property);
	sortingDropDownXpath=property.getProperty("sortingDropDown");
	dropDownText=property.getProperty("mostrecent");
	
	dateList=helper.getElements(driver, property, "date");
	actualDateSorting=validation.sortDate(dateList);
	expectedDateSorting=actualDateSorting;
	Arrays.sort(actualDateSorting);
	Assert.assertEquals(actualDateSorting, expectedDateSorting, "date sorting not matched");
	PageManager.selectDropDownText(driver, sortingDropDownXpath, property.getProperty("oldest"));
	KonakartExtendReport.reportLog("validateSortingByMostRecent", "failed");
}



public void validateSortingByOldest() throws Exception {
	
	PageManager.loadpropertyFile(Constants.productPropertiesFilePath, property);
	sortingDropDownXpath=property.getProperty("sortingDropDown");
	dropDownText=property.getProperty("oldest");
	PageManager.selectDropDownText(driver, sortingDropDownXpath, dropDownText);
	dateList=helper.getElements(driver, property, "date");
	actualDateSorting=validation.sortDate(dateList);
	expectedDateSorting=actualDateSorting;
	 Arrays.sort(actualDateSorting, Collections.reverseOrder()); 
	Assert.assertEquals(actualDateSorting, expectedDateSorting, "date sorting not matched");
	PageManager.selectDropDownText(driver, sortingDropDownXpath, property.getProperty("oldest"));
	KonakartExtendReport.reportLog("validateSortingByOldes", "failed");
	
}

}

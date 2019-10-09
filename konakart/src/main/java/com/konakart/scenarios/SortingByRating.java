package com.konakart.scenarios;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.konakart.util.Constants;
import com.konakart.util.PageManager;

public class SortingByRating extends CustomerReviewSorting{
	
	List<WebElement>allRatings;
	int[] actualRatingList,expectedRatingList;
	
	
public void validateRatingHighToLow() throws Exception {
	PageManager.manageTimeOuts(driver);
	PageManager.loadpropertyFile(Constants.productPropertiesFilePath, property);
	dropDownText=property.getProperty("highToLow");
	PageManager.selectDropDownText(driver, sortingDropDownXpath, dropDownText);
	allRatings=helper.getElements(driver, property, "date");
	actualRatingList=validation.getAllRating(driver, property,allRatings.size());
	expectedRatingList=actualRatingList;
	Arrays.sort(expectedRatingList);
	Assert.assertEquals(actualRatingList, expectedRatingList,"rating not matched");
 
	
	
}
public void validateRatingLowToHigh() throws Exception {
	PageManager.manageTimeOuts(driver);
	PageManager.loadpropertyFile(Constants.productPropertiesFilePath, property);
	dropDownText=property.getProperty("lowToHigh");
	PageManager.selectDropDownText(driver, sortingDropDownXpath, dropDownText);
	allRatings=helper.getElements(driver, property, "date");
	actualRatingList=validation.getAllRating(driver, property,allRatings.size());
	expectedRatingList=actualRatingList;
	Arrays.sort(expectedRatingList);
	Assert.assertEquals(actualRatingList, expectedRatingList,"rating not matched");
 
	
	
}
}

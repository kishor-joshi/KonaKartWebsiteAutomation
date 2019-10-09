package com.konakart.scenarios;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.konakart.helper.KonakartExtendReport;
import com.konakart.util.BaseClass;
import com.konakart.util.Constants;
import com.konakart.util.PageManager;



public class ValidationOfSpecificProduct extends BaseClass{
	ValidationOfEachContentPage contentObj=new ValidationOfEachContentPage();
	WebElement galleryElement;
	
	
	
	
public void naviateToSpecificProductDetailPage() throws Exception {
	PageManager.loadpropertyFile(Constants.productPropertiesFilePath, property);
	KonakartExtendReport.reportLog(" naviateToSpecificProductDetailPage", "failed");
	helper.getElement(driver, property, "imageLink").click();
}



public void navigateToProductContent() throws Exception {
	PageManager.loadpropertyFile(Constants.productPropertiesFilePath, property);
	 galleryElement=helper.getElement(driver, property, "gallery");
	PageManager.scrollAndViewAtTop(driver, galleryElement);
	List<WebElement>productContentList=helper.getElements(driver, property, "productContent");
	contentObj.ValidateContent(productContentList);
	KonakartExtendReport.reportLog(" navigateToProductContent", "failed");
}



}

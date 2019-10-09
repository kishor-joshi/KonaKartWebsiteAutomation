package com.konakart.scenarios;



import java.util.List;

import org.openqa.selenium.WebElement;

import com.konakart.helper.ElementHelper;
import com.konakart.helper.KonakartExtendReport;
import com.konakart.util.BaseClass;
import com.konakart.util.Constants;
import com.konakart.util.PageManager;

public class QuickSearchPage extends BaseClass {

	ElementHelper helper=new ElementHelper();
	String dropDownXpath,itemXpath;
	String actualMessage,expectedMessage;
	
	public void search(String dropDownText,String productName,String message) throws Exception {
		PageManager.loadpropertyFile(Constants.homeLocatorPropertiesFilePath, property);
		dropDownXpath=property.getProperty("dropdown");
		PageManager.selectDropDownText(driver, dropDownXpath, dropDownText);
		helper.getElement(driver, property, "input").sendKeys(productName);
		this.expectedMessage=message;
		log.info("dropdowntext is: "+dropDownText+" searched product is: "+productName);
		
		KonakartExtendReport.reportLog("search ", "failed");
		helper.getElement(driver, property, "searchbutton").click();
	}
	
	
	
	public void getItemMessage() throws Exception {
		PageManager.loadpropertyFile(Constants.homeLocatorPropertiesFilePath, property);
		
			List<WebElement>itemList=helper.getElements(driver, property, "itemMessage");
		
		if(itemList.size()>0) {
			actualMessage=itemList.get(0).getText();
			ItemMessageValidation.validateItemMessage(actualMessage, expectedMessage);
			KonakartExtendReport.reportLog("getItemMessage ", "failed");
		}
		else
		{
			List<WebElement>productList=helper.getElements(driver, property, "productList");
			ItemMessageValidation.getItems(productList);
		}
		
	}
	
	}
	
	


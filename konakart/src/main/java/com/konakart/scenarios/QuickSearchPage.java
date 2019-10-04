package com.konakart.scenarios;



import com.konakart.helper.ElementHelper;
import com.konakart.util.BaseClass;
import com.konakart.util.Constants;
import com.konakart.util.PageManager;

public class QuickSearchPage extends BaseClass {

	ElementHelper helper=new ElementHelper();
	String dropDownXpath;
	public void search(String dropDownText,String productName) throws Exception {
		PageManager.loadpropertyFile(Constants.homeLocatorPropertiesFilePath, property);
		dropDownXpath=property.getProperty("dropdown");
		PageManager.selectDropDownText(driver, dropDownXpath, dropDownText);
		helper.getElement(driver, property, "input").sendKeys(productName);
		helper.getElement(driver, property, "searchbutton").click();
	}
}

package com.konakart.searchproducttestscript;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.konakart.scenarios.ItemMessageValidation;
import com.konakart.scenarios.QuickSearchPage;
import com.konakart.util.DataProviderClass;




public class SearchProductTestScript {
	
	QuickSearchPage page=new QuickSearchPage();
	ItemMessageValidation validate=new ItemMessageValidation();
			
			
	@Parameters({"browserType"})
	@BeforeClass
	public void setBrowser(String browserType) throws IOException {
		page.openBrowser(browserType);
	}
	
		
		
	@Test(dataProvider = "userData",dataProviderClass =DataProviderClass.class )
	public void OutComeOfSearch(String dropDownText,String productName,String message) throws Exception {
		page.search(dropDownText,productName,message);
			
	}
		
		
	@AfterMethod
	public void message() throws Exception {
		page.getItemMessage();
			
		}
}

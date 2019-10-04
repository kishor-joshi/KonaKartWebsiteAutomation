package com.konakart.testscript;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.konakart.scenarios.QuickSearchPage;
import com.konakart.util.DataProviderClass;




public class TestScript {
	
		QuickSearchPage page=new QuickSearchPage();
			
			
		@Parameters({"browserType"})
		@BeforeClass
		public void setBrowser(String browserType) throws IOException {
			page.openBrowser(browserType);
		}
		
		@Test(dataProvider = "userData",dataProviderClass =DataProviderClass.class )
		public void OutComeOfSearch(String dropDownText,String productName) throws Exception {
			page.search(dropDownText,productName);
			
		}
}

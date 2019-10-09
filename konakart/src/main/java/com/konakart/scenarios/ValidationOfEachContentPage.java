package com.konakart.scenarios;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.konakart.helper.ExcelReader;
import com.konakart.helper.KonakartExtendReport;
import com.konakart.util.Constants;
import com.konakart.util.PageManager;
import java.util.Properties;

public class ValidationOfEachContentPage {
	static Logger log=Logger.getLogger(ValidationOfEachContentPage.class);
	static String currentContent;
	static String expetedContent;
	String[][] getContent;
public void ValidateContent(List<WebElement>contentList) throws IOException {
	getContent=ExcelReader.getUserData(Constants.contentDataPath);
	for(int index=0;index<contentList.size();index++) {
		contentList.get(index).click();
		currentContent=contentList.get(index).getText();
		expetedContent=getContent[index][0];
		validateContent(currentContent, expetedContent);
		
	}
}

public static void validateContent(String actualContent,String expectedContent) {
	if(actualContent.contains(expetedContent))
		 log.info("passed: selected content is "+currentContent +" & current content is "+currentContent);
	 else
		 Assert.assertEquals(false,"content are different ");
	}
}


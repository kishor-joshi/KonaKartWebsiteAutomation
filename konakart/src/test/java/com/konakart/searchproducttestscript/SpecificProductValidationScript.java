package com.konakart.searchproducttestscript;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.konakart.scenarios.CustomerReviewSorting;
import com.konakart.scenarios.SortingByRating;

public class SpecificProductValidationScript {
	SortingByRating product=new SortingByRating();
	
	@Parameters({"browserType"})
	@BeforeClass
	public void setBrowser(String browserType) throws IOException {
		product.openBrowser(browserType);
	}
	@Test
	public void navigateToProductDetails() throws Exception {
		product.naviateToSpecificProductDetailPage();
		product.navigateToProductContent();
		product.validateSortingByMostRecent();
		product.validateSortingByOldest();
		product.validateRatingHighToLow();
		product.validateRatingLowToHigh();
	}
}

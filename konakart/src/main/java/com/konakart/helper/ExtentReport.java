package com.konakart.helper;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
* Extent Report to generate report for pass,fail and skip test case.
* To generate screenshot for pass,fail and skip test case.
*
* @author indira.saravanan
*
*/
public class ExtentReport {
public static WebDriver driver;
ExtentHtmlReporter htmlReporter;
protected ExtentReports extent;
protected ExtentTest test;

@BeforeSuite
public void startReport() {
htmlReporter = new ExtentHtmlReporter("extent.html");
htmlReporter.config().setDocumentTitle("Automation Report-Atmecs.com");
extent = new ExtentReports();
extent.attachReporter(htmlReporter);
extent.setSystemInfo("OS", "windows10");
extent.setSystemInfo("browser", "chrome");
}

@AfterMethod
public void tearDown(ITestResult result) throws Exception {
if (result.getStatus() == ITestResult.FAILURE) {
test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
test.log(Status.INFO, "TEST CASE FAILED IS " + result.getThrowable());
//String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
//test.addScreenCaptureFromPath(screenshotPath);
}

else if (result.getStatus() == ITestResult.SKIP) {
test.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());
test.log(Status.INFO, "TEST CASE SKIPPED IS " + result.getThrowable());
//String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
//test.addScreenCaptureFromPath(screenshotPath);
}

else if (result.getStatus() == ITestResult.SUCCESS) {
test.log(Status.PASS, "TEST CASE PASSED IS " + result.getName());

}
}
}
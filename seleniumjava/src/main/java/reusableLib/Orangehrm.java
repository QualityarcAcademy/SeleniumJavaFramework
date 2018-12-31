package reusableLib;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.ExcelDataProvider;

public class Orangehrm extends ReusableFunctions {
	
	public String browserName;
	public String sheetName;
	
	@BeforeMethod
	public void SampleReport() {
		 ExtentHtmlReporter html = new ExtentHtmlReporter("./Reports/Extent.html");
		 ExtentReports extent = new ExtentReports();
		 extent.attachReporter(html);
		 extent.createTest("OranceHRM").pass("Test Passed");
		 extent.flush();

	}

//	@BeforeSuite
//	public void beforeSuite(){
//		startResult();
//	}
//
//	@BeforeClass
//	public void beforeClass(){		
//		startTestModule(testCaseName, testDescription);	
//	}
//
//	@BeforeMethod
//	public void beforeMethod(){
//		test = startTestCase(testNodes);
//		test.assignCategory(category);
//		test.assignAuthor(authors);
//		OpenApp();		
//	}
//
//	@AfterSuite
//	public void afterSuite(){
//		endResult();
//	}
//
//	@AfterMethod
//	public void afterMethod(){
//		//closeAllBrowsers();
//	}
	
	/**
	 * Retrieves data from excel and stores in two dimentional object as the data type may not be string always. Remember to assign as many column
	 * values as paramerters in @Test method
	 * 
	 * @param username
	 * @param password
	 */

	@DataProvider(name="ExcelData")
	public Object[][] dataProvider() {
		String[][] data = ExcelDataProvider.getExcelData("TestData");
		return data;
		
	}
	


}

package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPg;
import reusableLib.Orangehrm;
import reusableLib.ReusableFunctions;
import utils.ExcelDataProvider;


public class TC001_LoginTest extends Orangehrm{
	

	@Test(dataProvider="ExcelData")
	public void positiveLoginTest(String username, String password) {
		OpenBrowser();
		new LoginPg(driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginBtn();

	}
	
	@Test(dataProvider="ExcelData")
	public void positiveLoginTest1(String username, String password) {
		OpenBrowser();
		new LoginPg(driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginBtn();

	}


}

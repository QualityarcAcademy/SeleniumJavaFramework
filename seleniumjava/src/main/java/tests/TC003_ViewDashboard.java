package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPg;
import reusableLib.Orangehrm;
import reusableLib.ReusableFunctions;
import reusableLib.ReusableFunctions.Browser;
import utils.ExcelDataProvider;


public class TC003_ViewDashboard extends Orangehrm{

	@BeforeTest
	public void setup() {
		browserName = Browser.EDGE;
		dataSheetName = "Sheet1";

	}

	@Test(dataProvider="ExcelData")
	public void viewDashboard(String username, String password) {
		new LoginPg(driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginBtn()
		.clickOnAssignLeave();

	}

}

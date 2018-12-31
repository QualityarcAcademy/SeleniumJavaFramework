package tests;

import org.testng.annotations.Test;
import pages.LoginPg;
import reusableLib.Orangehrm;
import reusableLib.ReusableFunctions;
import utils.ExcelDataProvider;


public class TC002_ApplyLeave extends Orangehrm{

	@Test
	public void positiveLoginTest() {
		String[][] testData = ExcelDataProvider.getExcelData("TestData");
		String Username = testData[1][0];
		String Password = testData[1][1];
		OpenBrowser();
		new LoginPg(driver)
		.enterUsername(Username)
		.enterPassword(Password)
		.clickLoginBtn()
		.clickOnAssignLeave();

	}

}

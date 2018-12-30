package tests;

import org.testng.annotations.Test;

import pages.LoginPg;
import reusableLib.Orangehrm;
import reusableLib.ReusableFunctions;
import utils.ReadExcel;


public class TC001_VerifyLeaveStatus extends Orangehrm{

	@Test
	public void positiveLoginTest() {
		String[][] testData = ReadExcel.getExcelData("TestData");
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

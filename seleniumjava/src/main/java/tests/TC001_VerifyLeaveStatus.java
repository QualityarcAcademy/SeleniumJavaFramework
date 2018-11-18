package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import reusableLib.Orangehrm;
import utils.ReadExcel;

public class TC001_VerifyLeaveStatus extends Orangehrm{
	
	@Test
	public void verifyLeaveStatus() {
		String[][] testData = ReadExcel.getExcelData("TestData");
		String Username = testData[1][0];
		String Password = testData[1][1];
		OpenApp();
		loadWebObject();
		new HomePage()
		.enterUsername(Username)
		.enterPassword(Password)
		.clickLoginBtn();

	}
}

package webFramework;

import org.testng.annotations.Test;

import reusableLib.ReusableFunctions;
import utils.ReadExcel;

public class Driver extends ReusableFunctions {

	public static void main(String[] args) {
		ReadExcel.getExcelData("TestData");

	}
	
	
	public void firstTest() {
		OpenApp();

	}


}


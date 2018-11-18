package pages;

import reusableLib.Orangehrm;
import reusableLib.ReusableFunctions;

public class HomePage extends Orangehrm{
	public HomePage() {
		if(driver.getTitle().equals("OrangeHRM")) {
			System.out.println("Home page is launched successfully");
		}
	}
	
	public HomePage enterUsername(String Username) {
		enterByID(prop.getProperty("Home.Username.ID"), Username);
		return this;
	}
	
	public HomePage enterPassword(String Password) {
		enterByID(prop.getProperty("Home.Password.ID"), Password);
		return this;
	}
	
	public Dashboard clickLoginBtn() {
		clickByID(prop.getProperty("Home.LoginBtn.ID"));
		return new Dashboard();
	}

}

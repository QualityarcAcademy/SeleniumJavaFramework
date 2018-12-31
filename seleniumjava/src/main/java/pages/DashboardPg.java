package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import reusableLib.Orangehrm;

public class DashboardPg extends Orangehrm {
	
	public DashboardPg(RemoteWebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	/**
	 * Stores all web elements (Page objects - Fields)
	 * 
	 * This uses @FindBy and @FindBys methods
	 * 
	 */

	@FindBy(how=How.XPATH, using="//span[text()='Assign Leave']") 
	private WebElement AssignLeaveLink;
	

	/**
	 * Stores all Dashboard page actions (Object's methods )
	 * 
	 * @param Username, password
	 * @return 
	 */

	public DashboardPg clickOnAssignLeave() {
		click(driver,AssignLeaveLink);
		return this;
	}

	//TO-DO Add more web elements and methods 
	
}

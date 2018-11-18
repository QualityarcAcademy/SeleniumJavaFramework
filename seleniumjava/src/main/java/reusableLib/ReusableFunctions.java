package reusableLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
public class ReusableFunctions extends utils.Reporter {

	public static RemoteWebDriver driver; 
	public static Properties prop;
	public String URL, browser;

	public ReusableFunctions(){
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/global.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		URL = prop.getProperty("URL");
		browser = prop.getProperty("Browser");

	}

	public RemoteWebDriver OpenApp() {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new InternetExplorerDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;

	}

	public void loadWebObject() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/object.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void enterByID(String ID, String text) {
		driver.findElement(By.id(ID)).clear();
		driver.findElementById(ID).sendKeys(text);
	}

	public void clickByID(String ID) {
		driver.findElementById(ID).click();

	}

	public void clickByXpath(String xpath){
		driver.findElementByXPath(xpath).click();

	}

	public String getTextByXpath(String xpath, String retrievedString) {
		driver.findElementByXPath(xpath).getText();
		return retrievedString;

	}

	public void clickByLinkText(String LnkTxt) {
		driver.findElementByLinkText(LnkTxt).click();
	}

	@Override
	public long takeSnap() {
		// TODO Auto-generated method stub
		return 0;
	}

	//Add methods above
}



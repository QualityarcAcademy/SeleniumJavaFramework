package reusableLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ReusableFunctions extends utils.Reporter {

	public WebDriver driver;
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

	public WebDriver OpenBrowser() {
		if(browser.equalsIgnoreCase("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver_win32/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
	
	
	/**
	 * Method used to type in given data into text fields
	 * 
	 * @param element
	 * @param data
	 */
	public void typeInto(WebElement element, String data) {
		try {
			element.clear();
			element.sendKeys(data);
		} catch (InvalidElementStateException e) {
			e.printStackTrace();
		}catch(WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void click(WebElement element){
		try {
			//WebDriverWait wait = new WebDriverWait(this.driver, 10);
			//wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}



	@Override
	public long takeSnap() {
		// TODO Auto-generated method stub
		return 0;
	}

	//Add methods above
}



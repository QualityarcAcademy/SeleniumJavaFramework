package reusableLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.OutputType;
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
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
public class ReusableFunctions extends utils.Reporter {

	public RemoteWebDriver driver;
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

	}

	/**
	 * 
	 * Browser Enum - Current implementation has Chrome, Firefox and Edge
	 */

	public enum Browser{CHROME, FIREFOX, EDGE}

	/**
	 * Opens up given Browser. 
	 * Change the desired browser in the global.properties file 
	 * 
	 * @param browser Enum 
	 * @return browser instance 
	 */

	public WebDriver OpenBrowser(Browser browser) {
		if(browser == browser.CHROME) {
			//System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver_win32/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser == browser.FIREFOX) {
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

	/**
	 * Method used to type in given data into text fields
	 * 
	 * @param element
	 * @param data
	 */

	@Step("The element is typed with {data}")
	public void typeInto(WebElement element, String data) {
		try {
			element.clear();
			element.sendKeys(data);
			takeSnap();
		} catch (InvalidElementStateException e) {
			e.printStackTrace();
		}catch(WebDriverException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method used to click given element 
	 * 
	 * @param element
	 */
	
	@Step("The element is clicked")
	public void click(RemoteWebDriver driver, WebElement element){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			takeSnap();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}


	}
	
	/**
	 * Captures screenshot and attaches to allure reporting
	 * @return
	 */

	@Attachment("Screenshot")
	public byte[] takeSnap() {
		byte[] screenshotBytes =  driver.getScreenshotAs(OutputType.BYTES);
		return screenshotBytes; 
	}
	
	/**
	 * Closes all browser instance
	 * 
	 */
	public void closeBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Add more actions 
}



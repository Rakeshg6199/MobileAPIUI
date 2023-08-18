package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	public static void getBrowser(String browserName) throws Exception {
		try {
			switch (browserName.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();

				break;
			case "firefox":
				driver = new FirefoxDriver();

				break;
			case "edge":
				driver = new EdgeDriver();

				break;

			default:
				throw new Exception("Not a valid browsername :"+browserName);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Browser name is not valid");
		}

	}

	public static void getAppUrl(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("App url is not valid");
		}

	}
	public static void waitForElementVisible(WebElement element) throws Exception {
		try {
			WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}

	}
	public static void inputSendkeys(WebElement element,String text) throws Exception {
		try {
			waitForElementVisible(element);
			element.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Not able to insert the values");
		}

	}
	public static void inputButton(WebElement element) throws Exception {
		try {
			waitForElementVisible(element);
			element.click();
		}catch(Exception e ){
			e.printStackTrace();
			throw new Exception("Button not able to click");
		}
	}

	public static boolean isDisplayed(WebElement element) throws Exception {
		try {
			waitForElementVisible(element);
			boolean displayed = element.isDisplayed();
			return displayed;
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element is not displayed");
		}
	}

	public static boolean isEnabled(WebElement element) throws Exception {
		try {
			waitForElementVisible(element);
			boolean enabled = element.isEnabled();
			return enabled;
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}	

	}
}

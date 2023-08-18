package com.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class BaseAppium {

	public static WebDriver driver;
	public static DesiredCapabilities capabilities;
	
	public static void browserSetup() {
		capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appium:automationName", "uiautomator2");
		capabilities.setCapability("appium:platformVersion", "13");
		capabilities.setCapability("appium:deviceName", "emulator-5554");
		capabilities.setCapability("appium:appPackage", "com.omr_branch");
		capabilities.setCapability("appium:appActivity", "com.omr_branch.MainActivity");
	}
		
	
	public static void launchUrl() throws MalformedURLException {
		URL remoteUrl = new URL("http://127.0.0.1:4723/");

		driver = new AndroidDriver(remoteUrl, capabilities);
	}
	
	
	
	public static void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	
	public static void elementSendkeys(WebElement element, String value) throws Exception {
		try{
			waitForElement(element);
			element.sendKeys(value);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Cannot pass values");
		}
		
	}
	
	public static void elementClick(WebElement element) throws Exception {
		try {
		waitForElement(element);
		element.click();
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Not able to click the button");
		}
	}
	
	public static void selectByText(WebElement element, String text) throws Exception {
		try {
		waitForElement(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Not able to select the text in ddp");
		}
	}
	
	
	
}

package com.test;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.base.BaseAppium;

public class Appium extends BaseAppium {

	public static void main(String[] args) throws Exception {

		browserSetup();
		launchUrl();

		WebElement txtUsername = driver.findElement(By.xpath("//*[@resource-id='login_email_input']"));
		boolean displayed = txtUsername.isDisplayed();
		System.out.println(displayed);
		elementSendkeys(txtUsername, "premsrikg@gmail.com");

		WebElement txtPassword = driver.findElement(By.xpath("//*[@resource-id='login_password_input']"));
		elementSendkeys(txtPassword, "Prem@765");

		WebElement btnLogin = driver.findElement(By.xpath("//*[@text='Login']"));
		btnLogin.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//*[@resource-id='search_select_state']")).click();

		driver.findElement(By.xpath("//*[@text='Karnataka']")).click();

		driver.findElement(By.xpath("//*[@text='Select City']")).click();

		driver.findElement(By.xpath("//*[@text='Bengaluru']")).click();

		driver.findElement(By.xpath("//*[@text='Select Room Type']")).click();

		driver.findElement(By.xpath("//*[@text='Deluxe']")).click();

		driver.findElement(By.xpath("//*[@resource-id='search_select_checkin']")).click();

		driver.findElement(By.xpath("//*[@text='Confirm']")).click();

		driver.findElement(By.xpath("//*[@resource-id='search_select_checkout']")).click();

		driver.findElement(By.xpath("//*[@text='Confirm']")).click();

		driver.findElement(By.xpath("//*[@text='No. Of Room']")).click();

		driver.findElement(By.xpath("//*[@text='2-Two']")).click();

		driver.findElement(By.xpath("//*[@text='No. Of Adults']")).click();

		driver.findElement(By.xpath("//*[@text='1-One']")).click();

		driver.findElement(By.xpath("//*[@text='No. Of Children']")).sendKeys("1");

		driver.findElement(By.xpath("//*[@text='Search']")).click();
		
		String text = driver.findElement(By.xpath("//*[@resource-id='select_hotel_text']")).getText();
		System.out.println(text);

		
		Dimension size = driver.manage().window().getSize();
		
		int height = size.getHeight();
		int width = size.getWidth();
		
		int startY =(int) (height * 0.70);
		int endY = (int) (height * 0.30);
		

		int centerX = width/2;
		
		PointerInput pointerInput = new PointerInput(Kind.TOUCH, "Finger1");
		

		Sequence sequence = new Sequence(pointerInput, 1);
		
		sequence.addAction(pointerInput.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, startY));
		sequence.addAction(pointerInput.createPointerDown(1));
		
		sequence.addAction(pointerInput.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), centerX,endY));
		sequence.addAction(pointerInput.createPointerUp(1));
		
		
		
		RemoteWebDriver rdriver = (RemoteWebDriver) driver;
		rdriver.perform(Arrays.asList(sequence));
		
		
		
	}
}

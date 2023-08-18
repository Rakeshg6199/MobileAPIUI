package com.step;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends BaseClass{

	LoginPage loginPage;
	
	@Given("User is on OMR branch login page")
	public void user_is_on_omr_branch_login_page() throws Exception {
		getBrowser("chrome");
		getAppUrl("https://omrbranch.com/");
		
	}
	@When("User enter {string} username and {string} password")
	public void user_enter_username_and_password(String email, String pass) throws Exception {
		loginPage = new LoginPage();
		WebElement txtEmail = loginPage.getTxtEmail();
		inputSendkeys(txtEmail, email);
		
		WebElement txtPassword = loginPage.getTxtPassword();
		inputSendkeys(txtPassword, pass);
	}
	@When("User clicks remember me checkbox")
	public void user_clicks_remember_me_checkbox() throws Exception {
		inputButton(loginPage.getBtnRememberMe());
		
	}
	@When("USer clicks on login button")
	public void u_ser_clicks_on_login_button() throws Exception {
		inputButton(loginPage.getBtnLogin());
	}
	@Then("User should navigate to OMR branch home page")
	public void user_should_navigate_to_omr_branch_home_page() {
		System.out.println("Error Message");
	}
}

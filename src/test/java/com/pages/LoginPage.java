package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement txtEmail;
	
	@FindBy(id = "pass")
	private WebElement txtPassword;
	
	@FindBy(name = "remember_me")
	private WebElement btnRememberMe;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnLogin;

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(WebElement txtEmail) {
		this.txtEmail = txtEmail;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(WebElement txtPassword) {
		this.txtPassword = txtPassword;
	}

	public WebElement getBtnRememberMe() {
		return btnRememberMe;
	}

	public void setBtnRememberMe(WebElement btnRememberMe) {
		this.btnRememberMe = btnRememberMe;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(WebElement btnLogin) {
		this.btnLogin = btnLogin;
	}

	
}

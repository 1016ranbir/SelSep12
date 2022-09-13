package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {
	
	
	@FindBy(id= "user_login")
	private WebElement username;
	
	@FindBy(id = "user_password")
	private WebElement password;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	@FindBy(css = "#login_form > div.alert.alert-error")
	private WebElement errorLink;
	
	public Login( WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void ApplicationLogin(String loginname, String loginPassword) {
		
		username.sendKeys(loginname);
		password.sendKeys(loginPassword);
		submitBtn.click();
		
	}
	
	public String VerifyInvalidLogin(String loginname, String loginPassword) {
		
		username.sendKeys(loginname);
		password.sendKeys(loginPassword);
		submitBtn.click();
		return errorLink.getText();
	}
	

}

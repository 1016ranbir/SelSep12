package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsConfirm {

		@FindBy(css = "#transfer_funds_content > div > div > div.alert.alert-success")
		private WebElement confirmMsg;
		
		@FindBy(css = "#transfer_funds_content > div > a")
		private WebElement viewOrmaketranferlink;
		
		
		@FindBy(css="#settingsBox > ul > li:nth-child(3) > a")
		private WebElement usernamelink;
		
		@FindBy(id = "logout_link")
		private WebElement logoutlink;
		
		@FindBy(id="signin_button")
		private WebElement signinBtn;
		
		public TransferFundsConfirm(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
			
		}
		public String verifymsg() {

			return confirmMsg.getText();
			
		}
		
		
		public void logout() {
			usernamelink.click();
			logoutlink.click();
			signinBtn.click();
		}
}

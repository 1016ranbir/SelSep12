package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFunds {

	@FindBy(id = "tf_fromAccountId")
	private WebElement fromAccount;
	
	@FindBy(id = "tf_toAccountId")
	private WebElement toAccount;
	
	@FindBy(id = "tf_amount")
	private WebElement transferAmount;
	
	@FindBy(id = "tf_description")
	private WebElement description;
	
	@FindBy(id = "btn_submit")
	private WebElement continuebtn;
	
	public TransferFunds(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	public void TransferFund(String amount, String desc) {
		
		Select fromAccountDropdown = new Select(fromAccount);
		fromAccountDropdown.selectByIndex(2);
		
		Select toAccountDropdown = new Select(toAccount);
		toAccountDropdown.selectByIndex(3);
		
		transferAmount.sendKeys(amount);
		
		description.sendKeys(desc);
		
		continuebtn.click();
		
	}
	
	
}

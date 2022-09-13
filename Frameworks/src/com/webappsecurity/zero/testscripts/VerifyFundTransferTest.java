package com.webappsecurity.zero.testscripts;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webappsecurity.zero.pages.Home;
import com.webappsecurity.zero.pages.Login;
import com.webappsecurity.zero.pages.TransferFunds;
import com.webappsecurity.zero.pages.TransferFundsConfirm;
import com.webappsecurity.zero.pages.TransferFundsVerify;

import utils.ExcelRead;

public class VerifyFundTransferTest extends Base {

	@Test
	public void VerifyTransferFund() throws IOException {
		Login lp = new Login(driver);
		Home hm = new Home(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundsConfirm tfc= new TransferFundsConfirm(driver);
		
		TransferFunds tf = new TransferFunds(driver);
		
		String[][] data = ExcelRead.getData("C:\\Users\\U02375\\Documents\\Selenuim\\Lectures\\Session 8 - DDF\\ExcelDD.xlsx", "SheetData");
		
		for(int i=1; i<data.length;i++) {
			
			   lp.ApplicationLogin(data[i][0], data[i][1]);
				driver.navigate().back();			
				hm.ClicktransferFunds();				
				tf.TransferFund(data[i][2], data[i][3]);				
				tfv.ClicksubmitBtn();				
				String actualMessage = tfc.verifymsg();
				String expectedMessage ="You successfully submitted your transaction.";
				
				Assert.assertEquals(actualMessage, expectedMessage);
				
				tfc.logout();
			
		}
		
	}
	
}

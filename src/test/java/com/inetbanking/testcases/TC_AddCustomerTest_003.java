package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AdCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException

	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.submitBtn();

		Thread.sleep(3000);

		AdCustomerPage addcust = new AdCustomerPage(driver);

		addcust.clickAddNewCustomer();

		logger.info("providing customer details....");

		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");

		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		}

		else {
			logger.info("test case failed....");
			try {
				captureScreen(driver, "addNewCustomer");
			}

			catch (IOException e) {

				e.printStackTrace();
			}
			Assert.assertTrue(false);
		}
	}

	
}

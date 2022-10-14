package com.AgileCrmAutomationtest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;
import com.AgileCrmAutomation.CompanyPage;
import com.AgileCrmAutomation.LoginPage;

public class CompanyTest extends BaseClass {

	@Test(groups = { "regression", "sanity" })

	public void companyTest_module(String browser) throws InterruptedException {
		launchbrowser("chrome");
		driver.navigate().to("https://pulsar1901.agilecrm.com/");
		@SuppressWarnings("unused")
		LoginPage loginPage = new LoginPage();
		LoginPage.login("saggy@yopmail.com", "Test12345");

		click(By.id("companiesmenu"), "Click on Company menu");
		CompanyPage companyPage = new CompanyPage();
		companyPage.addCompany();
	}

}

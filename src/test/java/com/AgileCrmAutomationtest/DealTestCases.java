package com.AgileCrmAutomationtest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;
import com.AgileCrmAutomation.DealPage;
import com.AgileCrmAutomation.LoginPage;

public class DealTestCases extends BaseClass {
	@Test
	public void dealsTest_module() throws Exception {
		launchbrowser("Chrome");
		driver.get("https://pulsar1901.agilecrm.com/");
		LoginPage.login("saggy@yopmail.com", "Test12345");
		click(By.id("dealsmenu"), "Click On Deal Menu");
		DealPage dealpage = new DealPage();
		dealpage.ChangeDealsStatus("New", "Prospect");
	}
}
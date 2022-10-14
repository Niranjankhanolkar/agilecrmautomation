package com.AgileCrmAutomationtest;

import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;
import com.AgileCrmAutomation.ExcelUtil;
import com.AgileCrmAutomation.LoginPage;

public class LoginAgileCrmTestCase extends BaseClass {
	@Test

	public void login_TestCase() throws InterruptedException {
		launchbrowser("chrome");
		driver.navigate().to("https://pulsar1901.agilecrm.com/");
		LoginPage loginPage = new LoginPage();

		String filePath = "D:\\Selenium Codes\\ExcelUtil.xlsx";
		ExcelUtil excelvalues = new ExcelUtil();
		Object[][] data = excelvalues.getExcelData(filePath, "LoginTestData");
		int rowLength = data.length;
		for (int i = 1; i <= rowLength - 1; i++) {
			String username = data[i][0].toString();
			String password = data[i][1].toString();
			LoginPage.login("username", "password");
		}

	}
}
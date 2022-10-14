package com.AgileCrmAutomationtest;

import org.openqa.selenium.By;
import com.AgileCrmAutomation.BaseClass;

public class LoginTestCases extends BaseClass

{
	public static void Login(String username, String password) {
		driver.findElement(By.xpath("//*[@id=\"email-input\"]/input")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"pwd-input\"]/input")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"signup-main-container-first\"]/div[5]/input")).click();
	}

	public static void ValidMSg() {
		try {
			if (driver.findElement(By.name("password")).isDisplayed()) {
				System.out.println("login failed");
			}
		} catch (Exception e) {
			System.out.println("errormessage not displayed");
		}
	}

	public static void main(String[] arg) throws InterruptedException {
		launchbrowser("Chrome");
		driver.navigate().to("https://pulsar1901.agilecrm.com/");

		// valid username and invalid password
		Login("cst212@yopmail.com", "Test@12345655");
		ValidMSg();

		// invalid username and valid password
		Login("cst21056@yopmail.com", "Test1234");
		ValidMSg();

		// invalid username and invalid password
		Login("cst210@yopmail.com", "Test@1234");
		ValidMSg();
	}
}

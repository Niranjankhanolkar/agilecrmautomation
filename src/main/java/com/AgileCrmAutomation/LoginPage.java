package com.AgileCrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseClass {
	public static void login(String username, String password) {
		WebElement uname = driver.findElement(By.name("email"));
		uname.clear();
		uname.sendKeys(username);
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys(password);
		WebElement signIn = driver.findElement(By.xpath("//input[@type='submit']"));
		signIn.click();
	}

	public static void validmsg() {
		try {
			if (driver.findElement(By.xpath("//*[@id=\"agile\"]/div[1]/div[2]/input")).isDisplayed()) {
				System.out.println("Login failed");
			}
		} catch (Exception e) {
			System.out.println("Login successful");
		}
	}

	public static void logout() {
		driver.findElement(By.xpath("//*[@id=\"fat-menu\"]/a/span/img")).click();
		driver.findElement(By.xpath("//*[@id=\"fatMenuModal\"]/div[2]/div/div/div/div[3]/div/a")).click();
	}
}

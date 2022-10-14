package com.AgileCrmAutomationtest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class AmazonWindowHandling extends BaseClass {
	@BeforeMethod
	public void beforemethod() {
		System.out.println("This Is Before Method");
		launchbrowser("Chrome");
		driver.navigate().to("https://www.amazon.in/");
	}

	@Test
	public void amazonWindowSetup() throws AWTException {
// locating the customer service module in amazon.	
		WebElement CustomerService = driver
				.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Customer Service']"));
		Actions action = new Actions(driver);
//action class to click on customer service link.
		action.contextClick(CustomerService).build().perform();
//selecting first option using keys
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
//get ParentId
		String parentId = driver.getWindowHandle();
		System.out.println("parentId:" + parentId);
//get All window Id
		Set<String> AllwindowId = driver.getWindowHandles();
//iterate set of all window
		for (String WindowId : AllwindowId) {
			if (!WindowId.equals(parentId))
//if window id is not parent then go inside if condition
				System.out.println("Child Window id:" + WindowId);// child window id
			System.out.println(driver.getTitle());
		}
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("This Is After Method");
	}
}
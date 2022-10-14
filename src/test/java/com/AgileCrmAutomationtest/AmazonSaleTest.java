package com.AgileCrmAutomationtest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class AmazonSaleTest extends BaseClass {
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void amazonEndOfSale() throws AWTException {
		launchbrowser("Chrome");
		driver.navigate().to("https://www.amazon.in/");
		WebElement img = driver.findElement(By.xpath("//div[@id='desktop-banner']"));
		img.click();
		Actions action = new Actions(driver);
		action.contextClick().click().perform();
		Robot rb = new Robot();
		rb.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		rb.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		String parentId = driver.getWindowHandle();
		System.out.println("parentId:" + parentId);
		Set<String> allWindowID = driver.getWindowHandles();
		for (String WindowId : allWindowID) {
			if (!WindowId.equals(allWindowID)) {
				driver.switchTo().window(WindowId);
				System.out.println("shift to other window");
			}
			List<WebElement> DealNames = driver.findElements(By.xpath("//div[contains(@class,'DealContent')]"));
			for (WebElement element : DealNames) {
				System.out.println(element.getText());
			}
		}
	}
}
package com.AgileCrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DealPage extends BaseClass {
	public void ChangeDealsStatus(String srcStatus, String dstStatus) throws Exception {
		// wait until the element is clickable"
		waitForElementToBeClickable(By.xpath("//div[@id='New-list-container'" + srcStatus + "']"));

		// locate Source Element
		WebElement srcElement = driver.findElement(By.xpath("//div[@id='New-list-container'" + srcStatus + "']"));

		// get the name of the Source Deal
		String dealsName = driver
				.findElement(By.xpath("//*[@id='5504057271189504' " + srcStatus + "']/div[1]/div[2]/a")).getText();

		// Locate Destination Element
		WebElement dstElement = driver.findElement(By.xpath("//div[@id='New-list-container'" + dstStatus + "']"));

		// perform drag and drop between Source and destination element
		Actions action = new Actions(driver);
		action.dragAndDrop(srcElement, dstElement).build().perform();
		System.out.println("Changing the status of " + dealsName + "from" + srcStatus + "to" + dstStatus);

		// get the name of dest deal
		WebElement dstdealsName = driver
				.findElement(By.xpath("//*[@id='5504057271189504' " + dstStatus + "']/div[1]/div[2]/a"));

		verifyDealsStatus(dstStatus, dstdealsName);
	}

	public void verifyDealsStatus(String expectedStatus, WebElement element) throws Exception {
		// wait until the dst element is clickable
		waitForElementToBeClickable((By) element);
		element.click();
		String actualStatus = driver.findElement(By.xpath("//div[@class'panel-body']/descendant::span[2]")).getText();
		if (actualStatus.equals(actualStatus)) {
			System.out.println("Successfully perform Drag and drop operation");
		} else {
			throw new Exception("Drag and drop did worked from source element");

		}
	}
}
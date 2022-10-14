package com.AgileCrmAutomationtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class AmazonApplianceSearch extends BaseClass {
	@Test

	public void amazonAppliance() {
//launchbrowser
		launchbrowser("Chrome");
		driver.get("https://www.amazon.in/");
// select appliances from drop down box.
		selectDropDownValbyText(driver.findElement(By.id("searchDropdownBox")), "Appliances");
//enter washing machine
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Washing Machine");
		click(By.xpath("//*[@id='nav-search-submit-button']"), "Click on search button");
//list the Element Name and Prices
		List<WebElement> applianceNames = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
		List<WebElement> appliancePrice = driver.findElements(
				By.xpath("//div[@class='sg-row']/descendant::a[@target='_blank']/span[@class='a-price']"));
		for (int i = 0; i < applianceNames.size(); i++) {
			String name = applianceNames.get(i).getText();
			String price = appliancePrice.get(i).getText();
			System.out.println(name + " : " + price);
		}
	}
}
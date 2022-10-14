package com.AgileCrmAutomationtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class AmazonLaptops extends BaseClass {
	@Test

	public void amazonLaptops() {
//launchbrowser
		launchbrowser("Chrome");
		driver.navigate().to("https://www.amazon.in/");
//select drop down list and enter electronics.
		selectDropDownValbyText(driver.findElement(By.id("searchDropdownBox")), "Electronics");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptops above 30000");
		click(By.xpath("//*[@id='nav-search-submit-button']"), "Click on search button");
// laptops names and prices
		List<WebElement> LaptopName = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
		List<WebElement> LaptopPrice = driver.findElements(
				By.xpath("//div[@class='sg-row']/descendant::a[@target='_blank']/span[@class='a-price']"));
		for (int i = 0; i < LaptopName.size(); i++) {
			if (driver
					.findElements(
							By.xpath("//div[@class='sg-row']/descendant::a[@target='_blank']/span[@class='a-price']"))
					.size() < 30000)
				;
			String name = LaptopName.get(i).getText();
			String price = LaptopPrice.get(i).getText();
			System.out.println(name + " : " + price);
		}
	}

}
package com.AgileCrmAutomation;

import org.openqa.selenium.By;

public class ContactPage extends BaseClass {
	String firstname;
	String lastname;

	public String addcontact() {
		firstname = "Sagar";
		lastname = "Pardeshi";

		click(By.xpath("//li[@id='contactsmenu']"), "click on contact menu");
		click(By.xpath("//div[@id=\"view-list\"]/div/button"), "click on add button");
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(lastname);
		return firstname;
	}

	public void searchcontact(String firstname) {
		driver.findElement(By.xpath("//button[@type='button']/ancestor::div[@id='navbar']")).click();
		driver.findElement(By.xpath("//input[@id='searchText']")).click();
		driver.findElement(By.xpath("//*[@id=\"advanced-search-fields-group\"]/li[2]/a/text()[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"searchText\"]")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id=\"search-results\"]")).click();
	}

	public void deletecontact() {
		driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("")).click();

	}
}
package com.AgileCrmAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyPage extends BaseClass {

	By addCompanyButton = By
			.xpath("//button[@class='btn btn-default btn-primary-imp btn-lg-imp btn-sm btn-addon pull-left m-r-sm ']");
	By companyName = By.xpath("//input[@id='company_name']");
	By saveCompany = By.xpath("//a[@id='company_validate']");

	@FindBy(xpath = "//button[text()='delete']")
	public WebElement deleteButton;

	@FindBy(xpath = "//span[@id='cpmpanies-list-view-checkbox']//input")
	public WebElement selectAllCheckbox;

	@FindBy(xpath = "/span[@id='cpmpanies-list-view-checkbox']//input")
	public List<WebElement> AllCheckbox;

	public CompanyPage() {
		// initializing the factory page elements of current page
		PageFactory.initElements(driver, this);
	}

	public void deleteCompany() {
		selectAllCheckbox.click();
		deleteButton.click();

	}

	public void addCompany() {
		WebElement addCompanyButton = driver.findElement(this.addCompanyButton);
		Actions action = new Actions(driver);
		action.click(addCompanyButton).build().perform();
	}
}
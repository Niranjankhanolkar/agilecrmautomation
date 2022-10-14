package com.AgileCrmAutomationtest;

import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;
import com.AgileCrmAutomation.ContactPage;
import com.AgileCrmAutomation.LoginPage;

public class AddContact extends BaseClass {
	@Test
	public void addContact_module() {
		launchbrowser("browser");
		driver.navigate().to("https://learnautomation.agilecrm.com/");
		LoginPage.login("automation@yopmail.com", "Test1234");

		// ContactPage contact=new ContactPage();
		// contact.addcontact("Niranjan","Khanolkar");

		ContactPage addcontact = new ContactPage();
		addcontact.addcontact();
	}
}

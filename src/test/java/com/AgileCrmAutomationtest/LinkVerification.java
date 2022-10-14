package com.AgileCrmAutomationtest;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class LinkVerification extends BaseClass {
	@Test
	public void url_Verification() {
		launchbrowser("Chrome");
//Launching website
		driver.navigate().to("https://www.amazon.in/");
		// Get list of web-elements with tagName - a
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		// Traversing through the list and printing its text along with link address
		for (WebElement e : elements) {
			String link = e.getAttribute("href");
			if (link != null && link.startsWith("http")) {
				URL url;
				try {
					url = new URL(link);
					URLConnection urlconnection = url.openConnection();
					HttpsURLConnection connection = (HttpsURLConnection) urlconnection;
					connection.connect();
					int statusCode = connection.getResponseCode();
					if (statusCode != 200) {
						System.out.println(statusCode + "Url:" + link);
					}
					connection.disconnect();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}

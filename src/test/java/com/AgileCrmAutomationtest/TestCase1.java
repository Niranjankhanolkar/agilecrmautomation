package com.AgileCrmAutomationtest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

import junit.framework.Assert;

public class TestCase1 extends BaseClass {
	@BeforeTest
	public void beforetest() {
		System.out.println("This is before Test method");
		launchbrowser("Chrome");
		driver.get("http://google.com");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is before method");
	}

	@Test
	public void Test1() {
		System.out.println("This is before Test1");
	}

	@Test
	public void Test2() {

		System.out.println("This is before Test2");
		System.out.println(driver.getTitle());
		Assert.fail("Test2 fail");
	}

	@Test(dependsOnMethods = "Test2")
	public void Test3() {
		System.out.println("This is before Test3");
	}
}

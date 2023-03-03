package com.selenium.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.selenium.pages.CustomerForm;
import com.selenium.pages.DisplayCustomer;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;

public class TestDisplayCustomer extends DriverSetup { // Do not change the
														// class name

	public static String titletxt;
	public static String customerNametxt;
	public static String agetxt;
	public static String addresstxt;
	public static String numbertxt;
	public static String emailtxt;

	// Implement code here

	WebDriver driver;

	CustomerForm customerForm;
	DisplayCustomer displayCustomer;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		customerForm = PageFactory.initElements(driver, CustomerForm.class);
		displayCustomer = PageFactory.initElements(driver, DisplayCustomer.class);
	}

	@Test(dataProvider = "customerValid")
	public void testInvalidCustomerDetails(String testcasename, String name, String age, String address,
			String phoneNumber, String email) {
		customerForm.setCustomerName(name);
		customerForm.setAge(age);
		customerForm.setAddress(address);
		customerForm.setPhoneNumber(phoneNumber);
		customerForm.setEmail(email);
		customerForm.submitForm();
		titletxt = displayCustomer.getTitle();
		customerNametxt = displayCustomer.getName();
		agetxt = displayCustomer.getAge();
		addresstxt = displayCustomer.getAddress();
		numbertxt = displayCustomer.getPhoneNumber();
		emailtxt = displayCustomer.getEmail();

		assertEquals(titletxt, "Registered Succesfully");
		assertEquals(customerNametxt.split(" ")[0], name);
		assertEquals(agetxt, age);
		assertEquals(addresstxt, address);
		assertEquals(numbertxt, phoneNumber);
		assertEquals(emailtxt, email);

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@DataProvider(name = "customerValid")
	public Object[][] getExcelData() throws IOException, InvalidFormatException {
		return ExcelUtils.readExcelData("customer_valid");
	}

}

package com.selenium.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.CustomerForm;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;

public class TestCustomerForm extends DriverSetup { // Do not change the class
													// name

	public static String blankErrtxt;
	// Implement code here
	WebDriver driver;

	CustomerForm customerForm;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		customerForm = PageFactory.initElements(driver, CustomerForm.class);
	}

	@Test(dataProvider = "customerInvalid")
	public void testInvalidCustomerDetails(String testcasename, String name, String age, String address,
			String phoneNumber, String email) {

		customerForm.setCustomerName(name);
		customerForm.setAge(age);
		customerForm.setAddress(address);
		customerForm.setPhoneNumber(phoneNumber);
		customerForm.setEmail(email);
		customerForm.submitForm();
		blankErrtxt = customerForm.getErrorMessage();
		assertEquals("phoneNumber cannot be blank", blankErrtxt);

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();

	}

	@DataProvider(name = "customerInvalid")
	public Object[][] getExcelData() throws IOException, InvalidFormatException {
		return ExcelUtils.readExcelData("customer_invalid");
	}

}

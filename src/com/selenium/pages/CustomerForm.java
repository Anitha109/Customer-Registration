package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerForm { // Do not change the class name

	WebDriver driver;
	// Declare required variables
	
	@FindBy(xpath = "//h2")
	private WebElement title;
	
	@FindBy(xpath = "//input[@name = 'cname']")
	private WebElement custName;

	@FindBy(xpath = "//input[@name = 'age']")
	private WebElement custAge;

	@FindBy(xpath = "//input[@name = 'address']")
	private WebElement custAddress;

	@FindBy(xpath = "//input[@name = 'phonenumber']")
	private WebElement custNumber;

	@FindBy(xpath = "//input[@name = 'email']")
	private WebElement custEmail;

	@FindBy(id = "submit")
	private WebElement submit;

	@FindBy(id = "message")
	private WebElement errorMessage;

	public CustomerForm(WebDriver driver) {
		this.driver = driver;
	}
	// Implement code here
	
	public String getTitle(){
		return title.getText();
	}

	public void setCustomerName(String cName) {
		custName.sendKeys(cName);
	}

	public void setAge(String age) {
		custAge.sendKeys(age);
	}

	public void setAddress(String address) {
		custAddress.sendKeys(address);
	}

	public void setPhoneNumber(String phoneNumber) {
		custNumber.sendKeys(phoneNumber);
	}

	public void setEmail(String email) {
		custEmail.sendKeys(email);
	}

	public void submitForm() {
		submit.click();
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}
}

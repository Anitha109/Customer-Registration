package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DisplayCustomer { // Do not change the class name

	WebDriver driver;
	// Declare required variables
	@FindBy(xpath = "//h2")
	private WebElement title;

	@FindBy(xpath = "//table//td[text() = 'Name']/following-sibling::td")
	private WebElement name;

	@FindBy(xpath = "//table//td[text() = 'Age']/following-sibling::td")
	private WebElement age;

	@FindBy(xpath = "//table//td[text() = 'Address']/following-sibling::td")
	private WebElement address;

	@FindBy(xpath = "//table//td[text() = 'Phone number']/following-sibling::td")
	private WebElement phoneNumber;

	@FindBy(xpath = "//table//td[text() = 'Email']/following-sibling::td")
	private WebElement email;

	public DisplayCustomer(WebDriver driver) {
		this.driver = driver;
	}

	// Implement code here
	public String getTitle() {
		return title.getText();
	}

	public String getName() {
		return name.getText();
	}

	public String getAge() {
		return age.getText();
	}

	public String getEmail() {
		return email.getText();
	}

	public String getAddress() {
		return address.getText();
	}

	public String getPhoneNumber() {
		return phoneNumber.getText();
	}
}

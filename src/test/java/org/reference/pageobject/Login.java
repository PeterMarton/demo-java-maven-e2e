package org.reference.pageobject;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.reference.pageobject.tabs.mystart.User;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.page;

public class Login {

	private SelenideElement accountNameField = $(By.id("user"));
	private SelenideElement passwordField = $(By.id("password"));
	private SelenideElement loginButton = $(By.className("login_button"));

	public User login(String userName, String password) {
		accountNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginButton.click();
		return page(User.class);
	}
}

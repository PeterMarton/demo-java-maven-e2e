package org.reference.pageobject.tabs.project;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class Browse {

	private final SelenideElement newProjectIcon = $(By.cssSelector("[title='New Project']"));

	public Create clickNewProjectIcon() {
		newProjectIcon.click();
		return page(Create.class);
	}
	
	public SelenideElement getNewProjectIcon() {
		return newProjectIcon;
	}
}

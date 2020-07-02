package org.reference.pageobject.tabs.project;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class Project {

	private final SelenideElement newProjectRadio = $(By.cssSelector("[title='New Child Page']"));
	private final SelenideElement templateNameField = $(By.id("name"));
	private final SelenideElement saveButton = $(By.name("actionMethod"));
	private final SelenideElement title = $(By.className("breadcrumbs-summary"));

	
	public Project createChildPage(String childPageName) {
		newProjectRadio.click();
		switchTo().frame("inlinedPopupIframe");
		templateNameField.sendKeys(childPageName);
		saveButton.click();
		switchTo().window(0);

		return this;
	}
	
	public SelenideElement getTitle() {
		return this.title;
	}
	
}

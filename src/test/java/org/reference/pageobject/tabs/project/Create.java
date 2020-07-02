package org.reference.pageobject.tabs.project;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.page;
import com.codeborne.selenide.SelenideElement;

public class Create {

	private final SelenideElement newProjectRadio = $(By.id("newProject"));
	private final SelenideElement fileUpload = $(By.name("file"));
	private final SelenideElement nextButton = $(By.name("_eventId_submit"));
	private final SelenideElement templateNameField = $(By.name("name"));
	private final SelenideElement finsihButton = $(By.id("finishButton"));
	private final SelenideElement wikiProjectTitle = $(By.id("breadcrumbs"));

	public Create selectNewProject() {
		newProjectRadio.click();
		return page(Create.class);
	}

	public Create uploadFile(String file) {
		fileUpload.uploadFromClasspath(file);
		return this;
	}

	public Create clickNext() {
		nextButton.click();
		return this;
	}


	public Create clickFinish() {
		finsihButton.click();
		return this;
	}

	public SelenideElement getTemplateNameField() {
		return templateNameField;
	}
	
	public SelenideElement getWikiProjectTitle() {
		return wikiProjectTitle;
	}

}

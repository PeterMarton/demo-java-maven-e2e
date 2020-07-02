package org.reference.pageobject.tabs.mystart;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.reference.pageobject.tabs.project.Browse;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.page;

public class User {

	private SelenideElement projectTab = $(By.id("project_browser_ToolBarItem"));

	public Browse selectProjectTab() {
		projectTab.click();
		return page(Browse.class);
	}
}

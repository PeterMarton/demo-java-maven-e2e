package org.reference.tests.create;

import static com.codeborne.selenide.Condition.text;
import java.io.IOException;
import org.reference.annotation.TestDataSource;
import org.reference.model.LoginModel;
import org.reference.model.ParentProjectModel;
import org.reference.pageobject.tabs.mystart.User;
import org.reference.pageobject.tabs.project.Browse;
import org.reference.pageobject.tabs.project.Create;
import org.reference.pageobject.tabs.project.Project;
import org.reference.tests.BaseTestClass;
import org.reference.util.Conditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.codeborne.selenide.conditions.Visible;

@TestDataSource(fileName = "ParentDoc.json")
public class ParentProjectTest extends BaseTestClass {

  private final static Logger logger = LoggerFactory.getLogger(ParentProjectTest.class);

  private ParentProjectModel projectModel;
  private LoginModel loginModel;

  private Browse browse;
  private Create create;
  private User userPage;

  private String fileName;
  private String methodName;

  @BeforeMethod
  public void beforeMethod(ITestResult result) {
    methodName = result.getMethod().getMethodName();
  }

  @Test
  public void basicFileUpload() throws IOException {

    projectModel = getDataFile(methodName, ParentProjectModel.class);
    loginModel = projectModel.getCredentials();
    logger.debug("Login information (userName / password: " + loginModel);

    logger.info("Log into the app");
    userPage = this.login(loginModel);

    browse = userPage.selectProjectTab();
    browse.getNewProjectIcon().shouldBe(Conditions.CLICKABLE);
    logger.info("Creating new project");

    this.fileName = projectModel.getFileName();
    create = browse.clickNewProjectIcon();
    create.selectNewProject();
    create.uploadFile(fileName);
    create.clickNext();
    create.getTemplateNameField().shouldBe(Visible.visible);
    String templateName = create.getTemplateNameField().getText();

    logger.info("Verifying if the project created successfully");
    create.clickFinish().getWikiProjectTitle().shouldHave(text(templateName));
  }

  @Test(dependsOnMethods = {"basicFileUpload"})
  public void createChildWikiPage() throws IOException {
    projectModel = getDataFile(methodName, ParentProjectModel.class);
    logger.info("Creating child page to the parent project");

    String childPageName = projectModel.getChildPageName();

    Project project = new Project();
    logger.info("Verifying if the page created successfully");
    project.createChildPage(childPageName).getTitle().shouldHave(text(childPageName));

  }

}

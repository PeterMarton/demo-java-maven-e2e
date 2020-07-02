package org.reference.tests;

import static com.codeborne.selenide.Selenide.open;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.reference.annotation.TestDataSource;
import org.reference.config.AppConfig;
import org.reference.model.LoginModel;
import org.reference.pageobject.Login;
import org.reference.pageobject.tabs.mystart.User;
import org.reference.util.FileUtil;
import org.reference.util.StringUtil;
import org.testng.annotations.BeforeClass;

import com.codeborne.selenide.Configuration;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTestClass {

	protected AppConfig configuration;
	protected Login loginPage;

	protected JsonNode jsonNode;
	protected String userName;
	protected String password;

	@BeforeClass
	public void beforeClass() {

		configuration = new AppConfig(new Properties());
		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.addArguments("incognito");
		Configuration.browserCapabilities = new DesiredCapabilities();
		Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		loginPage = open(configuration.getUrl(), Login.class);

	}

	protected <T> T getDataFile(String methodName, Class<T> clazz) throws IOException {
		JsonNode jsonNode = FileUtil.getJsonByMethodname(this.content(), methodName);
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(jsonNode.toString(), clazz);

	}

	protected User login(LoginModel loginModel) {
		this.userName = loginModel.getUserName();
		this.password = loginModel.getPassword();
		return loginPage.login(userName, password);
	}

	protected String content() throws IOException {
		String annotatedSourceFile = null;
		if (this.getClass().getAnnotation(TestDataSource.class) != null) {
			annotatedSourceFile = this.getClass().getAnnotation(TestDataSource.class).fileName();
		}
		String defaultSourceFile = this.getClass().getSimpleName() + StringUtil.JSON_FILE_SUFFIX;
		String sourceFile = annotatedSourceFile == null ? defaultSourceFile : annotatedSourceFile;
		return FileUtil.getFileContentAsString(sourceFile);
	}

}

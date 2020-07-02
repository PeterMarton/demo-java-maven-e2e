package org.reference.model;

public class ParentProjectModel {

	private LoginModel credentials;
	private String fileName;
	private String childPageName;

	public LoginModel getCredentials() {
		return credentials;
	}

	public void setCredentials(LoginModel credentials) {
		this.credentials = credentials;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getChildPageName() {
		return childPageName;
	}

	public void setChildPageName(String childPageName) {
		this.childPageName = childPageName;
	}

}

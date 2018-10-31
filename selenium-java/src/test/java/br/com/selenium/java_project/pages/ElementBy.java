package br.com.selenium.java_project.pages;

import org.openqa.selenium.By;

public abstract class ElementBy extends By {
	
	public static By dataAttribute(String data) {
		return By.cssSelector("[data-test='" + data + "']");
	}
}
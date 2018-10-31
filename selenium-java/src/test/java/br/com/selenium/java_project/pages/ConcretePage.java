package br.com.selenium.java_project.pages;

import org.openqa.selenium.By;
import br.com.selenium.java_project.utils.HandleProperties;
import br.com.selenium.java_project.utils.Page;

public class ConcretePage extends Page {

	private static final By INPUT_SEARCH = By.cssSelector("input[placeholder='faça sua busca...']");
	private static final By BUTTON_SEARCH = By.cssSelector("span[class='icon-search']");

	public void visit(String url) {
		String urlConcrete = System.getProperty("urlConcrete") != null ? System.getProperty("urlConcrete")
				: HandleProperties.getValue("url_concrete");
		openUrl(urlConcrete);
		isUrlContainsValue(url);
	}

	public void fillIn(String text) {
		isElementAttachedToHtml(INPUT_SEARCH);
		fillInput(text, INPUT_SEARCH);
		click(BUTTON_SEARCH);
	}

	public boolean verifySearch(String message) {
		By MESSAGE = By.xpath("//div[@class='_byCx']//h3//div[contains(.,'" + message + "')]");
		isElementAttachedToHtml(MESSAGE);
		return getTextFromLabel(MESSAGE).equals(message);
	}
}

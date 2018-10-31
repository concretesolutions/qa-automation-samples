package br.com.selenium.java_project.utils;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import br.com.selenium.java_project.enums.Browsers;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Page {

	private static final long DEFAULT_TIME_WAIT = 10;

	public Page() {
		if (Browsers.webDriver == null) {
			Browsers.setWebDriver();
		}
	}

	public static WebDriver getDriver() {
		return Browsers.webDriver;
	}

	protected void openUrl(String url) {
		getDriver().get(url);
	}

	protected String getUrl() {
		return getDriver().getCurrentUrl();
	}

	protected boolean isUrlContainsValue(String text) {
		return getUrl().contains(text);
	}

	protected WebElement waitElement(By locator) {
		return new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	protected List<WebElement> waitElements(By locator) {
		return new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	protected boolean isVisible(By locator) {
		new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
				.until(ExpectedConditions.visibilityOf(getElement(locator)));
		return getElement(locator).isDisplayed();
	}

	protected void isNotVisible(By locator) {
		new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
				.until(ExpectedConditions.invisibilityOf(getElement(locator)));
	}

	protected boolean isClickable(By locator) {
		new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
				.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
		return getElement(locator).isDisplayed() && getElement(locator).isEnabled();
	}

	protected void waitForTextInElement(By locator, String textToBeWait) {
		new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
				.until(ExpectedConditions.textToBe(locator, textToBeWait));
	}

	protected void waitForTextPresentInElement(By locator, String textToBeWait) {
		new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
				.until(ExpectedConditions.textToBePresentInElement(getElement(locator), textToBeWait));
	}

	protected void waitForElementToBeSelected(By locator) {
		new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
				.until(ExpectedConditions.elementToBeSelected(getElement(locator)));
	}

	protected void waitElementInvisible(By locator) {
		new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
				.until(ExpectedConditions.invisibilityOfElementLocated((locator)));
	}

	protected WebElement getElement(By locator) {
		return waitElement(locator);
	}

	protected List<WebElement> getElements(By locator) {
		return waitElements(locator);
	}

	protected void clickOn(By locator) {
		isVisible(locator);
		new Actions(getDriver()).moveToElement(getElement(locator)).perform();
		getElement(locator).click();
	}

	protected void fillInput(String dados, By locator) {
		isVisible(locator);
		getElement(locator).clear();
		this.waitForTextInElement(locator, "");
		getElement(locator).sendKeys(dados);
	}

	protected void click(By locator) {
		isClickable(locator);
		getElement(locator).click();
	}

	protected void check(By locator) {
		if (!getElement(locator).isSelected()) {
			click(locator);
			waitForChecked(locator);
		}
	}

	protected void unCheck(By locator) {
		if (getElement(locator).isSelected()) {
			click(locator);
			waitForNotChecked(locator);
		}
	}

	protected boolean waitForChecked(By locator) {
		return getElement(locator).isSelected();
	}

	protected boolean waitForNotChecked(By locator) {
		return !getElement(locator).isSelected();
	}

	protected boolean isVisibleOnMouse(By locator) {
		isVisible(locator);
		new Actions(getDriver()).moveToElement(getElement(locator)).perform();
		return getElement(locator).isDisplayed();
	}

	protected String getTextFromLabel(By locator) {
		return getElement(locator).getText().trim();
	}

	protected String getTextOfVisibleElement(WebElement element) {
		String text = null;
		try {
			text = element.getText().trim();
		} catch (Exception e) {
			System.out.println(element + " : " + e);
		}
		return text;
	}

	protected boolean isElementAttachedToHtml(By locator) {
		try {
			waitElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected void pressTab(By locator) {
		isVisible(locator);
		getElement(locator).sendKeys(Keys.TAB);
	}

	protected void pressEnter(By locator) {
		isVisible(locator);
		getElement(locator).sendKeys(Keys.ENTER);
	}
}
package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to selenium tool
 * @author kavya
 *
 */

public class SeleniumUtility {
	/**
	 * This method will maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize window
	 * @param driver
	 */
	
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add 10 seconds of implicitly wait
	 * @param driver
	 */
	public void addImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for element to be visible
	 * @param driver
	 */
	public void waitForElementToBeVisible (WebDriver driver, WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	/**
	 * This method will wait for 10 seconds for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable (WebDriver driver, WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.elementToBeClickable(element));
}
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by visible text
	 * @param element
	 * @param visibleText
	 */
	public void handleDropdown(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	
	public void handleDropdown(String value, WebElement element) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will perform the click and hold action
	 * @param driver
	 * @param element
	 */
	//click and hold, drag and drop, right click, mouse hover, scroll, doubleclick
	public void clickAndHoldAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	/**
	 * This method will perform the mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform the double click action
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform right click action
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform scroll action
	 * @param driver
	 * @param element
	 */
	public void scrollToElementAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param element
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement tarElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, tarElement).perform();
	}
	
	/**
	 * This method will handle Frame by Index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method will handle Frame by name or ID
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, String framenameOrID) {
		driver.switchTo().frame(framenameOrID);
	}
	
	/**
	 * This method will handle Frame by webelement
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will enter data to the alert popup
	 * @param driver
	 */
	public void enterAlertText(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will capture text the alert popup
	 * @param driver
	 */
	public void getAlertText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will switch from one window to another
	 * @param driver
	 * @param windowID
	 */
	public void handleWindow(WebDriver driver, String windowID) {
		driver.switchTo().window(windowID);
	}
	
	/**
	 * This method will capture screenshot and return the path to caller
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenshotName+".png");
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath();  //for extent report
		}
}


package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility{ //Rule 1
	
	//Rule 2
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	private WebElement sortDropDown;
		
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartContainerBtn;
		
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutLink;
	
	//Rule 3 - Initialization
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Rule 4 - Utilization
	
	public WebElement getSortDropDown() {
		return sortDropDown;
	}


	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}


	public WebElement getMenuBtn() {
		return menuBtn;
	}


	public WebElement getLogoutLink() {
		return logoutLink;
	}

	//Rule 5 - Business Library - Optimizing - generic methods
	/**
	 * This method will click on dynamic product
	 * @param driver
	 * @param productName
	 */
	public void ClickOnAProduct(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//div[.='" + productName + "']")).click();
	}
	
	/**
	 * This method will click on cart container button
	 */
	public void clickOnCartContainer() {
		cartContainerBtn.click();
	}
	
	/**
	 * This method will logout of application
	 */
	public void logoutOfApp() {
		menuBtn.click();
		logoutLink.click();
	}
	
	public void clickOnLowestPriceProduct(WebDriver driver, String sortOption, String productName) {
		handleDropdown(sortDropDown, sortOption);
		driver.findElement(By.xpath("//div[.='"+productName+"']")).click();
	}
}


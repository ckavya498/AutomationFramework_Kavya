package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private WebElement itemInfo;
	
	@FindBy(id = "remove-sauce-labs-backpack")
	private WebElement removeBtn;
	
	//initialization
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getRemoveBtn() {
		return removeBtn;
	}

	public WebElement getProductName() {
		return itemInfo;
	}

	//business library
    
	/**
	 * This method will capture the product name and return to caller
	 * @return
	 */
	public String captureItemName() {
		return itemInfo.getText();
	}
	
	/**
	 * This method will click on remove button
	 */
	public void clickOnRemoveBtn() {
		removeBtn.click();
	}
}

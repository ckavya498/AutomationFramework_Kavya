package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvertoryItemPage {
	
	@FindBy(id = "add-to-cart")
	private WebElement addTocartBtn;
		
	//Initialization
	public InvertoryItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	//utilization
	public WebElement getAddToCart() {
		return addTocartBtn;
	}
	
	//Business library
	/**
	 * This method will click on add to cart button
	 */
	public void clickOnAddToCartBtn() {
		addTocartBtn.click();
	}
	

}

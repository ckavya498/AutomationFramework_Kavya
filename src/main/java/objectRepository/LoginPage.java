package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1
	
	//Rule2 - Declaration
	
	//@FindAll - 
	
	@FindBy(id = "user-name") 
	private WebElement usernameText;
	
	@FindBy(id = "password")
	private WebElement passwordText;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	//Rule 3 - Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4 - Utilization
	public WebElement getUsernameText() {
		return usernameText;
	}

	public WebElement getPasswordText() {
		return passwordText;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
		
	}
	//Rule 5 - Business Library - Optimizing - generic methods
		
	public void loginToApp(String un, String pwd) 
	{
		usernameText.sendKeys(un);
		passwordText.sendKeys(pwd);
		loginBtn.click();
		}
}


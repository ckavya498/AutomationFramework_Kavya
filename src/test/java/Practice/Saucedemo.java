package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Saucedemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        //adding the product to cart(multiple products)
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
        //verifying whether products are added in cart
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        //moving back from the cart and again continuing with the shopping
        driver.findElement(By.id("continue-shopping")).click();
        //adding the more product to cart
        driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
       //verifying whether products are added in cart
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        //removing product from the cart
        driver.findElement(By.name("remove-sauce-labs-bike-light")).click();
        //checking out from the cart
        driver.findElement(By.id("checkout")).click();
        //Canceling the order
        driver.findElement(By.id("cancel")).click();
        //logout the application
        driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}

}


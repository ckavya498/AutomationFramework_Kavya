package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCart {

	public static void main(String[] args) throws IOException {
		
		//read common data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//read data from excel file
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Products");
		Row rw = sh.getRow(1);
		Cell c1 = rw.getCell(2);
		String PRODUCTNAME = c1.getStringCellValue(); //run the data
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//load url
		driver.get(URL);
		//Login to application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.name("login-button")).click();
        
        //click on a product - dynamic data
        WebElement ele = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")); //appending operator
        String productname = ele.getText();
        ele.click();
        //click on add to cart
        driver.findElement(By.id("add-to-cart")).click();
        //navigate to cart
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        //validate the product in cart
        String productIncart = driver.findElement(By.className("inventory_item_name")).getText();
        if(productIncart.equals(productname)) {
        	System.out.println("Pass");
        	System.out.println(productIncart);
        } else {
        	System.out.println("Fail");
        }
        //logout the application
        driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        driver.close();
	}

}


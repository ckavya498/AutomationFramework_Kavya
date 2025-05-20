package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class BaseClass {

	/**
	 * This class consists of Basic configuration annotations of TestNG
	 * @author kavya
	 * @throws IOException
	 */
		
		FileUtility fUtil = new FileUtility();
		protected ExcelUtility eUtil = new ExcelUtility();
		JavaUtility jUtil = new JavaUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		public WebDriver driver;
		
		//independent driver for Listeners
		public static WebDriver sdriver;
		
		@BeforeSuite(alwaysRun = true)
		public void bsConfig() {
			System.out.println("Database connection successful");		
		}
		
		//@BeforeTest   //while running distributed parallel execution
		@BeforeClass(alwaysRun = true)
		public void bcConfig() throws IOException {
		
		
		//for cross browser execution
		
		//@Parameters("browser")
		//@BeforeTest
		//public void bcConfig(String PValue) throws IOException {
			String URL = fUtil.readDataFromPropertyfile("url");	
			
			driver = new FirefoxDriver();
			
			
			//for cross browser execution - "Run time polymorphism - driver"
			
//			if(PValue.equals("edge")) {
//				driver = new EdgeDriver();
//			}
//			else if(PValue.equals("firefox")) {
//				driver = new FirefoxDriver();
//			}
//			
//			else {
//				driver = new ChromeDriver();
//			}
			sUtil.maximizeWindow(driver);
			sUtil.addImplicitWait(driver);
			
			driver.get(URL);
			
			//for Listeners
			sdriver = driver;
			
			System.out.println("Browser Launch successful");
		}
		
		@BeforeMethod(alwaysRun = true)
		public void bmConfig() throws IOException {
			String USERNAME = fUtil.readDataFromPropertyfile("username");
			String PASSWORD = fUtil.readDataFromPropertyfile("password");
			
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			System.out.println("Login to app successful");
		}
		
		@AfterMethod(alwaysRun = true)
		public void amConfig() {
			InventoryPage ip = new InventoryPage(driver);
			ip.logoutOfApp();
			
			System.out.println("Logout of app successful");
		}
		
		@AfterClass  //while running distributed parallel execution
		//@AfterClass(alwaysRun = true)
		public void acConfig() {
			driver.quit();
			
			System.out.println("Browser closure successful");
		}
		
		@AfterSuite(alwaysRun = true)
		public void asConfig() {
			System.out.println("Database closure successful");
		}
	}



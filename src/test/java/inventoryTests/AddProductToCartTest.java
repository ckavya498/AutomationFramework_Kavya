package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryPage;
import objectRepository.InvertoryItemPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class AddProductToCartTest extends BaseClass{
	
	@Test(groups = "SmokeSuite")
	public void TC_01_AddProductToCartTest() throws IOException {

		// Read Data from excel file
		String PRODUCTNAME = eUtil.readDataFromExcel("Products", 1, 2); // Run time data

		//click on a product
        InventoryPage ip = new InventoryPage(driver);
        ip.ClickOnAProduct(driver, PRODUCTNAME);
        
        //click on add to cart
        InvertoryItemPage iip = new InvertoryItemPage(driver);
        iip.clickOnAddToCartBtn();
        
        //navigate to cart
        ip.clickOnCartContainer();
        
        //validate the product in cart
        CartPage cp = new CartPage(driver);
        String ProductInCart = cp.captureItemName();
//        if(ProductInCart.equals(PRODUCTNAME)) {
//        	System.out.println("PASS");
//        	System.out.println(ProductInCart);
//        }else {
//        	System.out.println("FAIL");
//        }
        
        Assert.assertEquals(ProductInCart, PRODUCTNAME);
        
        Assert.assertTrue(ProductInCart.equals(PRODUCTNAME));
        
	}
        @Test
        public void sampleTest() {
        	
        	//Assert.fail();
        	System.out.println("Sample");
   
	}
	}


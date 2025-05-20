package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryPage;
import objectRepository.InvertoryItemPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class AddLowestPriceProductToCartTest extends BaseClass{
	
	@Test(groups = "RegressionSuite")
	public void tc_02_addLowestPriceProductToCartTest() throws IOException {

		// Read Data from excel file
		String PRODUCTNAME = eUtil.readDataFromExcel("Products", 4, 3); // Run time data
		String SORTOPTION = eUtil.readDataFromExcel("Products", 4, 2);

		// Click on a product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnLowestPriceProduct(driver, SORTOPTION, PRODUCTNAME);

		// Click on add to cart
		InvertoryItemPage iip = new InvertoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Navigate to Cart
		ip.clickOnCartContainer();

		// Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String ProductIncart = cp.captureItemName();
//		if (ProductIncart.equals(PRODUCTNAME)) {
//			System.out.println("PASS");
//			System.out.println(ProductIncart);
//		} else {
//			System.out.println("FAIL");
//		}
		
		Assert.assertEquals(ProductIncart, PRODUCTNAME);
		
		Assert.assertTrue(ProductIncart.equals(PRODUCTNAME));

	}


}


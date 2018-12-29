package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;

public class CheckCart {
	public String productTitle;
	boolean assertsEnabled = false;
	@Test
	public void checkCard() {
		productTitle = Wdriver.driver.findElement(By.cssSelector("#productTitle")).getText();
		addProductToCart();
		Wdriver.driver.findElement(By.cssSelector("#nav-cart")).click();
		Assert.assertEquals(Wdriver.driver.getTitle(), "Amazon.com Shopping Cart");
	}

	@Test
	public void checkIfExcist() {
		makeListOfProducts();
	}

	public void addProductToCart() {
		Wdriver.driver.findElement(By.cssSelector("#add-to-cart-button-ubb")).click();
	}

	public void makeListOfProducts() {
		int i;
		boolean found = false;
		for(i=1; i<=10;i++) {
			By allProducts = By.xpath("/html/body/div[1]/div[4]/div[1]/div[4]/div/div[2]/div[4]/form/div[2]/div["+i+"]/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span\n");
			List<WebElement> myElements = Wdriver.driver.findElements(allProducts);
			for (WebElement e : myElements) {
				System.out.println(e.getText());
				if(e.getText() == productTitle){
					Assert.assertTrue(found);
				}
			}
			Assert.assertEquals(found, true);
		}
	}
}

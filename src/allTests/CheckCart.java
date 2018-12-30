package allTests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckCart {
	public String productTitle;
	boolean assertsEnabled = false;

	@Test(priority = 1)
	public void checkCard() {
		productTitle = Wdriver.driver.findElement(By.cssSelector("#productTitle")).getText();
		addProductToCart();
		Wdriver.driver.findElement(By.cssSelector("#nav-cart")).click();
		Assert.assertEquals(Wdriver.driver.getTitle(), "Amazon.com Shopping Cart");
	}

	@Test(priority = 2)
	public void checkIfExcist() {
		makeListOfProducts();
	}

	public void addProductToCart() {
		Wdriver.driver.findElement(By.cssSelector("#add-to-cart-button")).click();
	}

	public void makeListOfProducts() {
		int i;
		for (i = 1; i <= 10; i++) {
			By allProducts = By.xpath("/html/body/div[1]/div[4]/div[1]/div[4]/div/div[2]/div[4]/form/div[2]/div[" + i
					+ "]/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span\n");
			List<WebElement> myElements = Wdriver.driver.findElements(allProducts);
			for (WebElement e : myElements) {
				boolean match = new String(e.getText()).equals(productTitle);
				if (match)
					Assert.assertEquals(match, true);
			}
		}
	}
}

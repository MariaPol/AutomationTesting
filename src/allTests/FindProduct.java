package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindProduct {

	@Test(priority = 1)
	public void searchProduct() {
		Wdriver.driver.get(Wdriver.appUrl);
		Wdriver.driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("samsung galaxy s8 orchid gray");
		Wdriver.driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
		Assert.assertEquals(Wdriver.driver.getTitle(), "Amazon.com: samsung galaxy s8 orchid gray");
	}

	@Test(priority = 2)
	public void goToProductPage() {
		JavascriptExecutor jse = (JavascriptExecutor) Wdriver.driver;
		jse.executeScript("scroll(0, 500);");
		String productTitle = Wdriver.driver.findElement(By.cssSelector(
				"#result_4 > div > div > div > div.a-fixed-left-grid-col.a-col-right > div.a-row.a-spacing-small > div:nth-child(1) > a > h2"))
				.getText();
		Wdriver.driver.findElement(By.xpath("//*[@id=\"result_4\"]/div/div/div/div[2]/div[1]/div[1]/a")).click();
		String expectedProductTitle = Wdriver.driver.findElement(By.cssSelector("#productTitle")).getText();
		Assert.assertEquals(productTitle, expectedProductTitle);
	}

}

package allTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignIn {

	@Test(priority = 1)
	public void goToSignIn() {
		Wdriver.driver.get(Wdriver.appUrl);
		Wdriver.driver.findElement(By.cssSelector("#nav-link-accountList")).click();
		Assert.assertEquals(Wdriver.driver.getTitle(), "Amazon Sign In");
	}

	@Test(priority = 2)
	public void submitSignIn() {
		Wdriver.driver.findElement(By.cssSelector("#ap_email")).sendKeys("test@531351.com");
		Wdriver.driver.findElement(By.cssSelector("#ap_password")).sendKeys("123456");
		Wdriver.driver.findElement(By.cssSelector("#signInSubmit")).click();
		Wdriver.driver.findElement(By.cssSelector("#nav-link-accountList")).click();
		Assert.assertEquals(Wdriver.driver.getTitle(), "Your Account");
	}

}

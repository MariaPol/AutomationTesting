package allTests;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignUp {
	@Test(priority = 0)
	public void goToHomePage() {
		Wdriver.driver.get(Wdriver.appUrl);
		Assert.assertEquals(Wdriver.driver.getTitle(),
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}

	@Test(priority = 1)
	public void gotoSignUp() {
		Wdriver.driver.findElement(By.cssSelector("#nav-link-accountList")).click();
		Wdriver.driver.findElement(By.cssSelector("#createAccountSubmit")).click();
		Assert.assertEquals(Wdriver.driver.getTitle(), "Amazon Registration");
		typeValues();
	}

	public void typeValues() {
		Wdriver.driver.findElement(By.cssSelector("#ap_customer_name")).sendKeys("username");
		Wdriver.driver.findElement(By.cssSelector("#ap_email")).sendKeys("email@sdasds.com");
		Wdriver.driver.findElement(By.cssSelector("#ap_password")).sendKeys("bfb#f5dBfd");
		Wdriver.driver.findElement(By.cssSelector("#ap_password_check")).sendKeys("bfb#f5dBfd");
	}

	@Test(priority = 2)
	public void checkIfIstNull() {
		Assert.assertEquals(
				Wdriver.driver.findElement(By.cssSelector("#ap_customer_name")).getAttribute("value").isEmpty(), false);
		Assert.assertEquals(Wdriver.driver.findElement(By.cssSelector("#ap_email")).getAttribute("value").isEmpty(),
				false);
		Assert.assertEquals(Wdriver.driver.findElement(By.cssSelector("#ap_password")).getAttribute("value").isEmpty(),
				false);
		Assert.assertEquals(
				Wdriver.driver.findElement(By.cssSelector("#ap_password_check")).getAttribute("value").isEmpty(),
				false);
	}

	@Test(priority = 3)
	public void checkEmail() {
		Assert.assertEquals(isValidEmailAddress(), true);
	}

	public static boolean isValidEmailAddress() {
		String email = Wdriver.driver.findElement(By.cssSelector("#ap_email")).getAttribute("value");
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	@Test(priority = 4)
	public void checkPassword6Len() {
		int pass = Wdriver.driver.findElement(By.cssSelector("#ap_password")).getAttribute("value").length();
		String result;
		if (pass >= 6) {
			result = ("true");
		} else
			result = ("false");
		Assert.assertEquals(result, "true");
	}

	@Test(priority = 4)
	public void checkPasswordNum() {
		String pass = Wdriver.driver.findElement(By.cssSelector("#ap_password")).getAttribute("value");
		boolean result = pass.matches(".*\\d+.*");

		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 4)
	public void checkPasswordSpChar() {
		String pass = Wdriver.driver.findElement(By.cssSelector("#ap_password")).getAttribute("value");
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
	    Matcher m = p.matcher(pass);
	    boolean result = m.find();
	    
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 4)
	public void checkPasswordUp() {
		String pass = Wdriver.driver.findElement(By.cssSelector("#ap_password")).getAttribute("value");
		boolean result = checkForUp(pass);
		Assert.assertEquals(result, true);
	}
	
	private static boolean checkForUp(String str) {
	    char ch;
	    boolean found = false;
	    for(int i=0;i < str.length();i++) {
	        ch = str.charAt(i);
	        if (Character.isUpperCase(ch)) {
	        	found = true;
	        }
	        if(found)
	            return true;
	    }
	    return false;
	}
	
	@Test(priority = 5)
	public void checkPasswordsMatch() {
		String pass = Wdriver.driver.findElement(By.cssSelector("#ap_password")).getAttribute("value");
		String repass = Wdriver.driver.findElement(By.cssSelector("#ap_password_check")).getAttribute("value");
		Assert.assertEquals(pass, repass);
	}

	@Test(priority = 6)
	public void signUp() {
		Wdriver.driver.findElement(By.cssSelector("#continue")).click();
		Assert.assertEquals(Wdriver.driver.getTitle(), "Please confirm your identity");
	}
}

package allTests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Test {

	@BeforeSuite
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", Wdriver.driverPath);
		Wdriver.driver.navigate();
	}

	@AfterSuite
	public void closeBrowser() {
		Wdriver.driver.close();
	}
}

package allTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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

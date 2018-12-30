package allTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public interface Wdriver {
	public WebDriver driver = new FirefoxDriver();
	public String driverPath = "C:\\geckodriver.exe";
	public String appUrl = "https://www.amazon.com";
}

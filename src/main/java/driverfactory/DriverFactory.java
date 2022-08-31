package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	//parallel exec
	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) throws Exception {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			tlDriver.set(new ChromeDriver());
		} else{

			throw new Exception("invalid browser parameter");
		}
		
		getDriver().manage().deleteAllCookies();
		
		getDriver().manage().window().maximize();		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
	
}

package hooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driverfactory.DriverFactory;
import utilities.Configreader;

public class ApplicationHooks {

	private DriverFactory driverFactory;

	private WebDriver driver;

	private Configreader configreader;

	Properties prop;

	@Before
	public void LaunchBrowser() throws Exception {
		configreader = new Configreader();
		prop = configreader.init_prop();
		String browser = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browser);
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "screenshot" + ".png");
		}
		driver.close();
	}

}

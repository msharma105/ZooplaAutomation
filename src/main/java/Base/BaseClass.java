package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.Timeout;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public static void loadProperties() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream("config.properties");
		prop.load(file);
	}

	public static WebDriver Initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("no browser available");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Timeout.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Timeout.Implicit_Wait, TimeUnit.SECONDS);

		return driver;

	}

}

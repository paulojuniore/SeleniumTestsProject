package core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import core.Properties.ExecutionType;

public class DriverFactory {
	
//	private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	private DriverFactory() { }
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
		if (Properties.EXECUTION_TYPE == ExecutionType.LOCAL) {
			switch (Properties.browser) {
				case FIREFOX: 
					driver = new FirefoxDriver(); 
					break;
				case CHROME: 
					System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver");
					driver = new ChromeDriver(); 
					break;
			}			
		}
		if (Properties.EXECUTION_TYPE == ExecutionType.GRID) {
			DesiredCapabilities cap = null;
			switch (Properties.browser) {
				case FIREFOX:
					cap = DesiredCapabilities.firefox();
					break;
				case CHROME:
					cap = DesiredCapabilities.chrome();
					break;
			}
			try {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver");
				driver = new RemoteWebDriver(new URL("http://172.17.0.1:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.err.println("Falha na conexão com o GRID.");
				e.printStackTrace();
			}
		}
		driver.manage().window().setSize(new Dimension(1200, 768));
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		if (threadDriver != null) {
			threadDriver.remove();
		}
	}

}

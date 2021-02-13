package core;

import static core.DriverFactory.getDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.LoginPage;

public class BaseTest {
	
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void setUp() {
		page.accessInitialScreen();
		
		page.setEmail("ficticio@anonimo");
		page.setPassword("12345");
		page.login();
	}
	
	@After
	public void finaliza() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) getDriver();
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("src" + File.separator + "main" + File.separator + "resources" + 
				File.separator + "screenshots" + File.separator + testName.getMethodName() + ".jpg"));
		
//		DriverFactory.killDriver();
	}

}

package suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import core.DriverFactory;
import pages.LoginPage;
import tests.AccountTest;
import tests.BalanceTest;
import tests.MovementTest;
import tests.RemoveMovementAccountTest;
import tests.ResumeTest;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
	AccountTest.class,
	MovementTest.class,
	RemoveMovementAccountTest.class,
	BalanceTest.class,
	ResumeTest.class
})
public class Suite {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void setUp() {
		page.accessInitialScreen();
		
		page.setEmail("ficticio@anonimo");
		page.setPassword("12345");
		page.login();
	}
	
	@AfterClass
	public static void finalizeDriver() {
		DriverFactory.killDriver();
	}

}

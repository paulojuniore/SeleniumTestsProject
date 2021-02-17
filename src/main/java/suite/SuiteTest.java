package suite;

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
public class SuiteTest {
	
	private static LoginPage loginPage = new LoginPage();
	
	@BeforeClass
	public static void resetData() {
		loginPage.accessInitialScreen();
		
		loginPage.setEmail("ficticio@anonimo");
		loginPage.setPassword("12345");
		loginPage.login();
		
		loginPage.resetData();
		
		DriverFactory.killDriver();
	}

}

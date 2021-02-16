package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.BalancePage;
import pages.MenuPage;

public class BalanceTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	BalancePage balancePage = new BalancePage();
	
	@Test
	public void getAccountBalanceTest() {
		menuPage.accessHomePageTest();
		
		Assert.assertEquals("3000.00", balancePage.getAccountBalance("Changed test account"));
	}

}

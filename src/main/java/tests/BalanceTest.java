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
		
		Assert.assertEquals("534.00", balancePage.getAccountBalance("Conta para saldo"));
	}

}

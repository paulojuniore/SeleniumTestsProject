package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.BalancePage;

public class BalanceTest extends BaseTest {
	
	BalancePage balancePage = new BalancePage();
	
	@Test
	public void getAccountBalanceTest() {
		Assert.assertEquals("3000.00", balancePage.getAccountBalance("Teste 2"));
	}

}

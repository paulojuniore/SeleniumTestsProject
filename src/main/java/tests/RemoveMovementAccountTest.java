package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.AccountPage;
import pages.MenuPage;

public class RemoveMovementAccountTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private AccountPage accountPage = new AccountPage();
	
	@Test
	public void removeAccountThatsContainsMovementTest() {
		menuPage.listAccounts();
		
		accountPage.removeAccountWithMovement("Changed test account");
		
		Assert.assertEquals("Conta em uso na movimentações", accountPage.getFailMessage());
	}

}

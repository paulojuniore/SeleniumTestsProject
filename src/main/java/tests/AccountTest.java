package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.AccountPage;
import pages.MenuPage;

public class AccountTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	AccountPage accountPage = new AccountPage();
	
	@Test
	public void insertAccountTest() { 
		menuPage.accessInitialScreenAndInsertAccount();
		
		accountPage.setName("Test account");
		accountPage.save();
		
		Assert.assertEquals("Conta adicionada com sucesso!", accountPage.getSuccessMessage());
	}

}

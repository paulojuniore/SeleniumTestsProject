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
		menuPage.insertAccount();
		
		accountPage.setName("Test account");
		accountPage.save();
		
		Assert.assertEquals("Conta adicionada com sucesso!", accountPage.getSuccessMessage());
	}
	
	@Test
	public void changeAccountTest() {
		menuPage.listAccounts();
		
		accountPage.clickChangeAccount("Test account");
		
		accountPage.clearInputAccountName("nome");
		accountPage.setName("Changed test account");
		accountPage.save();
		
		Assert.assertEquals("Conta alterada com sucesso!", accountPage.getSuccessMessage());
	}
	
	@Test
	public void insertAccountOfTheSameNameTest() {
		menuPage.insertAccount();
		
		accountPage.setName("Changed test account");
		accountPage.save();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", accountPage.getFailMessage());
	}

}

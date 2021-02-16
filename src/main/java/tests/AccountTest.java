package tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import pages.AccountPage;
import pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	AccountPage accountPage = new AccountPage();
	
	@Test
	public void test1_insertAccount() { 
		menuPage.insertAccount();
		
		accountPage.setName("Test account");
		accountPage.save();
		
		Assert.assertEquals("Conta adicionada com sucesso!", accountPage.getSuccessMessage());
	}
	
	@Test
	public void test2_changeAccount() {
		menuPage.listAccounts();
		
		accountPage.clickChangeAccount("Conta para alterar");
		
		accountPage.clearInputAccountName("nome");
		accountPage.setName("Conta alterada");
		accountPage.save();
		
		Assert.assertEquals("Conta alterada com sucesso!", accountPage.getSuccessMessage());
	}
	
	@Test
	public void test3_insertAccountOfTheSameName() {
		menuPage.insertAccount();
		
		accountPage.setName("Conta mesmo nome");
		accountPage.save();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", accountPage.getFailMessage());
	}

}

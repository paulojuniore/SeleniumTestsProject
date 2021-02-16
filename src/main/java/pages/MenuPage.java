package pages;

import core.BasePage;

public class MenuPage extends BasePage {
	
	public void insertAccount() {
		clickLink("Contas");
		clickLink("Adicionar");
	}
	
	public void listAccounts() {
		clickLink("Contas");
		clickLink("Listar");
	}
	
	public void createMovement() {
		clickLink("Criar Movimentação");
	}
	
	public void accessScreenResumeTest() {
		clickLink("Resumo Mensal");
	}
	
	public void accessHomePageTest() {
		clickLink("Home");
	}

}

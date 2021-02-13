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

}

package pages;

import core.BasePage;

public class MenuPage extends BasePage {
	
	public void accessInitialScreenAndInsertAccount() {
		clickLink("Contas");
		clickLink("Adicionar");
	}
	
	public void accessInitialScreenAndListAccounts() {
		clickLink("Contas");
		clickLink("Listar");
	}

}

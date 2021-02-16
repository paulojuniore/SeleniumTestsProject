package pages;

import core.BasePage;

public class BalancePage extends BasePage {
	
	public String getAccountBalance(String nome) {
		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}

}

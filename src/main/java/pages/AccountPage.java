package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class AccountPage extends BasePage {
	
	public void setName(String name) {
		writeOnTextField("nome", name);
	}
	
	public void save() {
		clickButton(By.xpath("//button[.='Salvar']"));
	}
	
	public String getSuccessMessage() {
		return getTextByXpath("//div[@class='alert alert-success']");
	}

	public void clickChangeAccount(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}
	
	public void clearInputAccountName(String id_input) {
		clearInputText(id_input);
	}
	
	public String getFailMessage() {
		return getTextByXpath("//div[@class='alert alert-danger']");
	}

}

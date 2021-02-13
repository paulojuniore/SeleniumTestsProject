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

}

package pages;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class MovementPage extends BasePage {
	
	public void setMovementDate(String date) {
		writeOnTextField("data_transacao", date);
	}
	
	public void setPaymentDate(String date) {
		writeOnTextField("data_pagamento", date);
	}
	
	public void setDescription(String description) {
		writeOnTextField("descricao", description);
	}
	
	public void setInterested(String name) {
		writeOnTextField("interessado", name);
	}
	
	public void setMovementValue(String value) {
		writeOnTextField("valor", value);
	}
	
	public void setAccount(String account) {
		selectSpinner("conta", account);
	}
	
	public void setPaidOut() {
		clickRadioButton("status_pago");
	}
	
	public void save() {
		clickButtonForText("Salvar");
	}
	
	public String getSuccessMessage() {
		return getTextByXpath("//div[@class='alert alert-success']");
	}
	
	public List<String> getErrors() {
		List<WebElement> errors = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> returnList = new ArrayList<String>();
		for (WebElement erro : errors) {
			returnList.add(erro.getText());
		}
		return returnList;
	}

}

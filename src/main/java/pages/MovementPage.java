package pages;

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

}

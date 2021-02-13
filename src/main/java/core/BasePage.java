package core;

import static core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public BasePage() { }
	
	public void writeOnTextField(String id_element, String text) {
		getDriver().findElement(By.id(id_element)).sendKeys(text);
	}
	
	public String getFieldValue(String id_element) {
		return getDriver().findElement(By.id(id_element)).getAttribute("value");
	}
	
	public void clearInputText(String id_input) {
		getDriver().findElement(By.id(id_input)).clear();
	}
	
	public void clickRadioButton(String id_radio) {
		getDriver().findElement(By.id(id_radio)).click();
	}
	
	public boolean isCheckedRadioButton(String id_radio_button) {
		return getDriver().findElement(By.id(id_radio_button)).isSelected();
	}
	
	public void selectSpinner(String id_spinner, String value) {
		WebElement element = getDriver().findElement(By.id(id_spinner));
		Select combo = new Select(element);
//		combo.selectByIndex(4);
//		combo.selectByValue("mestrado");
		combo.selectByVisibleText(value);
	}
	
	public String getSpinnerValue(String id_spinner) {
		WebElement element = getDriver().findElement(By.id(id_spinner));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void clickButton(By by) {
		WebElement button = getDriver().findElement(by);
		button.click();
	}
	
	public void clickButton(String id_button) {
		clickButton(By.id(id_button));
	}
	
	public void clickButtonForText(String text) {
		clickButton(By.xpath("//button[.='"+ text +"']"));
	}
	
	public String getButtonValue(String id_button) {
		WebElement button = getDriver().findElement(By.id(id_button));
		return button.getAttribute("value");
	}
	
	public void clickLink(String link_text) {
		getDriver().findElement(By.linkText(link_text)).click();
	}
	
	public String getTextByXpath(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getText();
	}
	
	public String getLinkText(String id_element) {
		return getDriver().findElement(By.id(id_element)).getText();
	}
	
	public String getTagsText(String tag) {
//		System.out.println(driver.findElement(By.tagName("body")).getText());
		return getDriver().findElement(By.tagName(tag)).getText();
	}
	
	public String getClassnameText(String class_name) {
		return getDriver().findElement(By.className(class_name)).getText();
	}
	
	/********* Alerts ************/
	
	public String getTextAlert(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String getTextAndAcceptAlert(){
		Alert alert = getDriver().switchTo().alert();
		String value = alert.getText();
		alert.accept();
		return value;
		
	}
	
	public String getTextAndDismissAlert() {
		Alert alert = getDriver().switchTo().alert();
		String value = alert.getText();
		alert.dismiss();
		return value;
		
	}
	
	public void WriteAlert(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	/********* Frames e Janelas ************/
	
	public void enterFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void outFrame(){
		getDriver().switchTo().defaultContent();
	}
	
	public void switchWindow(String id) {
		getDriver().switchTo().window(id);
	}
	
/************** Tabela *********************/
	
	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela){
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		return celula;
	}
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
	
	/********* Interação com javascript *********/
	
	public void executeJS(String cmd, Object... params) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript(cmd, params);
	}

}

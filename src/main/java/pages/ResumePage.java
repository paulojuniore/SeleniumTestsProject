package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class ResumePage extends BasePage {
	
	public void removeMovement() {
		clickButton(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String getSuccessMessage() {
		return getTextByXpath("//div[@class='alert alert-success']");
	}
	
	public void selectMonth(String month) {
		selectSpinner("mes", month);
	}
	
	public void selectYear(String year) {
		selectSpinner("ano", year);
	}

}

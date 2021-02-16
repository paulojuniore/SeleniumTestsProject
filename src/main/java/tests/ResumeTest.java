package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import core.BaseTest;
import core.DriverFactory;
import pages.MenuPage;
import pages.ResumePage;

public class ResumeTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ResumePage resumePage = new ResumePage();
	
	@Test
	public void removeMovementTest() {
		menuPage.accessScreenResumeTest();
		
		resumePage.selectMonth("Abril");
		resumePage.selectYear("2020");
		
		resumePage.clickButton(By.xpath("//input[@value='Buscar']"));
		resumePage.removeMovement();
		
		assertEquals("Movimentação removida com sucesso", resumePage.getSuccessMessage());
	}
	
	@Test
	public void MonthlySummaryTest() {
		menuPage.accessScreenResumeTest();
		
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
	}

}

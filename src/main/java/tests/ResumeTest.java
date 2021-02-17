package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BaseTest;
import core.DriverFactory;
import pages.MenuPage;
import pages.ResumePage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumeTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ResumePage resumePage = new ResumePage();
	
	@Test
	public void test1_removeMovement() {
		menuPage.accessScreenResumeTest();
		resumePage.removeMovement();
		
		assertEquals("Movimentação removida com sucesso!", resumePage.getSuccessMessage());
	}
	
	@Test
	public void test2_MonthlySummary() {
		menuPage.accessScreenResumeTest();
		
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
		
		resumePage.selectYear("2015");
		resumePage.clickButton(By.xpath("//input[@value='Buscar']"));
		
		List<WebElement> foundElements = 
				DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, foundElements.size());
	}

}

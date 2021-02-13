package tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import core.BaseTest;
import pages.MenuPage;
import pages.MovementPage;

public class MovementTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	MovementPage movementPage = new MovementPage();
	
	@Test
	public void createMovement() {
		menuPage.createMovement();
		
		movementPage.setMovementDate("10/04/2020");
		movementPage.setPaymentDate("15/05/2020");
		movementPage.setDescription("A simple movement.");
		movementPage.setInterested("Unknown");
		movementPage.setMovementValue("3000");
		movementPage.setAccount("Changed test account");
		movementPage.setPaidOut();
		
		movementPage.save();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movementPage.getSuccessMessage());
	}
	
	@Test
	public void requiredFieldsTest() {
		menuPage.createMovement();
		
		movementPage.save();
		
		List<String> errors = movementPage.getErrors();
		
		Assert.assertTrue(errors.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(errors.contains("Data do pagamento é obrigatório"));
		Assert.assertTrue(errors.contains("Descrição é obrigatório"));
		Assert.assertTrue(errors.contains("Interessado é obrigatório"));
		Assert.assertTrue(errors.contains("Valor é obrigatório"));
		Assert.assertTrue(errors.contains("Valor deve ser um número"));
		
		Assert.assertEquals(6, errors.size());
	}

}

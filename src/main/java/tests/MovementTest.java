package tests;

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

}

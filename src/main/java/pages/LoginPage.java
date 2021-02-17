package pages;

import org.openqa.selenium.By;

import core.BasePage;
import core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void accessInitialScreen() {
		DriverFactory.getDriver().get("http://srbarriga.herokuapp.com");
	}
	
	public void setEmail(String email) {
		writeOnTextField("email", email);
	}
	
	public void setPassword(String password) {
		writeOnTextField("senha", password);
	}
	
	public void login() {
		clickButton(By.xpath("//button[.='Entrar']"));
	}
	
	public void resetData() {
		clickLink("reset");
	}

}

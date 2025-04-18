package automacaoE2E.Pages;

import org.openqa.selenium.By;

import automacaoE2E.Drivers.Drivers;
import automacaoE2E.Metodos.Metodos;

public class LoginPage extends Drivers{
	
	Metodos metodo = new Metodos();
	
	private By username = By.id("username");
	private By password = By.id("password");
	private By loginBtn = By.id("loginButton");
	private By logoutBtn = By.id("logout-button");
	
	public By getUsername() {
		return username;
	}
	public By getPassword() {
		return password;
	}
	public By getLoginBtn() {
		return loginBtn;
	}
	public By getLogoutBtn() {
		return logoutBtn;
	}
	
	public void logar(String username, String password) {
		metodo.escrever(getUsername(), username);
		metodo.escrever(getPassword(), password);
		metodo.clicar(loginBtn);
	}
	
	
}

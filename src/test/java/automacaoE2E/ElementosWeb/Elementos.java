package automacaoE2E.ElementosWeb;

import org.openqa.selenium.By;

import lombok.Getter;




@Getter
public class Elementos {
	
	private By ativo = By.id("asset");
	private By preco = By.id("price");
	private By qtd = By.id("quantity");
	private By btnComprar = By.id("buy-button");
	private By btnVender = By.id("sell-button");
	
	//LoginElements
	private By username = By.id("username");
	private By password = By.id("password");
	private By loginBtn = By.id("loginButton");
	private By logoutBtn = By.id("logout-button");


}

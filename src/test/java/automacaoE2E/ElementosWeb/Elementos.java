package automacaoE2E.ElementosWeb;

import org.openqa.selenium.By;

public class Elementos {
	
	private By ativo = By.id("asset");
	private By preco = By.id("price");
	private By qtd = By.id("quantity");
	private By btnComprar = By.id("buy-button");
	private By btnVender = By.id("sell-button");
	
	
	public By getAtivo() {
		return ativo;
	}
	public By getPreco() {
		return preco;
	}
	public By getQtd() {
		return qtd;
	}
	public By getBtnComprar() {
		return btnComprar;
	}
	public By getBtnVender() {
		return btnVender;
	}

}

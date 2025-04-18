package automacaoE2E.Testes;

/*import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import automacaoE2E.Metodos.Metodos;
import automacaoE2E.Pages.CompraPage;
import automacaoE2E.Pages.LoginPage;
import automacaoE2E.Pages.VendaPage;
import automacaoE2E.Runner.Executa;

public class VendaTest {
	
	LoginPage login = new LoginPage();
	CompraPage compra = new CompraPage();
	VendaPage venda = new VendaPage();
	Executa executa = new Executa();
	Metodos metodo = new Metodos();
	ChromeOptions options = new ChromeOptions();
	
	@BeforeEach
	public void antesDosTestes() {
		executa.setup();
		login.logar("e2etreinamentos", "e2e@123");
		compra.comprar("PETR3", "30", "150");
		metodo.accAllAlerts();
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		metodo.validarTexto(By.id("portfolio-total"), "Total: R$ 4500,00");

	}

	@AfterEach
	public void depoisDosTestes() {
		executa.tearDown();
	}

	@Order(1)
	@Test
	void VendaSucesso() {
		venda.vender("PETR3", "30", "150");
		metodo.validarTexto(By.id("portfolio-total"), "Total: R$ 1500,00");

	}

}*/

package automacaoE2E.Testes;



import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeOptions;

import automacaoE2E.Drivers.Drivers;
import automacaoE2E.Metodos.Metodos;
import automacaoE2E.Pages.CompraPage;
import automacaoE2E.Pages.LoginPage;

import automacaoE2E.Runner.Executa;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CompraTest extends Drivers {

	LoginPage login = new LoginPage();
	CompraPage compra = new CompraPage();
	Executa executa = new Executa();
	Metodos metodo = new Metodos();
	ChromeOptions options = new ChromeOptions();
	
	


	@BeforeEach
	public void antesDosTestes() {
		executa.setup();
		login.logar("e2etreinamentos", "e2e@123");

	}

	@AfterEach
	public void depoisDosTestes() {
		executa.tearDown();
	}

	@Order(1)
	@Test
	void compraSucesso() {
		compra.comprar("PETR3", "30", "150");
		metodo.accAllAlerts();
		metodo.validarTexto(By.id("portfolio-total"), "Total: R$ 4500,00");

	}

	@Order(2)
	@Test
	void naoDeveComprarPrecoMenor() {
		compra.comprar("PETR3", "28", "150");
		metodo.validarAlert("O preço deve estar entre R$ 29,40 e R$ 33,00");
		metodo.accAllAlerts();
	}

	@Order(3)
	@Test
	void naoDeveComprarPrecoMaior() {
		compra.comprar("PETR3", "34", "150");
		metodo.validarAlert("O preço deve estar entre R$ 29,40 e R$ 33,00");
		metodo.accAllAlerts();
	}

	@Order(4)
	@Test
	void naoDeveComprarQtdMenor() {
		compra.comprar("PETR3", "30", "0");
		metodo.validarAlert("Preencha os campos corretamente.");
		metodo.accAllAlerts();
	}

	@Order(5)
	@Test
	void naoDeveComprarQtdMaior() {
		compra.comprar("PETR3", "30", "151");
		metodo.validarAlert("Quantidade insuficiente no livro de ofertas.");
		metodo.accAllAlerts();
	}

	@Order(6)
	@Test
	void compraFracionadaSucessoValor1() {
		compra.comprar("PETR3", "30", "1");
		metodo.validarAlert("Compra realizada com sucesso usando saldo!");
		metodo.accAllAlerts();
		metodo.validarTexto(By.id("portfolio-total"), "Total: R$ 30,00");
	}

	@Order(7)
	@Test
	void compraFracionadaSucessoValor9() {
		compra.comprar("PETR3", "30", "9");
		metodo.validarAlert("Compra realizada com sucesso usando saldo!");
		metodo.accAllAlerts();
		metodo.validarTexto(By.id("portfolio-total"), "Total: R$ 270,00");
	}

	@Order(8)
	@Test
	void compraFracionadaSucessoValor2() {
		compra.comprar("PETR3", "30", "2");
		metodo.validarAlert("Compra realizada com sucesso usando saldo!");
		metodo.accAllAlerts();
		metodo.validarTexto(By.id("portfolio-total"), "Total: R$ 60,00");
	}

	@Order(9)
	@Test
	void compraFracionadaSucessoValor7() {
		compra.comprar("PETR3", "30", "7");
		metodo.validarAlert("Compra realizada com sucesso usando saldo!");
		metodo.accAllAlerts();
		metodo.validarTexto(By.id("portfolio-total"), "Total: R$ 210,00");
	}

	@Order(10)
	@Test
	void naoDeveComprarFracionadaPreco0() {
		compra.comprar("PETR3", "0", "150");
		metodo.validarAlert("Preencha os campos corretamente.");
		metodo.accAllAlerts();
	}

	@Order(11)
	@Test
	void naoDeveComprarFracionadaPreco10() {
		compra.comprar("PETR3", "10", "150");
		metodo.validarAlert("O preço deve estar entre R$ 29,40 e R$ 33,00");
		metodo.accAllAlerts();
	}

}

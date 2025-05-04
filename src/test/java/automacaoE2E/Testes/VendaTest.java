package automacaoE2E.Testes;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;


import automacaoE2E.Metodos.Metodos;
import automacaoE2E.Pages.CompraPage;
import automacaoE2E.Pages.LoginPage;
import automacaoE2E.Pages.VendaPage;
import automacaoE2E.Runner.Executa;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VendaTest {

	LoginPage login = new LoginPage();
	CompraPage compra = new CompraPage();
	VendaPage venda = new VendaPage();
	Executa executa = new Executa();
	Metodos metodo = new Metodos();

	@BeforeEach
	public void antesDosTestes() {
		executa.setup();
		login.logar("e2etreinamentos", "e2e@123");
		compra.comprar("PETR3", "30", "150");
		metodo.accAllAlerts();
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
		metodo.accAllAlerts();
		metodo.validarTexto(By.id("portfolio-total"), "Total: R$ 0,00");
	}

	@Order(2)
	@Test
	void vendaFracionadaSucessoValor29_40() {
		venda.vender("PETR3", "29,40", "150");
		metodo.accAllAlerts();
		metodo.contemTexto(By.id("balance"), "9910");
	}

	@Order(3)
	@Test
	void vendaFracionadaSucessoValor33_00() {
		venda.vender("PETR3", "33,00", "150");
		metodo.accAllAlerts();
		metodo.contemTexto(By.id("balance"), "10450");
	}

	@Order(4)
	@Test
	void vendaFracionadaSucessoValor29_41() {
		venda.vender("PETR3", "29,41", "150");
		metodo.accAllAlerts();
		metodo.contemTexto(By.id("balance"), "9911");

	}

	@Order(5)
	@Test
	void vendaFracionadaSucessoValor29_99() {
		venda.vender("PETR3", "29,99", "150");
		metodo.accAllAlerts();
		metodo.contemTexto(By.id("balance"), "9998");

	}

	@Order(6)
	@Test
	public void naoDeveVenderValorMenor29_40() {
		venda.vender("PETR3", "29,39", "150");
		metodo.validarAlert("O preço deve estar entre R$ 29,40 e R$ 33,00");
	}

	@Order(7)
	@Test
	public void naoDeveVenderValorMaior33_00() {
		venda.vender("PETR3", "29,39", "150");
		metodo.validarAlert("O preço deve estar entre R$ 29,40 e R$ 33,00");
	}

	@Order(8)
	@Test
	public void naoDeveVenderQtd0() {
		venda.vender("PETR3", "33,00", "0");
		metodo.validarAlert("Por favor, insira valores válidos.");
		metodo.aceitarAlert();
		metodo.validarAlert("Preencha os campos corretamente.");
		metodo.aceitarAlert();
	}

	@Order(9)
	@Test
	public void naoDeveVenderQtdMaiorCarteira() {
		venda.vender("PETR3", "30", "151");
		metodo.validarAlert("Quantidade insuficiente na carteira.");
	}

}

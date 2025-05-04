package automacaoE2E.Testes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;


import automacaoE2E.ElementosWeb.Elementos;
import automacaoE2E.Metodos.Metodos;
import automacaoE2E.Pages.LoginPage;
import automacaoE2E.Runner.Executa;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

	LoginPage login = new LoginPage();
	Executa executa = new Executa();
	Metodos metodo = new Metodos();
	Elementos el = new Elementos();

	@BeforeEach
	public void antesDosTestes() {
		executa.setup();

	}

	@AfterEach
	public void depoisDosTestes() {
		executa.tearDown();
	}

	@Order(1)
	@Test
	public void loginSucesso() {
		login.logar("e2etreinamentos", "e2e@123");
		metodo.validarUrl("https://desafio.ui.e2etreinamentos.com.br/home.html");
	}

	@Order(2)
	@Test
	public void loginUsuarioInv() {
		login.logar("inválido", "e2e@123");
		metodo.validarAlert("Usuário ou senha incorretos.");
	}

	@Order(3)
	@Test
	public void loginSenhaInv() {
		login.logar("e2etreinamentos", "inválido");
		metodo.validarAlert("Usuário ou senha incorretos.");
	}

	@Order(4)
	@Test
	public void loginCamposEmBranco() {
		login.logar("", "");
		metodo.validarAlert("Todos os campos precisam ser preenchidos.");
	}

	@Order(5)
	@Test
	public void logoutSucesso() {
		login.logar("e2etreinamentos", "e2e@123");
		metodo.clicar(el.getLogoutBtn());
		metodo.aceitarAlert();
		metodo.validarUrl("https://desafio.ui.e2etreinamentos.com.br/hb.html");
		metodo.validarTexto(By.xpath("//h2[contains(text(),'Acesse sua conta')]"), "Acesse sua conta");
	}

}

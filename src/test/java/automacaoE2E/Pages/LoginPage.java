package automacaoE2E.Pages;



import automacaoE2E.Drivers.Drivers;
import automacaoE2E.ElementosWeb.Elementos;
import automacaoE2E.Metodos.Metodos;
import lombok.Getter;

@Getter
public class LoginPage extends Drivers{
	
	Metodos metodo = new Metodos();
	Elementos el = new Elementos();
	
	

	
	public void logar(String username, String password) {
		metodo.escrever(el.getUsername(), username);
		metodo.escrever(el.getPassword(), password);
		metodo.clicar(el.getLoginBtn());
	}
	
	
}

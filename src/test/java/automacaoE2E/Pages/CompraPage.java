package automacaoE2E.Pages;



import automacaoE2E.Drivers.Drivers;
import automacaoE2E.ElementosWeb.Elementos;
import automacaoE2E.Metodos.Metodos;

public class CompraPage extends Drivers{
	
	Metodos metodo = new Metodos();
	Elementos el = new Elementos();
	
	
	public void comprar(String ativo, String preco, String qtd) {
		metodo.escrever(el.getAtivo(), ativo);
		metodo.escrever(el.getPreco(), preco);
		metodo.escrever(el.getQtd(), qtd);
		metodo.clicar(el.getBtnComprar());
		
	}

}

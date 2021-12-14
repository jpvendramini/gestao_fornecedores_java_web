package command;

import application.Dominio;
import application.Resultado;

public class ExibirFornecedorCommand extends AbstractCommand{

	@Override
	public Resultado execute(Dominio dominio) {
		return fachada.findAll();
	}

}

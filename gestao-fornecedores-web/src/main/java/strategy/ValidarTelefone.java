package strategy;

import application.Dominio;
import dominio.Fornecedor;

public class ValidarTelefone implements IStrategy{

	@Override
	public String processar(Dominio dominio) { 
		Fornecedor f = (Fornecedor) dominio;
		if(f.getContato().getTelefone().getCodigo() != null && f.getContato().getTelefone().getDdd() != null && f.getContato().getTelefone().getNumber() != null) {
			return null;
		}else {
			return "Dados nao preenchidos.";	
		}		
	}

}

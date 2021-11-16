package strategy;

import dominio.Dominio;
import fornecedor.Fornecedor;

public class ValidarTelefone implements IStrategy{

	@Override
	public boolean processar(Dominio dominio) { 
		Fornecedor f = (Fornecedor) dominio;
		if(f.getContato().getTelefone().getCodigo() != null && f.getContato().getTelefone().getDdd() != null && f.getContato().getTelefone().getNumber() != null) {
			return true;
		}else {
			return false;	
		}		
	}

}

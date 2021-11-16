package strategy;

import dominio.Dominio;
import fornecedor.Fornecedor;

public class ValidarDadosFornecedor implements IStrategy{

	@Override
	public boolean processar(Dominio dominio) {
		Fornecedor f = (Fornecedor) dominio;
		if(f.getRazaoSocial() != null && 
		   f.getNomeFantasia() != null && 
		   f.getInscricaoEstadual() != null &&
		   f.getInscricaoMunicipal() != null) {
			return true;
		}else {
			return false;	
		}		
	}

}

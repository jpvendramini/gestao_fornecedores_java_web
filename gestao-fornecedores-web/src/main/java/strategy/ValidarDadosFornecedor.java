package strategy;

import application.Dominio;
import dominio.Fornecedor;

public class ValidarDadosFornecedor implements IStrategy{

	@Override
	public String processar(Dominio dominio) {
		Fornecedor f = (Fornecedor) dominio;
		if(f.getRazaoSocial() != null && 
		   f.getNomeFantasia() != null && 
		   f.getInscricaoEstadual() != null &&
		   f.getInscricaoMunicipal() != null) {
			return null;
		}else {
			return "Dados incorretos ou nao preenchidos.";	
		}		
	}

}

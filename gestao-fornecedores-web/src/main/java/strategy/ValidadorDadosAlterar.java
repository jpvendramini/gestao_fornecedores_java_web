package strategy;

import application.Dominio;
import dominio.Fornecedor;

public class ValidadorDadosAlterar implements IStrategy{

	@Override
	public String processar(Dominio dominio) {
		Fornecedor f = (Fornecedor)dominio;
		
		if(f.getCnae().getId() == null) {
			return "CNAE ID not found!";
		}
		return null;
	}
	
}

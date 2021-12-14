package strategy;

import application.Dominio;
import dominio.Fornecedor;

public class ValidarCNAE implements IStrategy{

	@Override
	public String processar(Dominio dominio) {
		Fornecedor f = (Fornecedor)dominio;
		
		if(f.getCnae().getDescricao() != null && f.getCnae().getDescricao().length() == 7) {
			return null;
		}else {
			return "Valor da CNAE incorreto.";
		}
	}

}

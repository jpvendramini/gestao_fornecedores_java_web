package strategy;

import dominio.Dominio;
import fornecedor.Fornecedor;

public class ValidarCNAE implements IStrategy{

	@Override
	public boolean processar(Dominio dominio) {
		Fornecedor f = (Fornecedor)dominio;
		
		if(f.getCnae().getDescricao() != null) {
			return true;
		}else {
			return false;
		}
	}

}

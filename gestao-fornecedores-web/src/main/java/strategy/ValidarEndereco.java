package strategy;

import application.Dominio;
import dominio.Fornecedor;

public class ValidarEndereco implements IStrategy{

	@Override
	public String processar(Dominio dominio) {
		Fornecedor f = (Fornecedor)dominio;
		if(f.getEndereco().getDescricao() != null && 
		   f.getEndereco().getBairro() != null && 
		   f.getEndereco().getNumero() != null && 
		   f.getEndereco().getCep() != null && 
		   f.getEndereco().getCidade().getDescricao() != null && 
		   f.getEndereco().getUf().getDescricao() != null && 
		   f.getEndereco().getPais().getDescricao() != null) {
			return null;			
		}else {
			return "Dados nao preenchidos.";
		}
	}
	
}

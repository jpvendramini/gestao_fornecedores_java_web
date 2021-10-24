package endereco;

import java.util.List;

import dominio.Dominio;

public class Cidade extends Dominio{	
	private List<Endereco> enderecos;
	
	public Cidade(String city) {
		super();		
		this.setDescricao(city);		
	}
	
	public Cidade(String city, List<Endereco> enderecos) {
		super();		
		this.setDescricao(city);
		this.enderecos = enderecos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}

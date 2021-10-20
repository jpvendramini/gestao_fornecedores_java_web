package endereco;

import java.util.List;

import dominio.Dominio;

public class Cidade extends Dominio{
	private UF uf;
	private List<Endereco> enderecos;
	
	public Cidade(UF uf, List<Endereco> enderecos) {
		super();
		this.uf = uf;
		this.enderecos = enderecos;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}

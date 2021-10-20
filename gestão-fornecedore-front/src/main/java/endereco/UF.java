package endereco;

import java.util.List;

import dominio.Dominio;

public class UF extends Dominio{
	private Pais pais;
	private List<Cidade> cidades;
	
	public UF(Pais pais, List<Cidade> cidades) {
		super();
		this.pais = pais;
		this.cidades = cidades;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
}

package dominio;

import java.util.List;

import application.Dominio;

public class UF extends Dominio{	
	private List<Cidade> cidades;
	
	public UF(String uf) {
		super();		
		this.setDescricao(uf);
	}
	
	public UF(List<Cidade> cidades) {
		super();		
		this.cidades = cidades;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
}

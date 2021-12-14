package dominio;

import java.util.List;

import application.Dominio;

public class Pais extends Dominio{
	private List<UF> ufs;

	public Pais(String pais) {
		super();
		this.setDescricao(pais);
	}
	
	public Pais(List<UF> ufs) {
		super();
		this.ufs = ufs;
	}

	public List<UF> getUfs() {
		return ufs;
	}

	public void setUfs(List<UF> ufs) {
		this.ufs = ufs;
	}
}

package endereco;

import java.util.List;

import dominio.Dominio;

public class Pais extends Dominio{
	private List<UF> ufs;

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

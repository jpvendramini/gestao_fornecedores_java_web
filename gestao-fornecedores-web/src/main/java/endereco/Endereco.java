package endereco;

import dominio.Dominio;

public class Endereco extends Dominio{
	private String bairro;
	private String numero;
	private String cep;	
	private Cidade cidade;
	private UF uf;
	private Pais pais;

	public Endereco(String end, String bairro, Cidade cidade, UF uf, Pais pais) {
		super();
		this.setDescricao(end);
		this.bairro = bairro;				
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
	}
	
	public Endereco(String end, String bairro, String numero, String cep, Cidade cidade, UF uf, Pais pais) {
		super();
		this.setDescricao(end);
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}

package fornecedor;

import contato.Contato;
import dominio.Dominio;
import endereco.Endereco;
import produto.Produto;

public class Fornecedor extends Dominio{
	private int cnpj;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private String nomeFantasia;
	private String razaoSocial;
	
	private Endereco endereco;
	private Contato contato;
	private CNAE cnae;
	private Status status;
	private Produto produto;
	
	public Fornecedor() {}

	public Fornecedor(int cnpj, String inscricaoEstadual, String inscricaoMunicipal, String nomeFantasia,
			String razaoSocial, Endereco endereco, Contato contato, CNAE cnae, Status status, Produto produto) {
		super();
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.endereco = endereco;
		this.contato = contato;
		this.cnae = cnae;
		this.status = status;
		this.produto = produto;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public CNAE getCnae() {
		return cnae;
	}

	public void setCnae(CNAE cnae) {
		this.cnae = cnae;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}

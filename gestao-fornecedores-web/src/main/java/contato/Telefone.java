package contato;

import dominio.Dominio;

public class Telefone extends Dominio {
	private int codigo;
	private int ddd;
	private String number;
	private TipoTelefone tipo;
	
	public Telefone(int codigo, int ddd, String number, TipoTelefone tipo) {
		super();
		this.codigo = codigo;
		this.ddd = ddd;
		this.number = number;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}
}

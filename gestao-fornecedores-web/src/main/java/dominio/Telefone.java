package dominio;

import application.Dominio;

public class Telefone extends Dominio {
	private String codigo;
	private String ddd;
	private String number;
	private TipoTelefone tipo;
	
	public Telefone(String number) {
		super();
		this.number = number;
	}
	
	public Telefone(String codigo, String ddd, String number, TipoTelefone tipo) {
		super();
		this.codigo = codigo;
		this.ddd = ddd;
		this.number = number;
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
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

package contato;

import dominio.Dominio;

public class Contato extends Dominio{
	Email email;
	Telefone telefone;
	
	public Contato(Email email, Telefone telefone) {
		super();
		this.email = email;
		this.telefone = telefone;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
}

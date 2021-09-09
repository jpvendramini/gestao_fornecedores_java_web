package model.contato;

public class Contato {
    private String email;
    private Departamento departamento;
    private Telefone telefone;

    public Contato(String email, Departamento departamento, Telefone telefone) {
        this.email = email;
        this.departamento = departamento;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "email='" + email + '\'' +
                ", departamento=" + departamento +
                ", telefone=" + telefone +
                '}';
    }
}

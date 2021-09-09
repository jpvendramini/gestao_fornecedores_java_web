package model.contato;

public class Telefone {
    private String ddd;
    private String numero;
    private String ddi;
    private Ramal ramal;
    private TipoTelefone tipoTelefone;

    public Telefone(){}

    public Telefone(String ddd, String numero, String ddi, Ramal ramal, TipoTelefone tipoTelefone) {
        this.ddd = ddd;
        this.numero = numero;
        this.ddi = ddi;
        this.ramal = ramal;
        this.tipoTelefone = tipoTelefone;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
}

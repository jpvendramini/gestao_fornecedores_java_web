package model.pessoa;

import model.contato.Contato;

public class Pessoa {
    private String name;
    private Contato contato;

    public Pessoa(String name, Contato contato) {
        this.name = name;
        this.contato = contato;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

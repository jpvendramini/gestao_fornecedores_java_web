package model.endereco;

import java.util.List;

public class UF {
    private String descricao;
    private String sigla;
    private Cidade cidades;

    public UF(String descricao, String sigla, Cidade cidade) {
        this.descricao = descricao;
        this.sigla = sigla;
        this.cidades = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}

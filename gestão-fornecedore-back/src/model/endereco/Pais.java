package model.endereco;

import java.util.List;

public class    Pais {
    private String descricao;
    private UF ufs;

    public Pais(String descricao, UF uf) {
        this.descricao = descricao;
        this.ufs = uf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

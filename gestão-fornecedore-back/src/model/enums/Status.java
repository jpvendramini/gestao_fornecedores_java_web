package model.enums;

public enum Status {
    ATIVO("ATIVO"),
    RASCUNHO("RASCUNHO"),
    INATIVO("INATIVO");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

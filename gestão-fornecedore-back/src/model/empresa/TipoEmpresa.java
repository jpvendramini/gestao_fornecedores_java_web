package model.empresa;

public enum TipoEmpresa {
    FILIAL("FILIAL"),
    MATRIZ("MATRIZ");

    private String descricao;

    TipoEmpresa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

package model.enums;

public enum TipoFornecimento {
    VENDA("VENDA"),
    SERVICO("SERVICO");

    private String tipo;

    TipoFornecimento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}

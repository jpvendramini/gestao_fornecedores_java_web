package model.empresa;

public class Empresa {
    private TipoEmpresa tipoEmpresa;
    private OS os;

    public Empresa(TipoEmpresa tipoEmpresa, OS os) {
        this.tipoEmpresa = tipoEmpresa;
        this.os = os;
    }
}

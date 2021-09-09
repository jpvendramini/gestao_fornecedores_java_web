package model.empresa;

public class OS {
    private long dtInicio;
    private Servico servico;

    public OS(long dtInicio, Servico servico) {
        this.dtInicio = dtInicio;
        this.servico = servico;
    }

    public long getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(long dtInicio) {
        this.dtInicio = dtInicio;
    }
}

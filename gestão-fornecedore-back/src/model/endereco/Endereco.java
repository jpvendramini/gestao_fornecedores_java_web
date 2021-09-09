package model.endereco;

public class Endereco {
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private TipoEndereco tipoEndereco;
    private TipoLogradouro tipoLogradouro;
    private Pais pais;

    public Endereco(String cep, String logradouro, String numero, String bairro, String complemento, TipoEndereco tipoEndereco, TipoLogradouro tipoLogradouro, Pais pais){
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.tipoEndereco = tipoEndereco;
        this.tipoLogradouro = tipoLogradouro;
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", tipoEndereco=" + tipoEndereco +
                ", tipoLogradouro=" + tipoLogradouro +
                ", pais=" + pais +
                '}';
    }
}

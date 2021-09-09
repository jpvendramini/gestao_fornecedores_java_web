package model.fornecedor;

import model.contato.Contato;
import model.contato.Telefone;
import model.empresa.Empresa;
import model.empresa.OS;
import model.endereco.Endereco;
import model.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
    private boolean isRascunho;
    private int id;
    private String email;
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private long dtCadastro;
    private String rzSocial;
    private String nmFantasia;

    private Empresa empresa;
    private OS os;
    private Status status;
    private Endereco endereco;
    private List<Produto> produtoList = new ArrayList<>();
    private List<Contato> contatos = new ArrayList<>();
    private List<Telefone> telefoneList = new ArrayList<>();


    public Fornecedor(boolean isRascunho, int id, String email, String cnpj, String inscricaoEstadual, String inscricaoMunicipal, long dtCadastro, String rzSocial, String nmFantasia, Empresa empresa, OS os, Endereco endereco){
        this.isRascunho = isRascunho;
        this.id = id;
        this.email = email;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.dtCadastro = dtCadastro;
        this.rzSocial = rzSocial;
        this.nmFantasia = nmFantasia;
        this.empresa = empresa;
        this.os = os;
        this.endereco = endereco;
    }

    public boolean isRascunho() {
        return isRascunho;
    }

    public void setRascunho(boolean rascunho) {
        isRascunho = rascunho;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public long getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(long dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getRzSocial() {
        return rzSocial;
    }

    public void setRzSocial(String rzSocial) {
        this.rzSocial = rzSocial;
    }

    public String getNmFantasia() {
        return nmFantasia;
    }

    public void setNmFantasia(String nmFantasia) {
        this.nmFantasia = nmFantasia;
    }

    public void inativar(){
        this.status = Status.INATIVO;
    }
    public void ativar(){
        this.status = Status.ATIVO;
    }
    public void addContato(Contato contato){
        this.contatos.add(contato);
    }
    public void validarCNPJ(){}
    public void validarListFornecimento(){}




    @Override
    public String toString() {
        return  "isRascunho=" + isRascunho +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                ", inscricaoMunicipal='" + inscricaoMunicipal + '\'' +
                ", dtCadastro=" + dtCadastro +
                ", rzSocial='" + rzSocial + '\'' +
                ", nmFantasia='" + nmFantasia + '\'' +
                ", contatos=" + contatos +
                ", endereco=" + endereco +
                ", status=" + status;
    }
}

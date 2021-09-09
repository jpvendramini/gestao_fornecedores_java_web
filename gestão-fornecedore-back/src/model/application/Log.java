package model.application;

import model.contato.*;
import model.empresa.Empresa;
import model.empresa.OS;
import model.empresa.Servico;
import model.empresa.TipoEmpresa;
import model.endereco.*;
import model.fornecedor.CNAE;
import model.fornecedor.Fornecedor;
import model.fornecedor.Produto;
import model.pessoa.Pessoa;
import model.pessoa.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Log {

    public static void main(String args[]){
        List<Fornecedor> fornecedorList = new ArrayList<>();

        System.out.println("CADASTRO DE FUNCIONÁRIOS");

        //Contato
        Departamento departamento = new Departamento("Papelaria");
        Ramal ramal = new Ramal("201","Administração");
        TipoTelefone tipoTelefone = new TipoTelefone("Celular");
        Telefone telefone = new Telefone("11","99999-9999","55",ramal,tipoTelefone);
        Contato contato = new Contato("michaelscott@dundlermifflin.com.br", departamento, telefone);
        //Pessoa + Usuario
        Pessoa pessoa = new Pessoa("Michael Scott", contato);
        Usuario usuario = new Usuario("michael@gmail.com","thatiswhatshesaid",pessoa);
        //Endereço
        TipoEndereco tipoEndereco = new TipoEndereco("Avenida","");
        TipoLogradouro tipoLogradouro = new TipoLogradouro("Avenida","");
        Cidade cidade = new Cidade("Scranton");
        UF uf = new UF("Pennsylvania", "PA", new Cidade("Scranton"));
        Pais pais = new Pais("United States",uf);
        Endereco endereco = new Endereco("088121","Slough Avenue", "1725","Scranton", "no", tipoEndereco, tipoLogradouro,pais);
        //Empresa
        Servico servico = new Servico(1, "Papelaria");
        OS os = new OS(81928192,servico);
        Empresa empresa = new Empresa(TipoEmpresa.MATRIZ, os);
        //Fornecedor
        CNAE cnae = new CNAE("4761-0/03");
        Produto produto = new Produto(1, "Papel", "Papel 75g");
        Fornecedor fornecedor = new Fornecedor(false,1,"empresa@gmail.com","82.102.398/0001-31","000000000","000000000"
        ,912891829,"Dundler Miffin Whatever", "Dundler Miffin", empresa, os, endereco);
        fornecedor.addContato(contato);

        fornecedorList.add(fornecedor);

        for (Fornecedor fornecedor3 : fornecedorList){
            System.out.println(fornecedor3);
        }

    }


//    public void salvar(Fornecedor fornecedor){
//        fornecedorList.add(fornecedor);
//    }
//
//    public void consultar(){
//        for (Fornecedor fornecedor : fornecedorList){
//            System.out.println(fornecedor);
//        }
//    }
//
//    public void excluir(int id){
//        for (Fornecedor fornecedor : fornecedorList){
//            if (fornecedor.getId() == id){
//                fornecedorList.remove(fornecedor);
//            }
//        }
//    }
//
//    public void alterar(int id, Fornecedor fornecedor){
//        for (Fornecedor fornecedor1 : fornecedorList){
//            if (fornecedor1.getId() == id){
//                fornecedorList.set(id, fornecedor1);
//            }
//        }
//    }
}

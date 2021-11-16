package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contato.Contato;
import contato.Email;
import contato.Telefone;
import contato.TipoTelefone;
import endereco.Cidade;
import endereco.Endereco;
import endereco.Pais;
import endereco.UF;
import fornecedor.CNAE;
import fornecedor.Fornecedor;
import fornecedor.FornecedorFacade;
import produto.Produto;
import produto.TipoProduto;


@WebServlet("/AlterarFornecedor")
public class AlterarFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);			
		request.setAttribute("id", id);
		request.getRequestDispatcher("/src/Alteracao.jsp").forward(request, response);	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FornecedorFacade fornControl = new FornecedorFacade();
		//FORNECEDOR
		String cnpj = request.getParameter("cnpj");
		String inscricaoEstadual =  request.getParameter("inscricaoEstadual");
		String inscricaoMunicipal = request.getParameter("inscricaoMunicipal");
		String nomeFantasia = request.getParameter("nomeFantasia");
		String razaoSocial = request.getParameter("razaoSocial");
		Long fornecedorId = Long.parseLong(request.getParameter("fornecedorId"));
		
		//CNAE
		String cnae = request.getParameter("cnae");				
		Long cnaeId = Long.parseLong(request.getParameter("cnaeId"));
		CNAE cn = new CNAE(cnae);
		cn.setId(cnaeId);
		
		//ENDERECO		
		String endereco = request.getParameter("endereco");
		String bairro = request.getParameter("bairro");
		String numero = request.getParameter("numero");
		String cep = request.getParameter("cep");
		Long endId = Long.parseLong(request.getParameter("endId"));
		
		//CIDADE		
		String cidade = request.getParameter("cidade");
		Long cidadeId = Long.parseLong(request.getParameter("cidadeId"));
		Cidade city = new Cidade(cidade);
		city.setId(cidadeId);
		
		//UF
		String ufDescricao = request.getParameter("uf");
		Long ufId = Long.parseLong(request.getParameter("ufId"));
		UF uf = new UF(ufDescricao);
		uf.setId(ufId);
		
		//PAIS
		String paisDescricao = request.getParameter("pais");
		Long paisId = Long.parseLong(request.getParameter("paisId"));
		Pais pais = new Pais(paisDescricao);
		pais.setId(paisId);
		
		Endereco end = new Endereco(endereco, bairro, numero, cep, city, uf, pais);
		end.setId(endId);
		
		//COTATO
		String email = request.getParameter("email");	
		Long emailId = Long.parseLong(request.getParameter("emailId"));
		String ddd = request.getParameter("ddd");
		String codigo= request.getParameter("codigo");
		String telefone = request.getParameter("telefone");
		Long telefoneId = Long.parseLong(request.getParameter("telefoneId"));
		
		Telefone tel = new Telefone(ddd, codigo, telefone, TipoTelefone.CELULAR);
		tel.setId(telefoneId);
		Email eml = new Email();
		eml.setDescricao(email);	
		eml.setId(emailId);
		Contato contato = new Contato(eml, tel);
		
		//PRODUTO
		String produto = request.getParameter("produto");
		String tipoProduto = request.getParameter("tipoProduto");
		Long produtoId = Long.parseLong(request.getParameter("produtoId"));
		
		Produto prod;
		if(tipoProduto == "PRODUTO") {
			prod = new Produto(produto, TipoProduto.PRODUTO);			
		}else {
			prod = new Produto(produto, TipoProduto.SERVICO);		
		}
		prod.setId(produtoId);
		
		Fornecedor forn = new Fornecedor(cnpj, inscricaoEstadual, inscricaoMunicipal, nomeFantasia, razaoSocial, end, cn, prod, contato);
		forn.setId(fornecedorId);
		
		fornControl.edit(forn);
		
		System.out.println(forn.toString());
		
		response.sendRedirect("index.jsp");
	}
}

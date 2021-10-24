package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contato.Contato;
import endereco.Cidade;
import endereco.Endereco;
import endereco.Pais;
import endereco.UF;
import fornecedor.CNAE;
import fornecedor.Fornecedor;
import fornecedor.FornecedorController;
import fornecedor.Status;
import produto.Produto;
import produto.TipoProduto;

@WebServlet("/cadastrar/fornecedor")
public class CadastroFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FornecedorController fornControl = new FornecedorController();
		//FORNECEDOR]
		int cnpj = Integer.parseInt(request.getParameter("cnpj"));
		String inscricaoEstadual =  request.getParameter("inscricaoEstadual");
		String inscricaoMunicipal = request.getParameter("inscricaoMunicipal");
		String nomeFantasia = request.getParameter("nomeFantasia");
		String razaoSocial = request.getParameter("razaoSocial");
		
		//CNAE
		String cnae = request.getParameter("cnae");				
		CNAE cn = new CNAE(cnae);
		
		//ENDERECO		
		String endereco = request.getParameter("endereco");
		String bairro = request.getParameter("bairro");
		String numero = request.getParameter("numero");
		String cep = request.getParameter("cep");
		
		//CIDADE		
		String cidade = request.getParameter("cidade");
		
		//UF
		String uf = request.getParameter("uf");
		
		//PAIS
		String pais = request.getParameter("pais");
		
		Endereco end = new Endereco(endereco, bairro, numero, cep, new Cidade(cidade), new UF(uf), new Pais(pais));
		
		//COTATO
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		//PRODUTO
		String produto = request.getParameter("produto");
		String tipoProduto = request.getParameter("tipoProduto");
		
		Produto prod;
		if(tipoProduto == "PRODUTO") {
			prod = new Produto(produto, TipoProduto.PRODUTO);	
		}else {
			prod = new Produto(produto, TipoProduto.SERVICO);
		}
		
		Fornecedor forn = new Fornecedor(cnpj, inscricaoEstadual, inscricaoMunicipal, nomeFantasia, razaoSocial, end, cn, prod);
		
		fornControl.create(forn);
		
		System.out.println(forn.toString());			
		
		response.sendRedirect("../index.jsp");
	}

}
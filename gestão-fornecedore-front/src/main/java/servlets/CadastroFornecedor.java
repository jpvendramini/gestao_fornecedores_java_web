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
import endereco.UF;
import fornecedor.CNAE;
import fornecedor.Status;
import produto.Produto;

@WebServlet("/cadastrar/fornecedor")
public class CadastroFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//FORNECEDOR
		int cnpj = Integer.parseInt(request.getParameter("cnpj"));
		String inscricaoEstadual =  request.getParameter("inscricaoEstadual");
		String inscricaoMunicipal = request.getParameter("inscricaoMunicipal");
		String nomeFantasia = request.getParameter("nomeFantasia");
		String razaoSocial = request.getParameter("razaoSocial");

		//CNAE
		String cnae = request.getParameter("cnae");
		
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
		
		//COTATO
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		//PRODUTO
		String produto = request.getParameter("produto");
		String tipoProduto = request.getParameter("tipoProduto");
	}

}

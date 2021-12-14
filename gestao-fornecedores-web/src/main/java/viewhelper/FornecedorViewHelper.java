package viewhelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import application.Dominio;
import application.Resultado;
import dao.FornecedorDAO;
import dominio.CNAE;
import dominio.Cidade;
import dominio.Contato;
import dominio.Email;
import dominio.Endereco;
import dominio.Fornecedor;
import dominio.Pais;
import dominio.Produto;
import dominio.Telefone;
import dominio.TipoProduto;
import dominio.TipoTelefone;
import dominio.UF;
import facade.Fachada;

public class FornecedorViewHelper implements IViewHelper{

	@Override
	public Dominio getDominio(HttpServletRequest request) {							
		//CASO ALTERAR
		String operacao = request.getParameter("operacao");	
		
		if(operacao.equals("REMOVER")) {
			long id = Long.parseLong(request.getParameter("id"));
			Fachada dao = new Fachada();
			Fornecedor f = dao.getById(id);
			return f;
		}
		
		if(operacao.equals("EXIBIR")) {
			return null;
		}
		
		System.out.println(operacao);
		
		String cnpj = request.getParameter("cnpj");
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
		String ddd = request.getParameter("ddd");
		String codigo= request.getParameter("codigo");
		String telefone = request.getParameter("telefone");
		
		Telefone tel = new Telefone(ddd, codigo, telefone, TipoTelefone.CELULAR);
		Email eml = new Email();
		eml.setDescricao(email);
		Contato contato = new Contato(eml, tel);
		
		//PRODUTO
		String produto = request.getParameter("produto");
		String tipoProduto = request.getParameter("tipoProduto");				
		
		Produto prod = null;
		if(tipoProduto != null) {
			if(tipoProduto.equals("produto")) {
				prod = new Produto(produto, TipoProduto.PRODUTO);	
			}else {
				prod = new Produto(produto, TipoProduto.SERVICO);
			}		
		}
						
		Fornecedor forn = new Fornecedor(cnpj, inscricaoEstadual, inscricaoMunicipal, nomeFantasia, razaoSocial, end, cn, prod, contato);
		
		if(operacao.equals("ALTERAR")) {			
			try {
				Long emailId = Long.parseLong(request.getParameter("emailId"));
				Long telefoneId = Long.parseLong(request.getParameter("telefoneId"));
				
				forn.getContato().getEmail().setId(emailId);
				forn.getContato().getTelefone().setId(telefoneId);
				
				Long cnaeId = Long.parseLong(request.getParameter("cnaeId"));
				cn.setId(cnaeId);
				
				Long endId = Long.parseLong(request.getParameter("endId"));
				end.setId(endId);
				
				Long cidadeId = Long.parseLong(request.getParameter("cidadeId"));
				forn.getEndereco().getCidade().setId(cidadeId);
				
				Long ufId = Long.parseLong(request.getParameter("ufId"));
				forn.getEndereco().getUf().setId(ufId);
				
				Long paisId = Long.parseLong(request.getParameter("paisId"));
				forn.getEndereco().getPais().setId(paisId);		
				
				Long produtoId = Long.parseLong(request.getParameter("produtoId"));				
				prod.setId(produtoId);
			}catch(NumberFormatException | NullPointerException e) {
				e.getStackTrace();
			}
			
			Long id = Long.parseLong(request.getParameter("id"));
			forn.setId(id);
			System.out.println("That is the id: " + id);					
		}		
		
		return forn;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = null;
		
		String operacao = request.getParameter("operacao");						
		
		if(resultado.getMessage() == null) {
			d = request.getRequestDispatcher("index.jsp");
		}
		
		if(resultado.getMessage() == null && operacao.equals("SALVAR")) {
			resultado.setMessage("Entidade salva com sucesso!");
			request.setAttribute("message", "success");
			d = request.getRequestDispatcher("index.jsp");
		}
		
		if(resultado.getMessage() == null && operacao.equals("ALTERAR")) {			
			response.sendRedirect("/gestao-fornecedores-web/Fornecedor?operacao=EXIBIR");
		}	
		
		if(resultado.getMessage() != null){
			d = request.getRequestDispatcher("index.jsp");
		}	
		
		if(resultado.getMessage() != null && operacao.equals("ALTERAR")) {						
			request.setAttribute("id", resultado.getDominios().get(0).getId());
			
			resultado.setMessage("Entidade alterada com sucesso!");
			d = request.getRequestDispatcher("/src/Alteracao.jsp");
			d.forward(request, response);	
		}
		
		if(resultado.getMessage() == null && operacao.equals("REMOVER")) {
			response.sendRedirect("/gestao-fornecedores-web/Fornecedor?operacao=EXIBIR");
//			d = request.getRequestDispatcher("src/consultar.jsp");
		}
		
		if(resultado.getMessage() == null && operacao.equals("EXIBIR")) {
			request.setAttribute("resultado", resultado.getDominios());
			d = request.getRequestDispatcher("src/consultar.jsp");			
		}
		if(!operacao.equals("REMOVER") && !operacao.equals("ALTERAR")) {
			d.forward(request, response);	
		}						
	}
}

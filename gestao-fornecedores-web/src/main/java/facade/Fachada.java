package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.Dominio;
import application.Resultado;
import dao.CNAEDAO;
import dao.ContatoDAO;
import dao.EnderecoDAO;
import dao.FornecedorDAO;
import dao.IDAO;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import dominio.CNAE;
import dominio.Fornecedor;
import dominio.Produto;
import dominio.Usuario;
import strategy.IStrategy;
import strategy.ValidadorDadosAlterar;
import strategy.ValidarCNAE;
import strategy.ValidarCNPJ;
import strategy.ValidarDadosFornecedor;
import strategy.ValidarEndereco;
import strategy.ValidarTelefone;

public class Fachada implements IFacade<Dominio>{
	Resultado resultado = null;
	FornecedorDAO fornecedorDAO = new FornecedorDAO();
	Map<String, IDAO> daos;
	Map<String, Map<String, List<IStrategy>>> rns;
	
	public Fachada() {
		daos = new HashMap<String,IDAO>();
		rns = new HashMap<String, Map<String, List<IStrategy>>>();
		
		ValidarCNAE validaCnae = new ValidarCNAE();
		ValidarCNPJ validaCNPJ = new ValidarCNPJ();
		ValidarDadosFornecedor validarDadosFornecedor = new ValidarDadosFornecedor();
		ValidarEndereco validaEndereco = new ValidarEndereco();
		ValidarTelefone validaTelefone = new ValidarTelefone();
		
		ValidadorDadosAlterar dadosAlterar = new ValidadorDadosAlterar();
		
		List<IStrategy> rnsSalvarFornecedor = new ArrayList<IStrategy>();
		rnsSalvarFornecedor.add(validaCnae);
		rnsSalvarFornecedor.add(validaCNPJ);
		rnsSalvarFornecedor.add(validarDadosFornecedor);
		rnsSalvarFornecedor.add(validaEndereco);
		rnsSalvarFornecedor.add(validaTelefone);
		
		List<IStrategy> rnsAlterarFornecedor = new ArrayList<IStrategy>();
		rnsAlterarFornecedor.add(dadosAlterar);
		
		Map<String, List<IStrategy>> rnsFornecedor = new HashMap<String, List<IStrategy>>();
		rnsFornecedor.put("SALVAR", rnsSalvarFornecedor);
		rnsFornecedor.put("ALTERAR", rnsAlterarFornecedor);		
		
		rns.put(Fornecedor.class.getName(), rnsFornecedor);
		
		
		//DAOS		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
				
		daos.put(Fornecedor.class.getName(), fornecedorDAO);
		daos.put(Usuario.class.getName(), usuarioDAO);
	}

	
	@Override
	public Resultado create(Dominio dominio) {		
		String className = dominio.getClass().getName();
		
		resultado = new Resultado();
		
		String message = executarRegras(dominio, "SALVAR");	
		
		if(message == null) {
			IDAO dao = daos.get(className);
			dao.create(dominio);			
			List<Dominio> dominios = new ArrayList<Dominio>();
			dominios.add(dominio);
			resultado.setDominios(dominios);
			System.out.println("Fornecedor cadastrado com sucesso!");
		}else {
			resultado.setMessage(message);	
			System.out.println(message);
		}		
		return resultado;
	}

	@Override
	public Resultado delete(Dominio dominio) {
		String className = dominio.getClass().getName();
		IDAO dao = daos.get(className);				
		resultado = new Resultado();
		dao.delete(dominio);		
		List<Dominio> dominios = new ArrayList<Dominio>();
		dominios.add(dominio);
		resultado.setDominios(dominios);
		return resultado;
	}

	@Override
	public Resultado findAll() {	
		resultado = new Resultado();
		List<Dominio> dominios = fornecedorDAO.findAll();		
		resultado.setDominios(dominios);
		return resultado;
	}

	@Override
	public Resultado edit(Dominio dominio) {	
		String className = dominio.getClass().getName();
		IDAO dao = daos.get(className);	
		
		resultado = new Resultado();
		String message = executarRegras(dominio, "ALTERAR");
		List<Dominio> dominios = new ArrayList<Dominio>();
		
		if(message == null) {
			dao.edit(dominio);		
			dominios.add(dominio);
			resultado.setDominios(dominios);			
		}else {
			dominios.add(dominio);
			resultado.setMessage(message);
			resultado.setDominios(dominios);
		}
		
		return resultado;
	}
	
	public Fornecedor getById(Long id) {
		return fornecedorDAO.findById(id);
	}
	
	private String executarRegras(Dominio dominio, String operacao) {
		String className = dominio.getClass().getName();
		StringBuilder message = new StringBuilder();
		
		Map<String, List<IStrategy>> regrasOperacao = rns.get(className);
		
		if(regrasOperacao != null) {
			List<IStrategy> regras = regrasOperacao.get(operacao);
			for(IStrategy s : regras) {
				if(s.processar(dominio) != null) {
					message.append(s.processar(dominio));
					message.append('\n');
				}
			}
		}
		
		if(message.length() > 0) {
			return message.toString();
		}else {
			return null;
		}
	}

}

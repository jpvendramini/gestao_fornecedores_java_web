package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.Dominio;
import application.Resultado;
import command.AlterarFornecedorCommand;
import command.ExibirFornecedorCommand;
import command.ICommand;
import command.RemoverFornecedorCommand;
import command.SalvarFornecedorCommand;
import viewhelper.FornecedorViewHelper;
import viewhelper.IViewHelper;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Map<String, ICommand> commands;
	private static Map<String, IViewHelper> vhs;
	
	public Controller() {
		commands = new HashMap<String, ICommand>();
		
		commands.put("SALVAR", new SalvarFornecedorCommand());
		commands.put("ALTERAR", new AlterarFornecedorCommand());
		commands.put("REMOVER", new RemoverFornecedorCommand());
		commands.put("EXIBIR", new ExibirFornecedorCommand());		
		
		vhs = new HashMap<String, IViewHelper>();
		
		vhs.put("/gestao-fornecedores-web/Fornecedor", new FornecedorViewHelper());		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcessRequest(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doProcessRequest(request, response);
	}
	
	protected void doProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();		
		
		IViewHelper vh = vhs.get(uri);
		
		Dominio dominio = vh.getDominio(request);
		
		String operacao = request.getParameter("operacao");
		
		ICommand command = commands.get(operacao);
		
		Resultado resultado = command.execute(dominio);
		
		vh.setView(resultado, request, response);	
	}

}

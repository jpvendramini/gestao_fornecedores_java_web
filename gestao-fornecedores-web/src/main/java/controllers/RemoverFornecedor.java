package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fornecedor.Fornecedor;
import fornecedor.FornecedorFacade;

@WebServlet("/RemoverFornecedor")
public class RemoverFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FornecedorFacade fornControl = new FornecedorFacade();
		long id = Long.parseLong(request.getParameter("id"));
		System.out.println(id);
		request.setAttribute("id", id);
		Fornecedor f = fornControl.getById(id);
		fornControl.delete(f);
		System.out.println("Fornecedor removido");
		response.sendRedirect("src/remover.jsp");				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

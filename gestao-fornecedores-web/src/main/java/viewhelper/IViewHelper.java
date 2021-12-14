package viewhelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.Dominio;
import application.Resultado;

public interface IViewHelper {
	public Dominio getDominio(HttpServletRequest request);
	
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
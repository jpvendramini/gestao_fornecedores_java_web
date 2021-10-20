package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		switch (flag) {
		case "signin": {
			if(username != null && password != null) {
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("src/login.jsp").forward(request, response);
			}	
			break;
		}
		case "signup": {
			
			break;
		}
		default:
			request.getRequestDispatcher("src/login.jsp").forward(request, response);
		}
	}

}

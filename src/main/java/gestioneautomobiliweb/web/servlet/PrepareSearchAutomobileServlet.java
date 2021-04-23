package gestioneautomobiliweb.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneautomobiliweb.model.Automobile;

@WebServlet("/PrepareSearchAutomobileServlet")
public class PrepareSearchAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("userInfo") == null) {
			request.setAttribute("errorMessage", "La sessione è scaduta. Effettuare nuovamente l'accesso.");
			response.sendRedirect("login.jsp");
		}

		Automobile automobile = new Automobile();

		request.setAttribute("search_automobile_attr", automobile);

		request.getRequestDispatcher("/automobile/search.jsp").forward(request, response);

	}
}

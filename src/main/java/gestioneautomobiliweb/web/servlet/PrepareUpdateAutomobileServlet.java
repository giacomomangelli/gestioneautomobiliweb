package gestioneautomobiliweb.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneautomobiliweb.service.MyServiceFactory;

@WebServlet("/PrepareUpdateAutomobileServlet")
public class PrepareUpdateAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("userInfo") == null) {
			request.setAttribute("errorMessage", "La sessione è scaduta. Effettuare nuovamente l'accesso.");
			response.sendRedirect("login.jsp");
		}

		String idAutomobileParameter = request.getParameter("idAutomobile");

		try {
			request.setAttribute("update_automobile_attr", MyServiceFactory.getAutomobileServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idAutomobileParameter)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/search.jsp").forward(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/automobile/update.jsp");
		rd.forward(request, response);
	}
}

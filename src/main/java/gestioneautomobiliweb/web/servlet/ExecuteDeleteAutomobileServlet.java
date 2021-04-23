package gestioneautomobiliweb.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneautomobiliweb.model.Automobile;
import gestioneautomobiliweb.service.MyServiceFactory;
import gestioneautomobiliweb.service.automobile.IAutomobileService;

@WebServlet("/ExecuteDeleteAutomobileServlet")
public class ExecuteDeleteAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("userInfo") == null) {
			request.setAttribute("errorMessage", "La sessione è scaduta. Effettuare nuovamente l'accesso.");
			response.sendRedirect("login.jsp");
		}

		String automobileIdParameter = request.getParameter("idAutomobile");

		try {

			IAutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
			Automobile automobile = automobileService.caricaSingoloElemento(Long.parseLong(automobileIdParameter));
			automobileService.rimuovi(automobile);
			request.getRequestDispatcher("/automobile/search.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/search.jsp").forward(request, response);
			return;
		}
	}
}
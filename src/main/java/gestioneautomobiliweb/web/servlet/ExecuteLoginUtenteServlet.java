package gestioneautomobiliweb.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import gestioneautomobiliweb.model.Automobile;
import gestioneautomobiliweb.model.StatoUtente;
import gestioneautomobiliweb.model.Utente;
import gestioneautomobiliweb.service.MyServiceFactory;

@WebServlet("/ExecuteLoginUtenteServlet")
public class ExecuteLoginUtenteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usernameUtenteParameter = request.getParameter("inputUsername");
		String passwordUtenteParameter = request.getParameter("inputPassword");

		if (StringUtils.isBlank(usernameUtenteParameter) || StringUtils.isBlank(passwordUtenteParameter)) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di inserimento");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		try {

			Utente utente = MyServiceFactory.getUtenteServiceInstance()
					.findByNomeUtenteEPassword(usernameUtenteParameter, passwordUtenteParameter);

			if (utente == null || !utente.getStato().equals(StatoUtente.ATTIVO)) {
				request.setAttribute("errorMessage",
						"Attenzione non è stato possibile effettuare l'accesso. Il suo accout e' inesistente o disabilitato.");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}

			utente.setPassword("xxxxxxxx");
			request.getSession().setAttribute("userInfo", utente);
			request.setAttribute("utente_logged_attr", utente);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		Automobile automobile = new Automobile();
		request.setAttribute("search_automobile_attr", automobile);
		request.getRequestDispatcher("/automobile/search.jsp").forward(request, response);
	}

}

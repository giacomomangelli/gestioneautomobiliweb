package gestioneautomobiliweb.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneautomobiliweb.model.Automobile;
import gestioneautomobiliweb.service.MyServiceFactory;
import gestioneautomobiliweb.utility.UtilityAutomobileForm;

@WebServlet("/ExecuteInsertAutomobileServlet")
public class ExecuteInsertAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("userInfo") == null) {
			request.setAttribute("errorMessage", "La sessione è scaduta. Effettuare nuovamente l'accesso.");
			response.sendRedirect("login.jsp");
		}

		String marcaAutomobileParameter = request.getParameter("marcaInsert");
		String modelloAutomobileParameter = request.getParameter("modelloInsert");
		String cilindrataAutomobileParameter = request.getParameter("cilindrataInsert");
		String dataImmatricolazioneAutomobileParameter = request.getParameter("dataDiImmatricolazioneInsert");

		Date dataPubblicazioneLibroParsed = UtilityAutomobileForm
				.parseDataImmatricolazioneFromString(dataImmatricolazioneAutomobileParameter);

		Automobile automobileInsert = UtilityAutomobileForm.createBin(marcaAutomobileParameter,
				modelloAutomobileParameter, cilindrataAutomobileParameter, dataImmatricolazioneAutomobileParameter);

		if (!UtilityAutomobileForm.validateInput(marcaAutomobileParameter, modelloAutomobileParameter,
				cilindrataAutomobileParameter, dataImmatricolazioneAutomobileParameter)
				|| dataPubblicazioneLibroParsed == null) {
			request.setAttribute("insert_automobile_attr", automobileInsert);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/automobile/insert.jsp").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getAutomobileServiceInstance().inserisciNuovo(automobileInsert);
			request.setAttribute("listaAutomobiliAttribute", MyServiceFactory.getAutomobileServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/insert.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/automobile/list.jsp").forward(request, response);

	}

}

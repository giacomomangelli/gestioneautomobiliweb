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
import gestioneautomobiliweb.utility.UtilityAutomobileForm;

@WebServlet("/ExecuteUpdateAutomobileServlet")
public class ExecuteUpdateAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("userInfo") == null) {
			request.setAttribute("errorMessage", "La sessione è scaduta. Effettuare nuovamente l'accesso.");
			response.sendRedirect("login.jsp");
		}

		String automobileIdParameter = request.getParameter("idAutomobileEdit");
		String marcaAutomobileParameter = request.getParameter("marcaEdit");
		String modelloAutomobileParameter = request.getParameter("modelloEdit");
		String cilindrataAutomobileParameter = request.getParameter("cilindrataEdit");
		String dataImmatricolazioneAutomobileParameter = request.getParameter("dataDiImmatricolazioneEdit");

		Automobile automobileEdit = UtilityAutomobileForm.createBin(marcaAutomobileParameter,
				modelloAutomobileParameter, cilindrataAutomobileParameter, dataImmatricolazioneAutomobileParameter);

		if (!UtilityAutomobileForm.validateInput(marcaAutomobileParameter, modelloAutomobileParameter,
				cilindrataAutomobileParameter, dataImmatricolazioneAutomobileParameter)
				|| dataImmatricolazioneAutomobileParameter == null) {

			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.setAttribute("update_automobile_attr", automobileEdit);
			request.getRequestDispatcher("/automobile/update.jsp").forward(request, response);
			return;
		}

		try {

			IAutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
			Automobile automobile = automobileService.caricaSingoloElemento(Long.parseLong(automobileIdParameter));

			automobile.setMarca(automobileEdit.getMarca());
			automobile.setModello(automobileEdit.getModello());
			automobile.setDataDiImmatricolazione(automobileEdit.getDataDiImmatricolazione());
			automobile.setCilindrata(automobileEdit.getCilindrata());

			automobileService.aggiorna(automobile);

			request.getRequestDispatcher("/automobile/search.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/search.jsp").forward(request, response);
			return;
		}
	}
}

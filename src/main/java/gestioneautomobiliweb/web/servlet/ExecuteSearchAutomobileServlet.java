package gestioneautomobiliweb.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import gestioneautomobiliweb.model.Automobile;
import gestioneautomobiliweb.service.MyServiceFactory;
import gestioneautomobiliweb.utility.UtilityAutomobileForm;

@WebServlet("/ExecuteSearchAutomobileServlet")
public class ExecuteSearchAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("userInfo") == null) {
			request.setAttribute("errorMessage", "La sessione è scaduta. Effettuare nuovamente l'accesso.");
			response.sendRedirect("login.jsp");
		}

		String marcaAutomobileParameter = request.getParameter("marcaSearch");
		String modelloAutomobileParameter = request.getParameter("modelloSearch");
		String cilindrataAutomobileParameter = request.getParameter("cilindrataSearch");
		String dataDiImmatricolazioneAutomobileParameter = request.getParameter("dataDiImmatricolazioneSearch");

		try {

			request.setAttribute("listaAutomobiliAttribute",
					MyServiceFactory.getAutomobileServiceInstance()
							.findByExample(automobileToSearch(marcaAutomobileParameter, modelloAutomobileParameter,
									cilindrataAutomobileParameter, dataDiImmatricolazioneAutomobileParameter)));

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/search.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/automobile/list.jsp").forward(request, response);
	}

	private Automobile automobileToSearch(String marcaAutomobileParameter, String modelloAutomobileParameter,
			String cilindrataAutomobileParameter, String dataDiImmatricolazioneAutomobileParameter) {

		Automobile automobile = new Automobile();

		if (!StringUtils.isBlank(marcaAutomobileParameter)) {
			automobile.setMarca(marcaAutomobileParameter);
		}
		if (!StringUtils.isBlank(modelloAutomobileParameter)) {
			automobile.setModello(modelloAutomobileParameter);
		}
		if (UtilityAutomobileForm.validateIntCilindrata(cilindrataAutomobileParameter)) {
			automobile.setCilindrata(Integer.parseInt(cilindrataAutomobileParameter));
		}
		if (!StringUtils.isBlank(dataDiImmatricolazioneAutomobileParameter)) {
			automobile.setDataDiImmatricolazione(UtilityAutomobileForm
					.parseDataImmatricolazioneFromString(dataDiImmatricolazioneAutomobileParameter));
		}
		return automobile;
	}

}

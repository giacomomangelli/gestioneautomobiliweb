package gestioneautomobiliweb.service;

import gestioneautomobiliweb.dao.automobile.AutomobileDaoImpl;
import gestioneautomobiliweb.dao.automobile.IAutomobileDao;
import gestioneautomobiliweb.dao.utente.IUtenteDao;
import gestioneautomobiliweb.dao.utente.UtenteDaoImpl;
import gestioneautomobiliweb.service.automobile.AutomobileServiceImpl;
import gestioneautomobiliweb.service.automobile.IAutomobileService;
import gestioneautomobiliweb.service.utente.IUtenteService;
import gestioneautomobiliweb.service.utente.UtenteServiceImpl;

public class MyServiceFactory {

	private static IAutomobileService automobileServiceInstance = null;
	private static IAutomobileDao automobileDaoInstance = null;
	private static IUtenteService utenteServiceInstance = null;
	private static IUtenteDao utenteDaoInstance = null;

	public static IAutomobileService getAutomobileServiceInstance() {
		if (automobileServiceInstance == null) {
			automobileServiceInstance = new AutomobileServiceImpl();
		}

		if (automobileDaoInstance == null) {
			automobileDaoInstance = new AutomobileDaoImpl();
		}

		automobileServiceInstance.setAutomobileDao(automobileDaoInstance);

		return automobileServiceInstance;
	}

	public static IUtenteService getUtenteServiceInstance() {
		if (utenteServiceInstance == null) {
			utenteServiceInstance = new UtenteServiceImpl();
		}

		if (utenteDaoInstance == null) {
			utenteDaoInstance = new UtenteDaoImpl();
		}

		utenteServiceInstance.setUtenteDao(utenteDaoInstance);

		return utenteServiceInstance;
	}

}

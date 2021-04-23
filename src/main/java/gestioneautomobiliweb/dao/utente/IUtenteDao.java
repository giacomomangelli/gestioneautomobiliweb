package gestioneautomobiliweb.dao.utente;

import gestioneautomobiliweb.dao.IBaseDAO;
import gestioneautomobiliweb.model.Utente;

public interface IUtenteDao extends IBaseDAO<Utente> {

	public Utente findByUsernameAndPassword(String usernameInput, String passwordInput) throws Exception;

}

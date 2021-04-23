package gestioneautomobiliweb.service.utente;

import java.util.List;

import gestioneautomobiliweb.dao.utente.IUtenteDao;
import gestioneautomobiliweb.model.Utente;

public interface IUtenteService {

	public void setUtenteDao(IUtenteDao utenteDaoInstance);

	public List<Utente> listAll() throws Exception;

	public Utente caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Utente utenteInput) throws Exception;

	public void inserisciNuovo(Utente utenteInput) throws Exception;

	public void rimuovi(Utente utenteInput) throws Exception;

	public Utente findByNomeUtenteEPassword(String usernameInput, String passwordInput) throws Exception;

}

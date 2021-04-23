package gestioneautomobiliweb.service.utente;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import gestioneautomobiliweb.dao.utente.IUtenteDao;
import gestioneautomobiliweb.model.Utente;
import gestioneautomobiliweb.web.listener.LocalEntityManagerFactoryListener;

public class UtenteServiceImpl implements IUtenteService {

	private IUtenteDao utenteDaoInstance;

	@Override
	public void setUtenteDao(IUtenteDao utenteDaoInstance) {
		this.utenteDaoInstance = utenteDaoInstance;
	}

	@Override
	public List<Utente> listAll() throws Exception {

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			utenteDaoInstance.setEntityManager(entityManager);
			return utenteDaoInstance.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}
	}

	@Override
	public Utente caricaSingoloElemento(Long idInput) throws Exception {

		if (idInput < 1 || idInput == null) {
			throw new Exception("Errore inserimento idInput service per caricare l'elemento.");
		}

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			utenteDaoInstance.setEntityManager(entityManager);
			return utenteDaoInstance.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}

	}

	@Override
	public void aggiorna(Utente utenteInput) throws Exception {

		if (utenteInput == null) {
			throw new Exception("Errore inserimento utenteInput service per aggiornare l'elemento.");
		}

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			utenteDaoInstance.setEntityManager(entityManager);
			utenteDaoInstance.update(utenteInput);

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}
	}

	@Override
	public void inserisciNuovo(Utente utenteInput) throws Exception {

		if (utenteInput == null) {
			throw new Exception("Errore inserimento utenteInput service per inserire nuovo elemento.");
		}

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			utenteDaoInstance.setEntityManager(entityManager);
			utenteDaoInstance.insert(utenteInput);

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}
	}

	@Override
	public void rimuovi(Utente utenteInput) throws Exception {

		if (utenteInput == null) {
			throw new Exception("Errore inserimento utenteInput service per rimuovere l'elemento.");
		}

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			utenteDaoInstance.setEntityManager(entityManager);
			entityManager.merge(utenteInput);
			utenteDaoInstance.delete(utenteInput);

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}
	}

	@Override
	public Utente findByNomeUtenteEPassword(String usernameInput, String passwordInput) throws Exception {

		if (StringUtils.isBlank(passwordInput) || StringUtils.isBlank(usernameInput)) {
			throw new Exception("Errore inserimento username e password service per trovare l'elemento.");
		}

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			utenteDaoInstance.setEntityManager(entityManager);
			return utenteDaoInstance.findByUsernameAndPassword(usernameInput, passwordInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}

	}

}

package gestioneautomobiliweb.dao.utente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import gestioneautomobiliweb.model.Utente;

public class UtenteDaoImpl implements IUtenteDao {

	EntityManager entityManager;

	@Override
	public List<Utente> list() throws Exception {
		TypedQuery<Utente> query = entityManager.createQuery("from Utente ", Utente.class);
		return query.getResultList();
	}

	@Override
	public Utente get(Long idInput) throws Exception {
		if (idInput < 1) {
			throw new Exception("Errore inserimento id get utente.");
		}
		return entityManager.find(Utente.class, idInput);
	}

	@Override
	public void update(Utente utenteInput) throws Exception {
		if (utenteInput == null) {
			throw new Exception("Errore inserimento input update utente.");
		}
		entityManager.merge(utenteInput);
	}

	@Override
	public void insert(Utente utenteInput) throws Exception {
		if (utenteInput == null) {
			throw new Exception("Errore inserimento input insert utente.");
		}
		entityManager.persist(utenteInput);
	}

	@Override
	public void delete(Utente utenteInput) throws Exception {
		if (utenteInput == null) {
			throw new Exception("Errore inserimento input delete utente.");
		}
		entityManager.remove(entityManager.merge(utenteInput));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Utente findByUsernameAndPassword(String usernameInput, String passwordInput) throws Exception {

		Utente utente = null;
		TypedQuery<Utente> query = entityManager
				.createQuery("select u from Utente u where u.username = ?1 and u.password = ?2 ", Utente.class);
		query.setParameter(1, usernameInput);
		query.setParameter(2, passwordInput);
		try {
			utente = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		return utente;

	}

}

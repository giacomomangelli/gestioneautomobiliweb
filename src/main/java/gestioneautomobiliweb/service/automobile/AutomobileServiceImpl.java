package gestioneautomobiliweb.service.automobile;

import java.util.List;

import javax.persistence.EntityManager;

import gestioneautomobiliweb.dao.automobile.IAutomobileDao;
import gestioneautomobiliweb.model.Automobile;
import gestioneautomobiliweb.web.listener.LocalEntityManagerFactoryListener;

public class AutomobileServiceImpl implements IAutomobileService {

	private IAutomobileDao automobileDaoInstance;

	@Override
	public void setAutomobileDao(IAutomobileDao automobileDaoInstance) {
		this.automobileDaoInstance = automobileDaoInstance;
	}

	@Override
	public List<Automobile> listAll() throws Exception {

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			automobileDaoInstance.setEntityManager(entityManager);
			return automobileDaoInstance.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}
	}

	@Override
	public Automobile caricaSingoloElemento(Long idInput) throws Exception {

		if (idInput < 1 || idInput == null) {
			throw new Exception("Errore inserimento idInput service per caricare l'elemento.");
		}

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			automobileDaoInstance.setEntityManager(entityManager);
			return automobileDaoInstance.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}

	}

	@Override
	public void aggiorna(Automobile automobileInput) throws Exception {

		if (automobileInput == null) {
			throw new Exception("Errore inserimento automobileInput service per aggiornare l'elemento.");
		}

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			automobileDaoInstance.setEntityManager(entityManager);
			automobileDaoInstance.update(automobileInput);

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
	public void inserisciNuovo(Automobile automobileInput) throws Exception {

		if (automobileInput == null) {
			throw new Exception("Errore inserimento automobileInput service per inserire nuovo elemento.");
		}

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			automobileDaoInstance.setEntityManager(entityManager);
			automobileDaoInstance.insert(automobileInput);

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
	public void rimuovi(Automobile automobileInput) throws Exception {

		if (automobileInput == null) {
			throw new Exception("Errore inserimento automobileInput service per rimuovere l'elemento.");
		}

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			automobileDaoInstance.setEntityManager(entityManager);
			entityManager.merge(automobileInput);
			automobileDaoInstance.delete(automobileInput);

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
	public List<Automobile> findByExample(Automobile automobileInput) throws Exception {

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			automobileDaoInstance.setEntityManager(entityManager);
			return automobileDaoInstance.findByExample(automobileInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}
	}
}

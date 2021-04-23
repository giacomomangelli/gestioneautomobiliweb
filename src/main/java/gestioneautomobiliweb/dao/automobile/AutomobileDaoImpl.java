package gestioneautomobiliweb.dao.automobile;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import gestioneautomobiliweb.model.Automobile;

public class AutomobileDaoImpl implements IAutomobileDao {

	private EntityManager entityManager;

	@Override
	public List<Automobile> list() throws Exception {
		TypedQuery<Automobile> query = entityManager.createQuery("from Automobile ", Automobile.class);
		return query.getResultList();
	}

	@Override
	public Automobile get(Long idInput) throws Exception {
		if (idInput < 1) {
			throw new Exception("Errore inserimento id get Automobile.");
		}
		return entityManager.find(Automobile.class, idInput);
	}

	@Override
	public void update(Automobile automobileInput) throws Exception {
		if (automobileInput == null) {
			throw new Exception("Errore inserimento input update Automobile.");
		}
		entityManager.merge(automobileInput);
	}

	@Override
	public void insert(Automobile automobileInput) throws Exception {
		if (automobileInput == null) {
			throw new Exception("Errore inserimento input insert Automobile.");
		}
		entityManager.persist(automobileInput);
	}

	@Override
	public void delete(Automobile automobileInput) throws Exception {
		if (automobileInput == null) {
			throw new Exception("Errore inserimento input delete Automobile.");
		}
		entityManager.remove(entityManager.merge(automobileInput));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Automobile> findByExample(Automobile automobileInput) throws Exception {

		if (automobileInput == null) {
			throw new Exception("Errore inserimento input findByExample Automobile.");
		}

		String composedQuery = "select a from Automobile a where 1=1";

		if (automobileInput.getCilindrata() != null && automobileInput.getCilindrata() >= 0) {
			composedQuery += "and a.cilindrata = " + automobileInput.getCilindrata();
		}
		if (!StringUtils.isBlank(automobileInput.getMarca())) {
			composedQuery += "and a.marca = '" + automobileInput.getMarca() + "'";
		}
		if (!StringUtils.isBlank(automobileInput.getModello())) {
			composedQuery += "and a.modello = '" + automobileInput.getModello() + "'";
		}
		if (automobileInput.getDataDiImmatricolazione() != null) {
			composedQuery += "and a.data_di_immatricolazione = '" + automobileInput.getDataDiImmatricolazione() + "'";
		}
		TypedQuery<Automobile> query = entityManager.createQuery(composedQuery, Automobile.class);
		return query.getResultList();

	}

}

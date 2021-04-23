package gestioneautomobiliweb.service.automobile;

import java.util.List;

import gestioneautomobiliweb.dao.automobile.IAutomobileDao;
import gestioneautomobiliweb.model.Automobile;

public interface IAutomobileService {

	public void setAutomobileDao(IAutomobileDao automobileDaoInstance);

	public List<Automobile> listAll() throws Exception;

	public Automobile caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Automobile automobileInput) throws Exception;

	public void inserisciNuovo(Automobile automobileInput) throws Exception;

	public void rimuovi(Automobile automobileInput) throws Exception;

	public List<Automobile> findByExample(Automobile automobileInput) throws Exception;

}

package gestioneautomobiliweb.dao.automobile;

import java.util.List;

import gestioneautomobiliweb.dao.IBaseDAO;
import gestioneautomobiliweb.model.Automobile;

public interface IAutomobileDao extends IBaseDAO<Automobile> {

	public List<Automobile> findByExample(Automobile automobileInput) throws Exception;

}

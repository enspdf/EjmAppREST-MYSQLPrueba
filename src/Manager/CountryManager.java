package Manager;

import java.util.List;

import Entities.City;
import Entities.Country;
import Entities.Department;
import Entities.Entity;

public interface CountryManager {

	List<Entity> getAllData() throws Exception;
	
	List<Country> getAllCountries() throws Exception;

	List<Entity> getCountriesByName(Entity entity) throws Exception;

	void saveCountry(Country country) throws Exception;

	void saveDepartments(Department department) throws Exception;

	void saveCities(City city) throws Exception;

}

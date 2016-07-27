package Manager;

import java.util.List;import javax.jws.soap.SOAPBinding.Use;

import Entities.City;
import Entities.Country;
import Entities.Department;
import Entities.Entity;
import Entities.User;

public interface CountryManager {

	List<Entity> getAllData() throws Exception;
	
	List<Country> getAllCountries() throws Exception;

	List<Entity> getCountriesByName(Entity entity) throws Exception;

	void saveCountry(Country country) throws Exception;

	void saveDepartments(Department department) throws Exception;

	void saveCities(City city) throws Exception;
	
	void saveUser(User user) throws Exception;

}

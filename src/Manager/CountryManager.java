package Manager;

import java.util.List;

import Entities.City;
import Entities.Country;
import Entities.Department;

public interface CountryManager {
	
	List<Country> getAllCountries() throws Exception;
	
	void saveCountry(Country country) throws Exception;
	
	void saveDepartments(Department department) throws Exception;
	
	void saveCities(City city) throws Exception;

}

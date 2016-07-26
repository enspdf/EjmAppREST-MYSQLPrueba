package Manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import DBConnection.ConnectionDatabase;
import Dao.CountryDaoJdbc;
import Entities.City;
import Entities.Country;
import Entities.Department;

public class CountryManagerImpl extends ConnectionDatabase implements CountryManager {
	
	CountryDaoJdbc Dao = new CountryDaoJdbc();

	@Override
	public List<Country> getAllCountries() throws Exception {
		List<Country> countries = new ArrayList<Country>();
		Connection connection = this.getConnection();
		countries = Dao.getCountries(connection);
		return countries;
	}

	@Override
	public void saveCountry(Country country) throws Exception {
		Connection connection = this.getConnection();
		Dao.saveCountry(connection, country);
	}

	@Override
	public void saveDepartments(Department department) throws Exception {
		Connection connection = this.getConnection();	
		Dao.saveDepartments(connection, department);
	}

	@Override
	public void saveCities(City city) throws Exception {
		Connection connection = this.getConnection();		
	}

}

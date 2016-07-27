package Manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import DBConnection.ConnectionDatabase;
import Dao.CountryDaoJdbc;
import Entities.City;
import Entities.Country;
import Entities.Department;
import Entities.Entity;
import Entities.User;

public class CountryManagerImpl extends ConnectionDatabase implements CountryManager {

	CountryDaoJdbc Dao = new CountryDaoJdbc();

	@Override
	public List<Entity> getAllData() throws Exception {
		List<Entity> allData = new ArrayList<Entity>();
		Connection connection = this.getConnection();
		allData = Dao.getAll(connection);
		return allData;
	}

	@Override
	public List<Country> getAllCountries() throws Exception {
		List<Country> countries = new ArrayList<Country>();
		Connection connection = this.getConnection();
		countries = Dao.getCountries(connection);
		return countries;
	}

	@Override
	public List<Entity> getCountriesByName(Entity entity) throws Exception {
		List<Entity> countriesName = new ArrayList<Entity>();
		Connection connection = this.getConnection();
		countriesName = Dao.getCountryByName(connection, entity);
		return countriesName;
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
		Dao.saveCities(connection, city);
	}
	
	@Override
	public void saveUser(User user) throws Exception {
		Connection connection = this.getConnection();
		Dao.saveUser(connection, user);
	}

}

package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Entities.City;
import Entities.Country;
import Entities.Department;
import Entities.Entity;
import Entities.User;

public interface CountryDao {

	List<Country> getCountries(Connection connection) throws SQLException;
	
	List<Entity> getAll(Connection connection) throws SQLException;
	
	List<Entity> getCountryByName(Connection connection, Entity entity) throws SQLException;

	void saveCountry(Connection connection, Country country) throws SQLException;
	
	void saveDepartments(Connection connection, Department department) throws SQLException;
	
	void saveCities(Connection connection, City city) throws SQLException;
	
	void saveUser(Connection connectin, User user) throws SQLException;

}

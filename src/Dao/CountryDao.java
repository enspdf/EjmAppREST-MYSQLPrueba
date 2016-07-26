package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Entities.City;
import Entities.Country;
import Entities.Department;

public interface CountryDao {

	List<Country> getCountries(Connection connection) throws SQLException;

	void saveCountry(Connection connection, Country country) throws SQLException;
	
	void saveDepartments(Connection connection, Department department) throws SQLException;
	
	void saveCities(Connection connection, City city) throws SQLException;

}

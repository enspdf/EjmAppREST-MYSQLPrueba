package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.City;
import Entities.Country;
import Entities.Department;

public class CountryDaoJdbc implements CountryDao {

	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;

	@Override
	public List<Country> getCountries(Connection connection) throws SQLException {
		List<Country> countryList = new ArrayList<Country>();
		preparedStatement = connection.prepareStatement("SELECT * FROM country");
		try {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Country country = new Country();
				country.setCountry_id(resultSet.getInt("country_id"));
				country.setCountry_name(resultSet.getString("country_name"));
				countryList.add(country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return countryList;
	}

	@Override
	public void saveCountry(Connection connection, Country country) throws SQLException {
		int index = 1;		
		preparedStatement = connection.prepareStatement("INSERT INTO country (country_name) VALUES (?)");
		preparedStatement.setString(index++, country.getCountry_name());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	public void saveDepartments(Connection connection, Department department) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("INSERT INTO department (country_id, department_name) VALUES (?,?)");
		preparedStatement.setInt(index++, department.getCountry_id());
		preparedStatement.setString(index++, department.getDepartment_name());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	public void saveCities(Connection connection, City city) throws SQLException {
		int index = 1;
	}

}

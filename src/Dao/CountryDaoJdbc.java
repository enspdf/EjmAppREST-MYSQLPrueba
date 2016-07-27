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
import Entities.Entity;
import Entities.User;

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
	public List<Entity> getAll(Connection connection) throws SQLException {
		List<Entity> allData = new ArrayList<Entity>();
		preparedStatement = connection.prepareStatement("SELECT * FROM country c LEFT JOIN department d ON c.country_id = d.country_id LEFT JOIN city ct ON d.department_id = ct.department_id");
		try {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Entity entityRes = new Entity();
				entityRes.getCountry().setCountry_name(resultSet.getString("country_name"));
				entityRes.getCountry().setCountry_id(resultSet.getInt("country_id"));
				entityRes.getDepartment().setDepartment_name(resultSet.getString("department_name"));
				entityRes.getDepartment().setCountry_id(resultSet.getInt("country_id"));
				entityRes.getDepartment().setDepartment_id(resultSet.getInt("department_id"));
				entityRes.getCity().setCity_name(resultSet.getString("city_name"));
				entityRes.getCity().setCity_id(resultSet.getInt("city_id"));
				entityRes.getCity().setDepartment_id(resultSet.getInt("department_id"));
				allData.add(entityRes);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return allData;
	}
	
	@Override
	public List<Entity> getCountryByName(Connection connection, Entity entity) throws SQLException {
		List<Entity> EntitiesFiltered = new ArrayList<Entity>();
		preparedStatement = connection.prepareStatement("SELECT * FROM country c INNER JOIN department d ON c.country_id = d.country_id INNER JOIN city ct ON d.department_id = ct.department_id WHERE c.country_name LIKE '%" + entity.getCountry().getCountry_name() + "%'");
		try {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Entity entityRes = new Entity();
				entityRes.getCountry().setCountry_name(resultSet.getString("country_name"));
				entityRes.getCountry().setCountry_id(resultSet.getInt("country_id"));
				entityRes.getDepartment().setDepartment_name(resultSet.getString("department_name"));
				entityRes.getDepartment().setCountry_id(resultSet.getInt("country_id"));
				entityRes.getDepartment().setDepartment_id(resultSet.getInt("department_id"));
				entityRes.getCity().setCity_name(resultSet.getString("city_name"));
				entityRes.getCity().setCity_id(resultSet.getInt("city_id"));
				entityRes.getCity().setDepartment_id(resultSet.getInt("department_id"));
				EntitiesFiltered.add(entityRes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return EntitiesFiltered;
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
		preparedStatement = connection.prepareStatement("INSERT INTO city (department_id, city_name) VALUES (?,?)");
		preparedStatement.setInt(index++, city.getDepartment_id());
		preparedStatement.setString(index++, city.getCity_name());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	@Override
	public void saveUser(Connection connection, User user) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("INSERT INTO user (username, password) VALUES (?,?)");
		preparedStatement.setString(index++, user.getUsername());
		preparedStatement.setString(index++, user.getPassword());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}

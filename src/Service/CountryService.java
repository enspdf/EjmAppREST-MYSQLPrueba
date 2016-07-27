package Service;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import Entities.City;
import Entities.Country;
import Entities.Department;
import Entities.Entity;
import Entities.User;
import Manager.CountryManagerImpl;
import Util.Crypter;

@Path("api")
public class CountryService {

	CountryManagerImpl countryManager = new CountryManagerImpl();
	Crypter crypto = new Crypter();

	@GET
	@Path("alldata")
	@Produces("application/json")
	public Response getAllData() throws Exception {
		List<Entity> data = countryManager.getAllData();
		String allData = new JSONArray(data).toString();
		return Response.status(200).entity(allData).build();
	}

	@GET
	@Path("countries")
	@Produces("application/json")
	public Response getAllCountries() throws Exception {
		List<Country> listCountries = countryManager.getAllCountries();
		String countries = new JSONArray(listCountries).toString();
		return Response.status(200).entity(countries).build();
	}

	@POST
	@Path("register")
	public Response registerUser(@FormParam("username") String username, @FormParam("password") String password)
			throws Exception {
		if (username == null || username.isEmpty())
			return Response.status(400).entity("The username is required").build();
		if (password == null || password.isEmpty())
			return Response.status(400).entity("The password is required").build();
		else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(crypto.crypto(password));
			countryManager.saveUser(user);
			return Response.status(201).entity("The user " + username + " was saved successfull").build();
		}
	}

	@POST
	@Path("countriesname")
	@Produces("application/json")
	public Response getCountriesByName(@FormParam("country_name") String country_name) throws Exception {
		Entity entity = new Entity();
		entity.getCountry().setCountry_name(country_name);
		List<Entity> entitiesFind = countryManager.getCountriesByName(entity);
		String countriesReq = new JSONArray(entitiesFind).toString();
		if (countriesReq == null || countriesReq.isEmpty())
			return Response.status(200).entity("No matched results with country: " + country_name).build();
		else
			return Response.status(200).entity(countriesReq).build();
	}

	@POST
	@Path("countries")
	public Response saveCountry(@FormParam("country_name") String country_name) throws Exception {
		if (country_name.isEmpty() || country_name == null)
			return Response.status(400).entity("The country name is required").build();
		else {
			Country countryReq = new Country();
			countryReq.setCountry_name(country_name);
			countryManager.saveCountry(countryReq);
			return Response.status(201).entity("The country with name " + country_name + " was added successfull")
					.build();
		}
	}

	@POST
	@Path("departments")
	public Response saveDepartment(@FormParam("country_id") int country_id,
			@FormParam("department_name") String department_name) throws Exception {
		if (country_id == 0 || country_id < 1)
			return Response.status(400).entity("The country_id is required").build();
		if (department_name == null || department_name.isEmpty())
			return Response.status(400).entity("The department_name is required").build();
		else {
			Department departmentReq = new Department();
			departmentReq.setCountry_id(country_id);
			departmentReq.setDepartment_name(department_name);
			countryManager.saveDepartments(departmentReq);
			return Response.status(201).entity("The department with name " + department_name + " was saved successfull")
					.build();
		}
	}

	@POST
	@Path("cities")
	public Response saveCities(@FormParam("department_id") int department_id, @FormParam("city_name") String city_name)
			throws Exception {
		if (department_id == 0 || department_id < 1)
			return Response.status(400).entity("The department_id is required").build();
		if (city_name == null || city_name.isEmpty())
			return Response.status(400).entity("The city_name is required").build();
		else {
			City cityReq = new City();
			cityReq.setDepartment_id(department_id);
			cityReq.setCity_name(city_name);
			countryManager.saveCities(cityReq);
			return Response.status(201).entity("The city with name " + city_name + " was saved successfull").build();
		}
	}

}

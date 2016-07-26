package Service;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import Entities.Country;
import Entities.Department;
import Manager.CountryManagerImpl;

@Path("api")
public class CountryService {

	CountryManagerImpl countryManager = new CountryManagerImpl();

	@GET
	@Path("countries")
	@Produces("application/json")
	public Response getAllCountries() throws Exception {
		List<Country> listCountries = countryManager.getAllCountries();
		String countries = new JSONArray(listCountries).toString();
		return Response.status(200).entity(countries).build();
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
			return Response.status(201).entity("The country with name " + country_name + " was added successfull").build();
		}
	}
	
	@POST
	@Path("departments")
	public Response saveDepartment(@FormParam("country_id") int country_id, @FormParam("department_name") String department_name) throws Exception {
		if (country_id == 0 || country_id < 1)
			return Response.status(400).entity("The country_id is required").build();
		if (department_name == null || department_name.isEmpty())
			return Response.status(400).entity("The department_name is required").build();
		else {
			Department departmentReq = new Department();
			departmentReq.setCountry_id(country_id);
			departmentReq.setDepartment_name(department_name);
			countryManager.saveDepartments(departmentReq);
			return Response.status(403).entity("The department with name " + department_name + " was saved successfull").build();
		}
	}

}

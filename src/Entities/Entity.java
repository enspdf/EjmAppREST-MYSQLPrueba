package Entities;

public class Entity {

	private Country country;
	private Department department;
	private City city;

	public Entity(Country country, Department department, City city) {
		super();
		this.country = country;
		this.department = department;
		this.city = city;
	}

	public Entity() {
		super();
	}

	public Country getCountry() {
		if (country == null) {
			country = new Country();
		}
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Department getDepartment() {
		if (department == null) {
			department = new Department();
		}
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public City getCity() {
		if (city == null) {
			city = new City();
		}
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Entity [country=" + country + ", department=" + department + ", city=" + city + "]";
	}

}

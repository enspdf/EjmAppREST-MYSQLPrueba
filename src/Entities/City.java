package Entities;

public class City {

	private int city_id;
	private int department_id;
	private String city_name;

	public City(int city_id, int department_id, String city_name) {
		super();
		this.city_id = city_id;
		this.department_id = department_id;
		this.city_name = city_name;
	}

	public City() {
		super();
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", department_id=" + department_id + ", city_name=" + city_name + "]";
	}

}

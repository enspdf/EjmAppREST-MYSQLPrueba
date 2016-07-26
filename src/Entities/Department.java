package Entities;

public class Department {

	private int country_id;
	private int department_id;
	private String department_name;

	public Department(int country_id, int department_id, String department_name) {
		super();
		this.country_id = country_id;
		this.department_id = department_id;
		this.department_name = department_name;
	}

	public Department() {
		super();
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	@Override
	public String toString() {
		return "Department [country_id=" + country_id + ", department_id=" + department_id + ", department_name="
				+ department_name + "]";
	}

}

package com.app.model;

public class Customer {
	private int customer_id;
	private String first_name;
	private String last_name;
	private long drivers_license;
	private String email;
	private String password;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customer_id, String first_name, String last_name, long drivers_license, String email,
			String password) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.drivers_license = drivers_license;
		this.email = email;
		this.password = password;
	}
	
	//Constructor without customer_id field to create new to record using serial auto increment for customer_id
	public Customer(String first_name, String last_name, long drivers_license, String email, String password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.drivers_license = drivers_license;
		this.email = email;
		this.password = password;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public long getDrivers_license() {
		return drivers_license;
	}

	public void setDrivers_license(long drivers_license) {
		this.drivers_license = drivers_license;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", drivers_license=" + drivers_license + ", email=" + email + ", password=" + password + "]";
	}
	
}

package com.app.model;

import java.sql.Date;

public class CustomerCars {
	private int car_id;
	private int customer_id;
	private Date date_purchased;
	private String make;
	private String model;
	private int year;
	private String color;

	public CustomerCars() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerCars(int car_id, int customer_id, Date date_purchased, String make, String model, int year,
			String color) {
		super();
		this.car_id = car_id;
		this.customer_id = customer_id;
		this.date_purchased = date_purchased;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Date getDate_purchased() {
		return date_purchased;
	}

	public void setDate_purchased(Date date_purchased) {
		this.date_purchased = date_purchased;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + car_id;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + customer_id;
		result = prime * result + ((date_purchased == null) ? 0 : date_purchased.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerCars other = (CustomerCars) obj;
		if (car_id != other.car_id)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (date_purchased == null) {
			if (other.date_purchased != null)
				return false;
		} else if (!date_purchased.equals(other.date_purchased))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerCars [car_id=" + car_id + ", customer_id=" + customer_id + ", date_purchased=" + date_purchased
				+ ", make=" + make + ", model=" + model + ", year=" + year + ", color=" + color + "]";
	}

}

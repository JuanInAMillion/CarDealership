package com.app.model;

public class CarLot {
	private int car_id;
	private String make;
	private String model;
	private int year;
	private String color;
	private String condition;
	private double price;
	private String status;
	private String owner;

	public CarLot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarLot(int car_id, String make, String model, int year, String color, String condition, double price,
			String status, String owner) {
		super();
		this.car_id = car_id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.condition = condition;
		this.price = price;
		this.status = status;
		this.owner = owner;
	}

	// Constructor without card_id to create new record using auto increment
	public CarLot(String make, String model, int year, String color, String condition, double price) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.condition = condition;
		this.price = price;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
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

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + car_id;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		CarLot other = (CarLot) obj;
		if (car_id != other.car_id)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
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
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarLot [car_id=" + car_id + ", make=" + make + ", model=" + model + ", year=" + year + ", color="
				+ color + ", condition=" + condition + ", price=" + price + ", status=" + status + ", owner=" + owner
				+ "]";
	}

}

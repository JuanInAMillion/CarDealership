package com.app.model;

public class CarLot {
	private int car_id;
	private String make;
	private String model;
	private int year;
	private String color;
	private String used;
	private double price;
	private String status;

	public CarLot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarLot(int car_id, String make, String model, int year, String color, String used, double price,
			String status) {
		super();
		this.car_id = car_id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.used = used;
		this.price = price;
		this.status = status;
	}

	// Constructor without card_id to create new record using auto increment
	public CarLot(String make, String model, int year, String color, String used, double price, String status) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.used = used;
		this.price = price;
		this.status = status;
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

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + car_id;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((used == null) ? 0 : used.hashCode());
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
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (used == null) {
			if (other.used != null)
				return false;
		} else if (!used.equals(other.used))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarLot [car_id=" + car_id + ", make=" + make + ", model=" + model + ", year=" + year + ", color="
				+ color + ", used=" + used + ", price=" + price + ", status=" + status + "]";
	}

}

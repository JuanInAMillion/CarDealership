package com.app.model;

import java.util.Date;

public class Offers {
	private int offer_id;
	private Date date;
	private int customer_id;
	private int car_id;
	private double offer_price;

	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offers(int offer_id, Date date, int customer_id, int car_id, double offer_price) {
		super();
		this.offer_id = offer_id;
		this.date = date;
		this.customer_id = customer_id;
		this.car_id = car_id;
		this.offer_price = offer_price;
	}

	// Constructor without bid_id to create new record using auto increment
	public Offers(Date date, int customer_id, int car_id, double offer_price) {
		super();
		this.date = date;
		this.customer_id = customer_id;
		this.car_id = car_id;
		this.offer_price = offer_price;
	}

	public int getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public double getOffer_price() {
		return offer_price;
	}

	public void setOffer_price(double offer_price) {
		this.offer_price = offer_price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + car_id;
		result = prime * result + customer_id;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + offer_id;
		long temp;
		temp = Double.doubleToLongBits(offer_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Offers other = (Offers) obj;
		if (car_id != other.car_id)
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (offer_id != other.offer_id)
			return false;
		if (Double.doubleToLongBits(offer_price) != Double.doubleToLongBits(other.offer_price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offers [offer_id=" + offer_id + ", date=" + date + ", customer_id=" + customer_id + ", car_id=" + car_id
				+ ", offer_price=" + offer_price + "]";
	}

}

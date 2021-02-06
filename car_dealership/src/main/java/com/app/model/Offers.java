package com.app.model;

import java.sql.Date;

public class Offers {
	private int offer_id;
	private Date offer_date;
	private int customer_id;
	private double offer_price;
	private int car_id;

	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offers(int offer_id, Date offer_date, int customer_id, double offer_price, int car_id) {
		super();
		this.offer_id = offer_id;
		this.offer_date = offer_date;
		this.customer_id = customer_id;
		this.offer_price = offer_price;
		this.car_id = car_id;
	}

	// Constructor without bid_id to create new record using auto increment
	public Offers(Date offer_date, int customer_id, double offer_price, int car_id) {
		super();
		this.offer_date = offer_date;
		this.customer_id = customer_id;
		this.offer_price = offer_price;
		this.car_id = car_id;
	}

	public int getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}

	public Date getOffer_date() {
		return offer_date;
	}

	public void setOffer_date(Date offer_date) {
		this.offer_date = offer_date;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public double getOffer_price() {
		return offer_price;
	}

	public void setOffer_price(double offer_price) {
		this.offer_price = offer_price;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + car_id;
		result = prime * result + customer_id;
		result = prime * result + ((offer_date == null) ? 0 : offer_date.hashCode());
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
		if (offer_date == null) {
			if (other.offer_date != null)
				return false;
		} else if (!offer_date.equals(other.offer_date))
			return false;
		if (offer_id != other.offer_id)
			return false;
		if (Double.doubleToLongBits(offer_price) != Double.doubleToLongBits(other.offer_price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offers [offer_id=" + offer_id + ", offer_date=" + offer_date + ", customer_id=" + customer_id
				+ ", offer_price=" + offer_price + ", car_id=" + car_id + "]";
	}

}

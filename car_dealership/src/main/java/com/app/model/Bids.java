package com.app.model;

import java.sql.Date;

public class Bids {
	private int bid_id;
	private Date bid_date;
	private int customer_id;
	private double bid_price;
	private int car_id;

	public Bids() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bids(int bid_id, Date bid_date, int customer_id, double bid_price, int car_id) {
		super();
		this.bid_id = bid_id;
		this.bid_date = bid_date;
		this.customer_id = customer_id;
		this.bid_price = bid_price;
		this.car_id = car_id;
	}

	// Constructor without bid_id to create new record using auto increment
	public Bids(Date bid_date, int customer_id, double bid_price, int car_id) {
		super();
		this.bid_date = bid_date;
		this.customer_id = customer_id;
		this.bid_price = bid_price;
		this.car_id = car_id;
	}

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	public Date getBid_date() {
		return bid_date;
	}

	public void setBid_date(Date bid_date) {
		this.bid_date = bid_date;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public double getBid_price() {
		return bid_price;
	}

	public void setBid_price(double bid_price) {
		this.bid_price = bid_price;
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
		result = prime * result + ((bid_date == null) ? 0 : bid_date.hashCode());
		result = prime * result + bid_id;
		long temp;
		temp = Double.doubleToLongBits(bid_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + car_id;
		result = prime * result + customer_id;
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
		Bids other = (Bids) obj;
		if (bid_date == null) {
			if (other.bid_date != null)
				return false;
		} else if (!bid_date.equals(other.bid_date))
			return false;
		if (bid_id != other.bid_id)
			return false;
		if (Double.doubleToLongBits(bid_price) != Double.doubleToLongBits(other.bid_price))
			return false;
		if (car_id != other.car_id)
			return false;
		if (customer_id != other.customer_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bids [bid_id=" + bid_id + ", bid_date=" + bid_date + ", customer_id=" + customer_id + ", bid_price="
				+ bid_price + ", car_id=" + car_id + "]";
	}

}

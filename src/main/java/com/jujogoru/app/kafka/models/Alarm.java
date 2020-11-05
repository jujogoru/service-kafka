package com.jujogoru.app.kafka.models;

import java.time.LocalDateTime;

import com.jujogoru.app.kafka.models.catalog.AlarmTypes;

public class Alarm {
	
	private String id;
	private String user;
	private String ticker;
	private double price;
	private AlarmTypes type;
	private LocalDateTime dateTime;
	private boolean status;
	
	public Alarm(){}

	public String getId() {
		return id;
	}

	public Alarm setId(String id) {
		this.id = id;
		return this;
	}

	public String getUser() {
		return user;
	}

	public Alarm setUser(String user) {
		this.user = user;
		return this;
	}

	public String getTicker() {
		return ticker;
	}

	public Alarm setTicker(String ticker) {
		this.ticker = ticker;
		return this;
	}

	public double getPrice() {
		return price;
	}

	public Alarm setPrice(double price) {
		this.price = price;
		return this;
	}

	public AlarmTypes getType() {
		return type;
	}

	public Alarm setType(AlarmTypes type) {
		this.type = type;
		return this;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public Alarm setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
		return this;
	}

	public boolean isStatus() {
		return status;
	}

	public Alarm setStatus(boolean status) {
		this.status = status;
		return this;
	}
	
	public Alarm(String user, String ticker, double price, AlarmTypes type, LocalDateTime dateTime,
			boolean status) {
		this.user = user;
		this.ticker = ticker;
		this.price = price;
		this.type = type;
		this.dateTime = dateTime;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Alarm [id=" + id + ", user=" + user + ", ticker=" + ticker + ", price=" + price + ", type=" + type
				+ ", dateTime=" + dateTime + ", status=" + status + "]";
	}

}

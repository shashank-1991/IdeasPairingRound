package com.org.hotel;

public class Hotel {
	private String hotelName;
	private Integer weekendRates;
	private Integer weekdayRates;
	
	public Hotel() {
		
	}
	
	public Hotel(String hotelName, Integer weekdayRates, Integer weekendRates) {
		super();
		this.hotelName = hotelName;
		this.weekendRates = weekendRates;
		this.weekdayRates = weekdayRates;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Integer getWeekendRates() {
		return weekendRates;
	}
	public void setWeekendRates(int weekendRates) {
		this.weekendRates = weekendRates;
	}
	public Integer getWeekdayRates() {
		return weekdayRates;
	}
	public void setWeekdayRates(int weekdayRates) {
		this.weekdayRates = weekdayRates;
	}
	
	
}

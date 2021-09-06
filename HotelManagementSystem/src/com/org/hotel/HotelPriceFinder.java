package com.org.hotel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class HotelPriceFinder {
	
	private List<Hotel> prepareHotelData(){
		List<Hotel> hotels= new ArrayList<Hotel>();
		hotels.add(new Hotel("Miami Beach", 80, 110)); 
		hotels.add(new Hotel("Miami Downtown", 120, 90)); 
		hotels.add(new Hotel("Miami Midtown", 100, 150)); 
		return hotels;
		
	}
	public List<Hotel> findCheapestHotel(String startDate, String endDate) {
		DaysCount daysCount=findnumberOfWeekendsAndWeekDays(startDate, endDate);
		List<Hotel> hotels=prepareHotelData();
		Hotel cheapestHotel=hotels.stream().min(Comparator.comparing(h->h.getWeekdayRates()*daysCount.weekdays+h.getWeekendRates()*daysCount.weekends)).get();
		int minPrice=cheapestHotel.getWeekdayRates()*daysCount.weekdays+cheapestHotel.getWeekendRates()*daysCount.weekends;
		List<Hotel> minPriceHotels=hotels.stream().filter(h->h.getWeekdayRates()*daysCount.weekdays+h.getWeekendRates()*daysCount.weekends==minPrice).toList();
		 return minPriceHotels;
	}
	
	public DaysCount findnumberOfWeekendsAndWeekDays(String startDate, String endDate) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("d/MM/yyy");
		int weekdays=0,weekends=0;
		LocalDate startLocalDate=LocalDate.parse(startDate,formatter);
		LocalDate endLocalDate=LocalDate.parse(endDate,formatter);
		
		for(LocalDate date=startLocalDate; date.isBefore(endLocalDate) || date.isEqual(endLocalDate);date=date.plusDays(1)) {
			DayOfWeek day=DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
			if(day==DayOfWeek.SUNDAY || day== DayOfWeek.SATURDAY)
				weekends++;
			else
				weekdays++;
		}
		return new DaysCount(weekdays,weekends);
	}
}

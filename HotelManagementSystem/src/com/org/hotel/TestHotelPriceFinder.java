package com.org.hotel;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

public class TestHotelPriceFinder {
	
	@Test
	public void findCheapestHotelTest() {
		HotelPriceFinder h= new HotelPriceFinder();
		List<Hotel> cheapestHotel= h.findCheapestHotel("22/11/2021", "29/11/2021");
		assertEquals(1, cheapestHotel.size());
		assertEquals("Miami Beach", cheapestHotel.get(0).getHotelName());
	}
	
	@Test
	public void findnumberOfWeekendsAndWeekDaysTest() {
		HotelPriceFinder h= new HotelPriceFinder();
		DaysCount d=h.findnumberOfWeekendsAndWeekDays("22/11/2021", "29/11/2021");
		assertNotNull(d);
		assertEquals(6, d.weekdays);
		assertEquals(2, d.weekends);
	}
	
	
}

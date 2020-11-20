package com.app.qa.resources;

import java.util.Calendar;

import com.app.qa.base.TestBase;

public class DatePicker extends TestBase {
	
	
	
	private String departureDate=null;
	private String returnDate=null;
	
	public String getDepartureDate() {
		return departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	//Picks up current system for Departure DAte and +7 days for Return date Returns in format tue 13 Apr 2019
	public static DatePicker getDates()
	{
		DatePicker date=new DatePicker();
		Calendar cal=Calendar.getInstance();
		
		String[] rawDate=cal.getTime().toString().split(" ");
		date.departureDate=rawDate[0]+" "+rawDate[1]+" "+rawDate[2]+" "+rawDate[5];
		cal.add(Calendar.DATE, Integer.parseInt(prop.getProperty("ReturnAfterdays")));
		//cal.add(Calendar.DATE, 3);
		rawDate=cal.getTime().toString().split(" ");
		date.returnDate=rawDate[0]+" "+rawDate[1]+" "+rawDate[2]+" "+rawDate[5];
		return date;
	}

	
}

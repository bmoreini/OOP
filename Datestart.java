package edu.vtc.oop.bmoreinis;

/**
 * What is it: Represents a date in the common era (CE) using the Gregorian calendar
 * @author bram
 *
 */



public class Datestart {

	/* How do we represent it? Instance variables */
	/** Day of the month, must be between 1 and 31 */
	private int day;
	/** Month of the year, must be between 1 and 12 */
	private int month;
	/** Year, must be greater than 0 in Common Era */
	private int year;
	
	/* Rep OK */
	private void repOK() {
		assert(month <= 12);
		assert(month >=1);
		assert(day >=1);
		assert(day <=31);
		
	}
	
	/* How do we make one */
	
	public Datestart(int month, int day, int year) {
		/**
		 * Constructs a new Datestart object
		 * 
		 * @param month - month of year, between 1 and 12
		 * @param day - day of the month, between 1 and 31
		 * @param year - must be greater than 0
		 */
		this.month = month;
		this.day = day;
		this.Year(year);
		repOK();
	}
	
	/* Getters */
	
	/** 
	 * Get the month of the year
	 * @param 
	 * @return the month where 1 = Jan and 12 = Dec, from 1 to 12
	 */
	public int month() {
		return 0;
	}
	
	/** 
	 * Gets the day of the month
	 * @return the day between 1 and 31
	 */
	public int day() {
		return 0;
	}
	
	/** 
	 * Gets the year
	 * @return the year greater than 0
	 */
	public int year() {
		return 0;
	}
	
	/**
	 * What do we do with it?
	 * 
	 * Methods 
	 * 
	 */
	
	/**
	 * Return the number of days between this date and another
	 * 
	 * @param other
	 * @return the days between this date and other, positive if other is later, 
	 *  negative if other is earlier.
	 * @throws NullPointerException if other is null
	 */
	public int daysBetween (Datestart other) {
		return 0;
	}
	
	/**
	 * @return a Datestart object representing the next calendar day.
	 */
	public Datestart nextday() {
		return null;
	}
	
	/**
	 * 
	 * @return String what day of the week this date occurrs on
	 */
	public String dayOfWeek() {
		return null;
	}
	
	public String toString() {
		return month+"/"+day+"/"+year;
	}
	
	public static void main(String[] args){ 
		Datestart today = new Datestart(9,27,2019);
		today.month();
		System.out.print(today);
	}

	public int Year() {
		return year;
	}

	public void Year(int year) {
		this.year = year;
	}

}

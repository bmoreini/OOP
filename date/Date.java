package edu.vtc.cis2260;

/**
 * Represents a date in the common era (CE) using the Gregorian calendar
 * 
 * @author jxo05160
 *
 */
public class Date {
	/** Day of the month, must be between 1 and 12 */
	private int day;
	
	/** Month of the year, must be between 1 and 31 */
	private int month;
	
	/** CE year, must be > 0 */
	private int year;
	
	/**
	 * Constructs a new Date object
	 * 
	 * @param month - month of the year, must be between 1 and 12
	 * @param day - day of the month, must be between 1 and 31
	 * @param year - must be greater than 0
	 */
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		repOK();
	}

	/**
	 * Get the month of the year
	 * 
	 * @return the month where 1 = January and 12 = December, from 1 to 12
	 */
	public int month() {
		return 0;
	}

	/**
	 * Gets the day of the month
	 * 
	 * @return the day between 1 and 31
	 */
	public int day() {
		return 0;
	}

	/**
	 * Gets the year
	 * 
	 * @return the year > 0
	 */
	public int year() {
		return 0;
	}

	/**
	 * Return the number of days between this date and another
	 * 
	 * @param other - cannot be null
	 * @return the days between this date and other, positive if other is later in
	 *         time, negative if other is earlier in time
	 * @throws NullPointerException if other is null
	 */
	public int daysBetween(Date other) throws NullPointerException {
		return 0;
	}

	/**
	 * @return a Date object representing the next calendar day
	 */
	public Date nextDay() {
		return null;
	}

	/**
	 * 
	 * @return what day of the week this Date occurs on
	 */
	public String dayOfWeek() {
		return null;
	}

	private void repOK() {
		assert(month <= 12);
		assert(month >= 1);
		assert(day <= 31);
		assert(day >= 1);
	}

	@Override
	public String toString( ) {
		return month + "/" + day + "/" + year;
	}
	
	public static void main(String[] args) {
		Date today = new Date(9, 27, 2019);
		today.month();
		System.out.println(today);
	}
}

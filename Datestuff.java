package edu.vtc.oop.bmoreinis;

import java.util.Date;

public class Datestuff {
	
	/**
	 * Calculates the duration in minutes between a start and end date
	 * 
	 * @param start meeting start date, not null, must be before end
	 * @param end - meeting end time, not null, must follow start
	 * @return the meeting duration in minutes, -1 if end is before start
	 */
	public static long duration(Date start, Date end) {
		return 0;	
	}

	/**
	 * Calculates start date for meeting given end time and duration. 
	 * @param end - meeting end time, date, must not be null
	 * @param duration - long, meeting duration in minutes, not negative nor null
	 * @returns start date occurring duration before end date. If duration is zero, 
	 * will be a clone of end.
	 */
	public static Date getStartDate(Date end, long duration) {
		return null;
	}
	
	/**
	 * Calculates end date for meeting given start time and duration. 
	 * @param start - meeting start time, date, must not be null
	 * @param duration - long, meeting duration in minutes, not negative nor null
	 * @returns end date occurring duration before after start date. If duration is zero, 
	 * will be a clone of start.
	 */
	public static Date getEndDate(Date start, long duration) {
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

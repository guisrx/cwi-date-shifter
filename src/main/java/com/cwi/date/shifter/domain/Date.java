package com.cwi.date.shifter.domain;

/**
 * Entity to represent a date as day, month, year, hour and minute.
 * @author selau
 *
 */
public class Date {

	private final int day;
	private final int month;
	private final int year;
	private final int hour;
	private final int minute;

	public Date(
			int day,
			int month,
			int year,
			int hour,
			int minute) {

		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + hour;
		result = prime * result + minute;
		result = prime * result + month;
		result = prime * result + year;
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
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + ", hour=" + hour + ", minute=" + minute + "]";
	}

}

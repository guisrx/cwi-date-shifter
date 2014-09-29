package com.cwi.date.shifter.domain;

/**
 * Enumeration of month in a year with its minutes duration.
 * @author selau
 *
 */
public enum Month {

	JANUARY(44640, 1, 31),
	FEBRUARY(40320, 2, 28),
	MARCH(44640, 3, 31),
	APRIL(43200, 4, 30),
	MAY(44640, 5, 31),
	JUNE(43200, 6, 30),
	JULY(44640, 7, 31),
	AUGUST(44640, 8, 31),
	SEPTEMBER(43200, 9, 30),
	OCTOBER(44640, 10, 31),
	NOVEMBER(43200, 11, 30),
	DECEMBER(44640, 12, 31);

	private final long minutes;
	private final int monthNumber;
	private final int days;

	private Month(long minutes, int monthNumber, int days) {
		this.minutes = minutes;
		this.monthNumber = monthNumber;
		this.days = days;
	}

	public long getMinutes() {
		return minutes;
	}

	public int getMonthNumber() {
		return monthNumber;
	}

	public int getDays() {
		return days;
	}

	public boolean fitInMonth(long givenMinutes) {

		return (this.minutes <= givenMinutes);
	}

}

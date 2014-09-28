package com.cwi.date.shifter.domain;

/**
 * Enumeration of month in a year with its minutes duration.
 * @author selau
 *
 */
public enum Month {

	JANUARY(44640, 1),
	FEBRUARY(40320, 2),
	MARCH(44640, 3),
	APRIL(43200, 4),
	MAY(44640, 5),
	JUNE(43200, 6),
	JULY(44640, 7),
	AUGUST(44640, 8),
	SEPTEMBER(43200, 9),
	OCTOBER(44640, 10),
	NOVEMBER(43200, 11),
	DECEMBER(44640, 12);

	private final long minutes;
	private final int monthNumber;

	private Month(long minutes, int monthNumber) {
		this.minutes = minutes;
		this.monthNumber = monthNumber;
	}

	public long getMinutes() {
		return minutes;
	}

	public int getMonthNumber() {
		return monthNumber;
	}

	public boolean fitInMonth(long givenMinutes) {

		return (this.minutes <= givenMinutes);
	}

}

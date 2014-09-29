package com.cwi.date.shifter.domain;

/**
 * Enumeration of month in a year with its minutes duration.
 * @author selau
 *
 */
public enum Month {

	JANUARY(44640, 1, 31, 0),
	FEBRUARY(40320, 2, 28, 44640),
	MARCH(44640, 3, 31, 84960),
	APRIL(43200, 4, 30, 129600),
	MAY(44640, 5, 31, 172800),
	JUNE(43200, 6, 30, 217440),
	JULY(44640, 7, 31, 260640),
	AUGUST(44640, 8, 31, 305280),
	SEPTEMBER(43200, 9, 30, 349920),
	OCTOBER(44640, 10, 31, 393120),
	NOVEMBER(43200, 11, 30, 437760),
	DECEMBER(44640, 12, 31, 480960);

	private final long minutes;
	private final int monthNumber;
	private final int days;
	private final long accumulatedMinutes;

	private Month(long minutes, int monthNumber, int days, long accumulatedMinutes) {
		this.minutes = minutes;
		this.monthNumber = monthNumber;
		this.days = days;
		this.accumulatedMinutes = accumulatedMinutes;
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

	public long getAccumulatedMinutes() {
		return accumulatedMinutes;
	}

	public boolean fitInMonth(long givenMinutes) {

		return (this.minutes <= givenMinutes);
	}

}

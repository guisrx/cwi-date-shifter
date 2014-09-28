package com.cwi.date.shifter.domain;

/**
 * Enumeration of month in a year with its minutes duration.
 * @author selau
 *
 */
public enum Month {

	JANUARY(44640),
	FEBRUARY(40320),
	MARCH(44640),
	APRIL(43200),
	MAY(44640),
	JUNE(43200),
	JULY(44640),
	AUGUST(44640),
	SEPTEMBER(43200),
	OCTOBER(44640),
	NOVEMBER(43200),
	DECEMBER(44640);

	private final long minutes;

	private Month(long minutes) {
		this.minutes = minutes;
	}

	public long getMinutes() {
		return minutes;
	}

}

package com.cwi.date.operator.support;

import com.cwi.date.operator.domain.Date;
import com.cwi.date.operator.domain.Month;

/**
 * Converter from date to minutes and from minutes to date.
 * @author selau
 *
 */
public class MinutesDateConverter {

	public static final long MINUTES_IN_A_YEAR = 525600;
	public static final long MINUTES_IN_A_DAY = 1440;
	public static final long MINUTES_IN_A_HOUR = 60;

	public Date convert(long calculatedDateInMinutes){
		// year
		final int finalYear = (int) Math.floor(calculatedDateInMinutes / MINUTES_IN_A_YEAR);
		final long dateMinusYears = calculatedDateInMinutes - finalYear * MINUTES_IN_A_YEAR;

		// month
		final Month[] months = Month.values();
		long dateMinusMonth = dateMinusYears;
		Month currentMonth = Month.JANUARY;

		for (final Month month : months) {
			currentMonth = month;

			if (month.fitInMonth(dateMinusMonth)) {
				dateMinusMonth -= month.getMinutes();
			} else {
				break;
			}
		}
		final int finalMonth = currentMonth.getMonthNumber();

		// day
		final int finalDay = (int) Math.floor(dateMinusMonth / MINUTES_IN_A_DAY);
		final long dateMinusDays = dateMinusMonth - finalDay * MINUTES_IN_A_DAY;

		// hour
		final int finalHour = (int) Math.floor(dateMinusDays / MINUTES_IN_A_HOUR);
		final long dateMinusHours = dateMinusDays - finalHour * MINUTES_IN_A_HOUR;

		// minute
		final int finalMinute = (int) dateMinusHours;

		return new Date(finalDay +1, finalMonth, finalYear, finalHour, finalMinute);
	}

	public long convert(final Date givenDate) {

		final long yearMinutes = MINUTES_IN_A_YEAR * givenDate.getYear();
		final long monthMinutes = Month.values()[givenDate.getMonth()-1].getAccumulatedMinutes();
		final long dayMinutes = MINUTES_IN_A_DAY * (givenDate.getDay() -1);
		final long hourMinutes = MINUTES_IN_A_HOUR * givenDate.getHour();
		final long minute = givenDate.getMinute();

		final long givenDateInMinutes =
				yearMinutes +
				monthMinutes +
				dayMinutes +
				hourMinutes +
				minute;

		return givenDateInMinutes;
	}
}

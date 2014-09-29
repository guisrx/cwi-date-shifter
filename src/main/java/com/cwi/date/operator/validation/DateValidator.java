package com.cwi.date.operator.validation;

import com.cwi.date.operator.domain.Date;
import com.cwi.date.operator.domain.Month;

/**
 * Entity to validate inputed data.
 * @author selau
 *
 */
public class DateValidator {

	public void validate(final Date date) {
		final int day = date.getDay();
		final int month = date.getMonth();
		final int year = date.getYear();
		final int hour = date.getHour();
		final int minute = date.getMinute();

		if ((minute < 0) || (minute > 59)){
			throw new IllegalArgumentException("Invalid minutes: " + minute);
		}

		if ((hour < 0) || (hour > 23)){
			throw new IllegalArgumentException("Invalid hours: " + hour);
		}

		if ((month < 1) || (month > 12)){
			throw new IllegalArgumentException("Invalid months: " + month);
		}

		final int daysInCurrentMonth = Month.values()[month - 1].getDays();
		if ((day < 1) || (day > daysInCurrentMonth)){
			throw new IllegalArgumentException("Invalid days: " + day);
		}

		if (year < 0){
			throw new IllegalArgumentException("Invalid years: " + year);
		}
	}
}

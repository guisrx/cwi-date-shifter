package com.cwi.date.shifter;

import com.cwi.date.shifter.domain.Date;
import com.cwi.date.shifter.domain.Month;

/**
 * Entity to shift dates from strings.
 * @author selau
 *
 */
public class DateShifter {

	private final long MINUTES_IN_A_YEAR = 525949;
	private final long MINUTES_IN_A_DAY = 1440;
	private final long MINUTES_IN_A_HOUR = 60;


	private final DateParser parser;


	public DateShifter(DateParser parser) {
		this.parser = parser;
	}


	public String changeDate(String date, char operation, long minutes) {

		final Date givenDate = parser.parse(date);

		final long yearMinutes = MINUTES_IN_A_YEAR * givenDate.getYear();
		final long monthMinutes = minutesToMonth(givenDate.getMonth());
		final long dayMinutes = MINUTES_IN_A_DAY * givenDate.getDay() -1;
		final long hourMinutes = MINUTES_IN_A_HOUR * givenDate.getHour() -1;
		final long minute = givenDate.getMinute();

		final long givenDateInMinutes =
				yearMinutes +
				monthMinutes +
				dayMinutes +
				hourMinutes +
				minute;

		long calculatedDateInMinutes = 0;

		switch(operation) {

			case '+':
				calculatedDateInMinutes = givenDateInMinutes + minutes;
				break;

			case '-':
				calculatedDateInMinutes = givenDateInMinutes - minutes;
				break;

			default:
				break;
		}




		return null;
	}


	private long minutesToMonth(int month) {

		final Month[] months = Month.values();
		long minutesAccumulated = 0;

		for (int i = 0; i < month-1; i++) {
			minutesAccumulated += months[i].getMinutes();
		}

		return minutesAccumulated;
	}




}

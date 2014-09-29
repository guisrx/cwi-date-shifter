package com.cwi.date.shifter;

import com.cwi.date.shifter.domain.Date;
import com.cwi.date.shifter.domain.Month;
import com.cwi.date.shifter.support.DateParser;
import com.cwi.date.shifter.support.DateWriter;
import com.cwi.date.shifter.validation.OperationValidator;

/**
 * Entity to shift dates from strings.
 * @author selau
 *
 */
public class DateShifter {

	private static final char SUBTRACTION_OPERATION = '-';
	private static final char SUM_OPERATION = '+';

	private final long MINUTES_IN_A_YEAR = 525600;
	private final long MINUTES_IN_A_DAY = 1440;
	private final long MINUTES_IN_A_HOUR = 60;


	private final DateParser parser;
	private final DateWriter writer;
	private final OperationValidator operationValidator;


	public DateShifter(
			DateParser parser,
			DateWriter writer,
			OperationValidator operationValidator) {

		this.parser = parser;
		this.writer = writer;
		this.operationValidator = operationValidator;
	}


	public String changeDate(final String date, final char operation, final long minutes) {

		// validate input
		operationValidator.validate(operation);

		// parse & validate input
		final Date givenDate = parser.parse(date);
		final long givenMinutes = Math.abs(minutes);

		// calculate
		final long givenDateInMinutes = convertGivenDateToMinutes(givenDate);

		final long calculatedDateInMinutes = executeOperation(operation, givenMinutes, givenDateInMinutes);

		System.out.println("calculatedDateInMinutes: " + calculatedDateInMinutes);


		// convert minutes to date

		// year
		final int finalYear = (int)Math.floor(calculatedDateInMinutes / MINUTES_IN_A_YEAR);
		final long dateMinusYears = calculatedDateInMinutes - finalYear * MINUTES_IN_A_YEAR;

		System.out.println("dateMinusYears: " + finalYear * MINUTES_IN_A_YEAR);


		// month
		final Month[] months = Month.values();
		long dateMinusMonth = dateMinusYears;
		Month currentMonth = Month.JANUARY;

		for (final Month month : months) {
			currentMonth = month;

			if (month.fitInMonth(dateMinusMonth)) {
				System.out.println("month: " + month + " minutos tenho: " + dateMinusMonth);
				dateMinusMonth -= month.getMinutes();
				System.out.println("minutos fiquei: " + dateMinusMonth + " month: " + month.getMinutes());
			} else {
				break;
			}
		}
		final int finalMonth = currentMonth.getMonthNumber();



		// day
		final int finalDay = (int)Math.floor(dateMinusMonth / MINUTES_IN_A_DAY);
		final long dateMinusDays = dateMinusMonth - finalDay * MINUTES_IN_A_DAY;

		System.out.println("dateMinusDays: " + finalDay * MINUTES_IN_A_DAY);


		// hour
		final int finalHour = (int)Math.floor(dateMinusDays / MINUTES_IN_A_HOUR);
		final long dateMinusHours = dateMinusDays - finalHour * MINUTES_IN_A_HOUR;

		System.out.println("dateMinusHours: " + finalHour * MINUTES_IN_A_HOUR);


		// minute
		final int finalMinute = (int)dateMinusHours;

		System.out.println("finalMinute: " + finalMinute);


		// write result
		final Date finalDate = new Date(finalDay +1, finalMonth, finalYear, finalHour, finalMinute);

		return writer.write(finalDate);
	}


	private long executeOperation(
			final char operation,
			final long givenMinutes,
			final long givenDateInMinutes) {

		switch(operation) {

			case SUM_OPERATION:
				return givenDateInMinutes + givenMinutes;

			case SUBTRACTION_OPERATION:
				return givenDateInMinutes - givenMinutes;

			default:
				throw new IllegalArgumentException("Illegal operation: '" + operation + "' allowed: '+' or '-'.");
		}
	}

	private long convertGivenDateToMinutes(final Date givenDate) {

		final long yearMinutes = MINUTES_IN_A_YEAR * givenDate.getYear();
		System.out.println("yearMinutes: " + yearMinutes);

		final long monthMinutes = firstYearMinuteToMonthInMinutes(givenDate.getMonth());
		System.out.println("monthMinutes: " + monthMinutes);

		final long dayMinutes = MINUTES_IN_A_DAY * (givenDate.getDay() -1);
		System.out.println("dayMinutes: " + dayMinutes);

		final long hourMinutes = MINUTES_IN_A_HOUR * givenDate.getHour();
		System.out.println("hourMinutes: " + hourMinutes);

		final long minute = givenDate.getMinute();
		System.out.println("minute: " + minute);

		final long givenDateInMinutes =
				yearMinutes +
				monthMinutes +
				dayMinutes +
				hourMinutes +
				minute;

		return givenDateInMinutes;
	}

	private long firstYearMinuteToMonthInMinutes(final int month) {

		final Month[] months = Month.values();
		long minutesAccumulated = 0;

		for (int i = 0; i < month-1; i++) {
			minutesAccumulated += months[i].getMinutes();
		}

		return minutesAccumulated;
	}

}

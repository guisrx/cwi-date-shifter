package com.cwi.date.shifter;

import static com.cwi.date.shifter.validation.OperationValidator.SUBTRACTION_OPERATION;
import static com.cwi.date.shifter.validation.OperationValidator.SUM_OPERATION;

import com.cwi.date.shifter.domain.Date;
import com.cwi.date.shifter.support.DateParser;
import com.cwi.date.shifter.support.DateWriter;
import com.cwi.date.shifter.support.MinutesDateConverter;
import com.cwi.date.shifter.validation.DateValidator;
import com.cwi.date.shifter.validation.OperationValidator;

/**
 * Entity to shift dates from strings.
 * @author selau
 *
 */
public class DateShifter {

	private final DateParser parser;
	private final DateWriter writer;
	private final OperationValidator operationValidator;
	private final DateValidator dateValidator;
	private final MinutesDateConverter minutesDateConverter;

	public DateShifter(
			DateParser parser,
			DateWriter writer,
			OperationValidator operationValidator,
			DateValidator dateValidator,
			MinutesDateConverter minutesDateConverter) {

		this.parser = parser;
		this.writer = writer;
		this.operationValidator = operationValidator;
		this.dateValidator = dateValidator;
		this.minutesDateConverter = minutesDateConverter;
	}

	public String changeDate(final String date, final char operation, final long minutes) {

		// validate input
		operationValidator.validate(operation);

		// parse & validate input
		final Date givenDate = parser.parse(date);
		final long givenMinutes = Math.abs(minutes);

		// calculate
		final long givenDateInMinutes = minutesDateConverter.convert(givenDate);
		final long calculatedDateInMinutes = executeOperation(operation, givenMinutes, givenDateInMinutes);
		final Date finalDate = minutesDateConverter.convert(calculatedDateInMinutes);

		dateValidator.validate(finalDate);

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

}

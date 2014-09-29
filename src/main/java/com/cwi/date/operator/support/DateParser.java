package com.cwi.date.operator.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cwi.date.operator.domain.Date;
import com.cwi.date.operator.validation.DateValidator;

/**
 * Entity to encapsulate date parsing.
 * @author selau
 *
 */
public class DateParser {

	private static final String DATE_FORMAT = "dd/MM/yyyy HH24:mi";
	private static final String PATTERN = "([0-3][0-9])/([0-1][0-9])/([0-9]{4}) ([0-2][0-9]):([0-5][0-9])";
	private static final Pattern DATE_PATTERN = Pattern.compile(PATTERN);

	private final DateValidator dateValidator;

	public DateParser(DateValidator dateValidator) {
		this.dateValidator = dateValidator;
	}

	public Date parse(final String date) {
		final Matcher matcher = DATE_PATTERN.matcher(date);

		if (! matcher.matches()) {
			throw new IllegalArgumentException("Received date: " + date + " does not match pattern: " + DATE_FORMAT);
		}

		final String day = matcher.group(1);
		final String month = matcher.group(2);
		final String year = matcher.group(3);
		final String hour = matcher.group(4);
		final String minute = matcher.group(5);

		Date parsedDate = new Date(
				Integer.parseInt(day),
				Integer.parseInt(month),
				Integer.parseInt(year),
				Integer.parseInt(hour),
				Integer.parseInt(minute));

		dateValidator.validate(parsedDate);

		return parsedDate;
	}

}

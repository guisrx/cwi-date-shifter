package com.cwi.date.operator.support;

import com.cwi.date.operator.domain.Date;

/**
 * Entity to write a date in a format as dd/MM/yyyy HH24:mi.
 * @author selau
 *
 */
public class DateWriter {

	private static final String DATE_FORMAT = "%02d/%02d/%04d %02d:%02d";


	public String write(final Date date) {

		final String dateFormated = String.format(
				DATE_FORMAT,
				date.getDay(),
				date.getMonth(),
				date.getYear(),
				date.getHour(),
				date.getMinute());

		return dateFormated;
	}

}

package com.cwi.date.shifter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cwi.date.shifter.domain.Date;

/**
 * Test class of {@link DateParser}.
 * @author selau
 *
 */
public class DateParserTests {

	private DateParser subject;
	private DateWriter writer;

	@Before
	public void before() {
		subject = new DateParser();
		writer = new DateWriter();
	}

	@Test
	public void shouldParseDateCorreclty() {
		// given
		final int day = 1;
		final int month = 3;
		final int year = 2010;
		final int hour = 23;
		final int minute = 0;

		final String date = writer.write(new Date(day, month, year, hour, minute));

		// when
		final Date parsedDate = subject.parse(date);

		// then
		assertEquals(day, parsedDate.getDay());
		assertEquals(month, parsedDate.getMonth());
		assertEquals(year, parsedDate.getYear());
		assertEquals(hour, parsedDate.getHour());
		assertEquals(minute, parsedDate.getMinute());
	}

}

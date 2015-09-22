package com.cwi.date.operator.support;

import static com.cwi.date.operator.support.MinutesDateConverter.MINUTES_IN_A_DAY;
import static com.cwi.date.operator.support.MinutesDateConverter.MINUTES_IN_A_HOUR;
import static com.cwi.date.operator.support.MinutesDateConverter.MINUTES_IN_A_YEAR;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cwi.date.operator.domain.Date;
import com.cwi.date.operator.domain.Month;
import com.cwi.date.operator.support.MinutesDateConverter;

/**
 * Tests of {@link MinutesDateConverter}.
 * @author selau
 *
 */
public class MinutesDateConverterTest {

	private MinutesDateConverter subject;

	@Before
	public void before() {
		subject = new MinutesDateConverter();
	}

	@Test
	public void shouldConvertOneMinuteMinutes() {
		// given
		final int day = 1;
		final int month = 1;
		final int year = 0;
		final int hour = 0;
		final int minute = 1;

		final Date givenDate = new Date(day, month, year, hour, minute);

		// when
		final long minutes = subject.convert(givenDate);
		final Date convertedDate = subject.convert(minutes);

		// then
		assertEquals(1, minutes);
		assertEquals(givenDate, convertedDate);
	}

	@Test
	public void shouldConvertOneHourMinutes() {
		// given
		final int day = 1;
		final int month = 1;
		final int year = 0;
		final int hour = 1;
		final int minute = 0;

		final Date givenDate = new Date(day, month, year, hour, minute);

		// when
		final long minutes = subject.convert(givenDate);
		final Date convertedDate = subject.convert(minutes);

		// then
		assertEquals(MINUTES_IN_A_HOUR, minutes);
		assertEquals(givenDate, convertedDate);
	}

	@Test
	public void shouldConvertOneDayMinutes() {
		// given
		final int day = 2;
		final int month = 1;
		final int year = 0;
		final int hour = 0;
		final int minute = 0;

		final Date givenDate = new Date(day, month, year, hour, minute);

		// when
		final long minutes = subject.convert(givenDate);
		final Date convertedDate = subject.convert(minutes);

		// then
		assertEquals(MINUTES_IN_A_DAY, minutes);
		assertEquals(givenDate, convertedDate);
	}

	@Test
	public void shouldConvertOneMonthMinutes() {
		// given
		final int day = 1;
		final int month = 2;
		final int year = 0;
		final int hour = 0;
		final int minute = 0;

		final Date givenDate = new Date(day, month, year, hour, minute);

		// when
		final long minutes = subject.convert(givenDate);
		final Date convertedDate = subject.convert(minutes);

		// then
		assertEquals(Month.JANUARY.getMinutes(), minutes);
		assertEquals(givenDate, convertedDate);
	}

	@Test
	public void shouldConvertOneYearMinutes() {
		// given
		final int day = 1;
		final int month = 1;
		final int year = 1;
		final int hour = 0;
		final int minute = 0;

		final Date givenDate = new Date(day, month, year, hour, minute);

		// when
		final long minutes = subject.convert(givenDate);
		final Date convertedDate = subject.convert(minutes);

		// then
		assertEquals(MINUTES_IN_A_YEAR, minutes);
		assertEquals(givenDate, convertedDate);
	}

}

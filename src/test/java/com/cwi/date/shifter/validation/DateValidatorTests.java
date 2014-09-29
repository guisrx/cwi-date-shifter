package com.cwi.date.shifter.validation;

import org.junit.Before;
import org.junit.Test;

import com.cwi.date.shifter.domain.Date;

/**
 * Tests of {@link DateValidator}.
 * @author selau
 *
 */
public class DateValidatorTests {

	private DateValidator subject;

	@Before
	public void before() {
		subject = new DateValidator();
	}

	@Test (expected = IllegalArgumentException.class)
	public void shouldNotValidateNegativeMinutes() {
		// given
		final int day = 10;
		final int month = 8;
		final int year = 2014;
		final int hour = 18;
		final int minute = -59;

		// when
		subject.validate(new Date(day, month, year, hour, minute));

		// then should throw an exception.
	}

	@Test (expected = IllegalArgumentException.class)
	public void shouldNotValidateMinutesGreaterThanLimit() {
		// given
		final int day = 10;
		final int month = 8;
		final int year = 2014;
		final int hour = 18;
		final int minute = 60;

		// when
		subject.validate(new Date(day, month, year, hour, minute));

		// then should throw an exception.
	}

	@Test (expected = IllegalArgumentException.class)
	public void shouldNotValidateNegativeHours() {
		// given
		final int day = 10;
		final int month = 8;
		final int year = 2014;
		final int hour = -18;
		final int minute = 59;

		// when
		subject.validate(new Date(day, month, year, hour, minute));

		// then should throw an exception.
	}

	@Test (expected = IllegalArgumentException.class)
	public void shouldNotValidateHoursGreaterThanLimit() {
		// given
		final int day = 10;
		final int month = 8;
		final int year = 2014;
		final int hour = 24;
		final int minute = 59;

		// when
		subject.validate(new Date(day, month, year, hour, minute));

		// then should throw an exception.
	}

	@Test (expected = IllegalArgumentException.class)
	public void shouldNotValidateNegativeMonths() {
		// given
		final int day = 10;
		final int month = -8;
		final int year = 2014;
		final int hour = 18;
		final int minute = 59;

		// when
		subject.validate(new Date(day, month, year, hour, minute));

		// then should throw an exception.
	}

	@Test (expected = IllegalArgumentException.class)
	public void shouldNotValidateZeroMonths() {
		// given
		final int day = 10;
		final int month = 0;
		final int year = 2014;
		final int hour = 23;
		final int minute = 59;

		// when
		subject.validate(new Date(day, month, year, hour, minute));

		// then should throw an exception.
	}

	@Test (expected = IllegalArgumentException.class)
	public void shouldNotValidateMonthsGreaterThanLimit() {
		// given
		final int day = 10;
		final int month = 13;
		final int year = 2014;
		final int hour = 23;
		final int minute = 59;

		// when
		subject.validate(new Date(day, month, year, hour, minute));

		// then should throw an exception.
	}

	@Test (expected = IllegalArgumentException.class)
	public void shouldNotValidateNegativeDays() {
		// given
		final int day = -15;
		final int month = 8;
		final int year = 2014;
		final int hour = 18;
		final int minute = 59;

		// when
		subject.validate(new Date(day, month, year, hour, minute));

		// then should throw an exception.
	}

	@Test (expected = IllegalArgumentException.class)
	public void shouldNotValidateZeroDays() {
		// given
		final int day = 0;
		final int month = 8;
		final int year = 2014;
		final int hour = 18;
		final int minute = 59;

		// when
		subject.validate(new Date(day, month, year, hour, minute));

		// then should throw an exception.
	}

	@Test (expected = IllegalArgumentException.class)
	public void shouldNotValidateGreaterThanMonthDays() {
		// given
		final int day = 29;
		final int month = 2;
		final int year = 2014;
		final int hour = 18;
		final int minute = 59;

		// when
		subject.validate(new Date(day, month, year, hour, minute));

		// then should throw an exception.
	}

	@Test (expected = IllegalArgumentException.class)
	public void shouldNotValidateNegativeYears() {
		// given
		final int day = 15;
		final int month = 8;
		final int year = -2014;
		final int hour = 18;
		final int minute = 59;

		// when
		subject.validate(new Date(day, month, year, hour, minute));

		// then should throw an exception.
	}

	@Test
	public void shouldValidateDateSuccesfully() {
		// given
		final int day = 15;
		final int month = 8;
		final int year = 2014;
		final int hour = 18;
		final int minute = 59;

		// when
		subject.validate(new Date(day, month, year, hour, minute));

		// then should not throw an exception.
	}
}

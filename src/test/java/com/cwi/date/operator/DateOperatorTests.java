package com.cwi.date.operator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cwi.date.operator.DateOperator;
import com.cwi.date.operator.support.DateParser;
import com.cwi.date.operator.support.DateWriter;
import com.cwi.date.operator.support.MinutesDateConverter;
import com.cwi.date.operator.validation.DateValidator;
import com.cwi.date.operator.validation.OperationValidator;

/**
 * Test class of {@link DateOperator}.
 * @author selau
 *
 */
public class DateOperatorTests {

	private OperationValidator operationValidator;
	private DateValidator dateValidator;
	private MinutesDateConverter minutesToDateConversor;
	private DateParser parser;
	private DateWriter writer;
	private DateOperator subject;

	@Before
	public void before() {
		operationValidator = new OperationValidator();
		dateValidator = new DateValidator();
		minutesToDateConversor = new MinutesDateConverter();
		parser = new DateParser(dateValidator);
		writer = new DateWriter();
		subject = new DateOperator(parser, writer, operationValidator, dateValidator, minutesToDateConversor);
	}

	@Test
	public void shouldShiftDateCorreclty() {
		// given
		final String date = "01/03/2010 23:00";
		final char op = '+';
		final long value = 4000l;

		// when
		final String changedDate = subject.changeDate(date, op, value);

		// then
		assertEquals("04/03/2010 17:40", changedDate);
	}

	@Test
	public void shouldNotShiftDateWhenNoMinutesAdded() {
		// given
		final String date = "01/03/2010 23:00";
		final char op = '+';
		final long value = 0;

		// when
		final String changedDate = subject.changeDate(date, op, value);

		// then
		assertEquals("01/03/2010 23:00", changedDate);
	}

	@Test
	public void shouldNotShiftDateWhenNoMinutesSubtracted() {
		// given
		final String date = "01/03/2010 23:00";
		final char op = '-';
		final long value = 0;

		// when
		final String changedDate = subject.changeDate(date, op, value);

		// then
		assertEquals("01/03/2010 23:00", changedDate);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForIllegalOperation() {
		// given
		final String date = "01/03/2010 23:00";
		final char op = '*';
		final long value = 0;

		// when
		subject.changeDate(date, op, value);

		// then should throw an exception.
	}

	@Test
	public void shouldShiftNewYearSubtracted() {
		// given
		final String date = "01/01/2010 00:00";
		final char op = '-';
		final long value = 1;

		// when
		final String changedDate = subject.changeDate(date, op, value);

		// then
		assertEquals("31/12/2009 23:59", changedDate);
	}

	@Test
	public void shouldShiftNewYearAdded() {
		// given
		final String date = "31/12/2009 23:59";
		final char op = '+';
		final long value = 1;

		// when
		final String changedDate = subject.changeDate(date, op, value);

		// then
		assertEquals("01/01/2010 00:00", changedDate);
	}

	@Test
	public void shouldShiftNewYearAddedWithNegativeMinute() {
		// given
		final String date = "31/12/2009 23:59";
		final char op = '+';
		final long value = -1;

		// when
		final String changedDate = subject.changeDate(date, op, value);

		// then
		assertEquals("01/01/2010 00:00", changedDate);
	}

	@Test
	public void shouldSubtractFirstDayMinute() {
		// given
		final String date = "01/11/2011 00:01";
		final char op = '-';
		final long value = 1;

		// when
		final String changedDate = subject.changeDate(date, op, value);

		// then
		assertEquals("01/11/2011 00:00", changedDate);
	}

}

package com.cwi.date.shifter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cwi.date.shifter.support.DateParser;
import com.cwi.date.shifter.support.DateWriter;
import com.cwi.date.shifter.validation.OperationValidator;

/**
 * Test class of {@link DateShifter}.
 * @author selau
 *
 */
public class DateShifterTests {

	private OperationValidator operationValidator;
	private DateParser parser;
	private DateWriter writer;
	private DateShifter subject;

	@Before
	public void before() {
		operationValidator = new OperationValidator();
		parser = new DateParser();
		writer = new DateWriter();
		subject = new DateShifter(parser, writer, operationValidator);
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

}

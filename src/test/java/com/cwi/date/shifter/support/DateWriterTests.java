package com.cwi.date.shifter.support;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cwi.date.shifter.domain.Date;
import com.cwi.date.shifter.validation.DateValidator;

/**
 * Test class of {@link DateWriter}.
 * @author selau
 *
 */
public class DateWriterTests {

	private DateWriter subject;
	private DateParser parser;
	private DateValidator dateValidator;

	@Before
	public void before() {
		dateValidator = new DateValidator();
		subject = new DateWriter();
		parser = new DateParser(dateValidator);
	}

	@Test
	public void shouldWriteDateCorreclty() {
		// given
		final String givenDate = "01/03/2010 23:00";
		final Date date = parser.parse(givenDate);

		// when
		final String writedDate = subject.write(date);

		// then
		assertEquals(givenDate, writedDate);
	}

}

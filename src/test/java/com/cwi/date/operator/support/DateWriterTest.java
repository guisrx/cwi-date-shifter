package com.cwi.date.operator.support;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cwi.date.operator.domain.Date;
import com.cwi.date.operator.support.DateParser;
import com.cwi.date.operator.support.DateWriter;
import com.cwi.date.operator.validation.DateValidator;

/**
 * Test class of {@link DateWriter}.
 * @author selau
 *
 */
public class DateWriterTest {

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

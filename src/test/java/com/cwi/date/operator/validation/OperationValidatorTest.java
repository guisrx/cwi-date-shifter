package com.cwi.date.operator.validation;

import org.junit.Before;
import org.junit.Test;

import com.cwi.date.operator.validation.OperationValidator;

/**
 * Tests of {@link OperationValidator}.
 * @author selau
 *
 */
public class OperationValidatorTest {

	private OperationValidator subject;

	@Before
	public void before() {
		subject = new OperationValidator();
	}

	@Test
	public void shouldValidateSumOperation() {
		// given
		final char sum = '+';

		// when
		subject.validate(sum);

		// then should not throw an exception.
	}

	@Test
	public void shouldValidateSubtractionOperation() {
		// given
		final char subtraction = '-';

		// when
		subject.validate(subtraction);

		// then should not throw an exception.
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotValidateDivisionOperation() {
		// given
		final char sum = '/';

		// when
		subject.validate(sum);

		// then should throw an exception.
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldValidateMultiplyOperation() {
		// given
		final char subtraction = '*';

		// when
		subject.validate(subtraction);

		// then should throw an exception.
	}

}

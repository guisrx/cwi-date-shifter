package com.cwi.date.operator.validation;

/**
 * Validator of the allowed operation in the shifter.
 * @author selau
 *
 */
public class OperationValidator {

	public static final char SUBTRACTION_OPERATION = '-';
	public static final char SUM_OPERATION = '+';

	public void validate(final char operation) {

		switch(operation) {

			case SUBTRACTION_OPERATION:
			case SUM_OPERATION:
				break;

			default:
				throw new IllegalArgumentException("Illegal operation: '" + operation + "' allowed: '+' or '-'.");
		}
	}

}

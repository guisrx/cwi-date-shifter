package com.cwi.date.shifter.validation;

/**
 * Validator of the allowed operation in the shifter.
 * @author selau
 *
 */
public class OperationValidator {

	public void validate(final char operation) {

		switch(operation) {

			case '+':
			case '-':
				break;

			default:
				throw new IllegalArgumentException("Illegal operation: '" + operation + "' allowed: '+' or '-'.");
		}
	}

}

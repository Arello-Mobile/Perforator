package com.arellomobile.validation.validator;

import com.arellomobile.validation.model.ValidatorField;

import java.util.Collection;

/**
 * Date: 07.11.2016
 * Time: 15:54
 *
 * @author Savin Mikhail
 */
public class CompareValidator<Field, Reason> extends Validator<Field, Reason> {
	private Iterable<ValidatorField<Field>> mValidatorFields;

	public CompareValidator(final ValidatorField<Field> validatorField, Collection<ValidatorField<Field>> compare, Reason reason) {
		super(validatorField);
		setReason(reason);
		mValidatorFields = compare;
	}

	@Override
	public boolean isValid(final ValidatorField<Field> validatorField) {
		boolean result = true;
		for (ValidatorField<Field> field : mValidatorFields) {
			result = (validatorField.getValue() == null && field.getValue() == null || validatorField.getValue().equals(field.getValue()) || validatorField.getValue().toString().equals(field.getValue().toString())) && result;
			if (!result) {
				return false;
			}
		}

		return true;
	}
}

package com.arellomobile.validation.validator;

import android.text.TextUtils;

import com.arellomobile.validation.model.ValidatorField;

/**
 * Date: 07.11.2016
 * Time: 15:49
 *
 * @author Savin Mikhail
 */
public class EmptyValidator<Reason> extends Validator<CharSequence, Reason> {
	public EmptyValidator(final ValidatorField<CharSequence> validatorField, Reason reason) {
		super(validatorField);
		setReason(reason);
	}

	@Override
	public boolean isValid(final ValidatorField<CharSequence> validatorField) {
		return !TextUtils.isEmpty(validatorField.getValue());
	}
}

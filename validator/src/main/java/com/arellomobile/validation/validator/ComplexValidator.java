package com.arellomobile.validation.validator;

import com.arellomobile.validation.model.ValidatorField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Date: 09.11.2016
 * Time: 12:12
 *
 * @author Savin Mikhail
 */
public class ComplexValidator<Field> extends Validator<Field, Object> {
	private List<Validator<Field, ?>> mValidators = new ArrayList<>();

	public ComplexValidator(final ValidatorField<Field> validatorField) {
		super(validatorField);
	}

	public boolean removeAll(final Collection<Validator<Field, ?>> collection) {
		return mValidators.removeAll(collection);
	}

	public boolean remove(final Validator<Field, ?> o) {
		return mValidators.remove(o);
	}

	public boolean add(final Validator<Field, ?> validator) {
		return mValidators.add(validator);
	}

	public boolean addAll(final Collection<? extends Validator<Field, ?>> collection) {
		return mValidators.addAll(collection);
	}

	@Override
	protected boolean isValid(final ValidatorField<Field> validatorField) {
		for (Validator<Field, ?> validator : mValidators) {
			if (!validator.isValid(validatorField)) {
				setReason(validator.mReason);
				mValidatorResult.setValidator(validator);
				return false;
			}
		}

		return true;
	}

	@Override
	public void setTag(final String tag) {
		throw new IllegalArgumentException("You must set up tag for children");
	}
}

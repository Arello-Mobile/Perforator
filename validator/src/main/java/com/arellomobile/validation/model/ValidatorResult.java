package com.arellomobile.validation.model;

import com.arellomobile.validation.validator.Validator;

/**
 * Date: 07.11.2016
 * Time: 15:14
 *
 * @author Savin Mikhail
 */
public class ValidatorResult<T> {
	private boolean mValid;
	private T reason;
	private Validator<?, T> mValidator;

	public boolean isValid() {
		return mValid;
	}

	public void setValid(final boolean valid) {
		mValid = valid;
	}

	public T getReason() {
		return reason;
	}

	public void setReason(final T reason) {
		this.reason = reason;
	}

	public void setValidator(final Validator<?, T> validator) {
		mValidator = validator;
	}

	public Validator<?, T> getValidator() {
		return mValidator;
	}
}

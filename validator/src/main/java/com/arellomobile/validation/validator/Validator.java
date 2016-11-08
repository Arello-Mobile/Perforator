package com.arellomobile.validation.validator;

import com.arellomobile.validation.model.ValidatorField;
import com.arellomobile.validation.model.ValidatorResult;

/**
 * Date: 07.11.2016
 * Time: 15:13
 *
 * @author Savin Mikhail
 */
public abstract class Validator<Field, Reason> {
	private ValidatorField<Field> mValidatorField;
	private final ValidatorResult<Reason> mValidatorResult;
	Reason mReason;
	private String mTag;

	public Validator(final ValidatorField<Field> validatorField) {
		mValidatorField = validatorField;
		mValidatorResult = new ValidatorResult<>();
		mValidatorResult.setValidator(this);
	}

	public void updateData(ValidatorField<Field> validatorField) {
		mValidatorField.setValue(validatorField.getValue());
	}

	protected abstract boolean isValid(ValidatorField<Field> validatorField);

	public ValidatorResult<Reason> validate() {
		boolean valid = isValid(mValidatorField);
		if (valid) {
			mValidatorResult.setReason(null);
		} else {
			mValidatorResult.setReason(mReason);
		}

		mValidatorResult.setValid(valid);
		return mValidatorResult;
	}

	protected void setReason(Reason reason) {
		mReason = reason;
	}

	public String getTag() {
		return mTag == null ? getClass().getName() : mTag;
	}

	public void setTag(final String tag) {
		mTag = tag;
	}
}

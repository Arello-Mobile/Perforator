package com.arellomobile.validation.validator;

import android.text.TextUtils;

import com.arellomobile.validation.model.ValidatorField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Date: 07.11.2016
 * Time: 15:34
 *
 * @author Savin Mikhail
 */
public class PatternValidator<Reason> extends Validator<CharSequence, Reason> {
	private final Pattern mPattern;

	public PatternValidator(final ValidatorField<CharSequence> validatorField, Pattern pattern, Reason reason) {
		super(validatorField);
		setReason(reason);
		mPattern = pattern;
	}

	public PatternValidator(final ValidatorField<CharSequence> validatorField, final String pattern, Reason reason) {
		this(validatorField, Pattern.compile(pattern), reason);
	}

	@Override
	public boolean isValid(final ValidatorField<CharSequence> validatorField) {
		if (TextUtils.isEmpty(validatorField.getValue())) {
			return false;
		}

		Matcher matcher = mPattern.matcher(validatorField.getValue());

		return matcher.matches();
	}
}

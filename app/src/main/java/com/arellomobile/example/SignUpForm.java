package com.arellomobile.example;

import android.util.Patterns;

import com.arellomobile.validation.Field;
import com.arellomobile.validation.Form;
import com.arellomobile.validation.model.ValidatorField;
import com.arellomobile.validation.strategy.IntegerInterpretationStrategy;
import com.arellomobile.validation.strategy.ResultInterpretationStrategy;
import com.arellomobile.validation.strategy.StringInterpretationStrategy;
import com.arellomobile.validation.validator.CompareValidator;
import com.arellomobile.validation.validator.EmptyValidator;
import com.arellomobile.validation.validator.PatternValidator;
import com.arellomobile.validation.validator.Validator;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;

/**
 * Date: 07.11.2016
 * Time: 15:21
 *
 * @author Savin Mikhail
 */
public class SignUpForm extends Form {
	private static final String TAG = "SignUpForm";
	public static final String KEY_PASSWORD_CONFIRMATION = TAG + ".key_PASSWORD_CONFIRMATION";

	private ValidatorField<CharSequence> mEmail = new ValidatorField<>();
	private ValidatorField<CharSequence> mPassword = new ValidatorField<>();
	private ValidatorField<CharSequence> mConfirmPassword = new ValidatorField<>();
	private ValidatorField<CharSequence> mName = new ValidatorField<>();
	private ValidatorField<CharSequence> mSurname = new ValidatorField<>();
	private ValidatorField<CharSequence> mPhone = new ValidatorField<>();

	public SignUpForm() {
		put(SignUpFields.EMAIL, mEmail);
		put(SignUpFields.PASSWORD, mPassword);
		put(SignUpFields.CONFIRM_PASSWORD, mConfirmPassword);
		put(SignUpFields.NAME, mName);
		put(SignUpFields.SURNAME, mSurname);
		put(SignUpFields.PHONE, mPhone);
		put(this, getFormValidatorField());
	}

	@Override
	public LinkedHashMap<ValidatorField<?>, Collection<? extends Validator<?, ?>>> provideValidators() {
		LinkedHashMap<ValidatorField<?>, Collection<? extends Validator<?, ?>>> map = new LinkedHashMap<>();
		for (SignUpFields field : SignUpFields.values()) {
			switch (field) {
				case EMAIL:
					map.put(getByField(field), Collections.singleton(new PatternValidator<>(mEmail, Patterns.EMAIL_ADDRESS, "Email not match!")));
					break;
				case PASSWORD:
					map.put(getByField(field), Collections.singletonList(new PatternValidator<>(mPassword, "^" +
							"(?=.*[0-9])" +
							"(?=.*[A-Z])" +
							"(?=.*[a-z])" +
							"(?=\\S+$)" +
							".{8,16}" +
							"$", "Incorrect Password")));
					break;
				case CONFIRM_PASSWORD:
					break;
				case NAME:
					map.put(getByField(field), Collections.singleton(new EmptyValidator<>(mName, "Name is required!")));
					break;
				case SURNAME:
					map.put(getByField(field), Collections.singleton(new EmptyValidator<>(mSurname, "Surname is required!")));
					break;
				case PHONE:
					map.put(getByField(field), Collections.singleton(new PatternValidator<>(mPhone, Patterns.PHONE, "Phone not match!")));
					break;
			}
		}

		CompareValidator<CharSequence, String> compareValidator = new CompareValidator<>(mPassword, Collections.singleton(mConfirmPassword), "Passwords not match");
		compareValidator.setTag(KEY_PASSWORD_CONFIRMATION);
		map.put(getFormValidatorField(), Collections.singleton(compareValidator));
		return map;
	}

	@Override
	public ResultInterpretationStrategy provideStrategy(final Field field, final Validator<?, ?> validator) {
		if (field instanceof SignUpFields) {
			switch ((SignUpFields) field) {
				case EMAIL:
					return new StringInterpretationStrategy();
				case PASSWORD:
					return new IntegerInterpretationStrategy();
				case CONFIRM_PASSWORD:
					break;
				case NAME:
					return new StringInterpretationStrategy();
				case SURNAME:
					return new StringInterpretationStrategy();
				case PHONE:
					return new StringInterpretationStrategy();
			}
		}

		return provideFormStrategy();
	}

	@Override
	protected ResultInterpretationStrategy provideFormStrategy() {
		return new SignUpFormInterpretationStrategy();
	}
}

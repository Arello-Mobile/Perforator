package com.arellomobile.example;

import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.arellomobile.validation.Field;
import com.arellomobile.validation.R;
import com.arellomobile.validation.decorator.FormDecorator;
import com.arellomobile.validation.model.DecoratorParams;

/**
 * Date: 08.11.2016
 * Time: 12:34
 *
 * @author Savin Mikhail
 */
public class SignUpFormDecoration extends FormDecorator {
	private TextView mPassword;
	private TextView mConfirmPassword;

	public SignUpFormDecoration(final TextView password, final TextView confirmPassword) {
		mPassword = password;
		mConfirmPassword = confirmPassword;
	}

	@Override
	protected void decorateField(final Field key, final DecoratorParams<?> value) {
		updatePasswordsField(key, R.color.colorAccent);
	}

	@Override
	protected void resetField(final Field key, final DecoratorParams<?> value) {
		updatePasswordsField(key, android.R.color.transparent);
	}

	private void updatePasswordsField(final Field key, final int color) {
		if (key instanceof SignUpFields) {
			switch ((SignUpFields) key) {

				case PASSWORD:
					mPassword.setBackgroundColor(ContextCompat.getColor(mPassword.getContext(), color));
					break;
				case CONFIRM_PASSWORD:
					mConfirmPassword.setBackgroundColor(ContextCompat.getColor(mConfirmPassword.getContext(), color));
					break;
			}
		}
	}
}

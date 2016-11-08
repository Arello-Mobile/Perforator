package com.arellomobile.validation.condition;

import com.arellomobile.validation.Field;

/**
 * Date: 08.11.2016
 * Time: 12:58
 *
 * @author Savin Mikhail
 */
public class FieldValidatorCondition implements ValidatorCondition {
	Field mField;

	public FieldValidatorCondition(final Field field) {
		mField = field;
	}

	@Override
	public boolean needDecorateField(final Field field, final boolean isValid) {
		return mField.equals(field);
	}
}

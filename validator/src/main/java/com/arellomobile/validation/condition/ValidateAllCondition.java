package com.arellomobile.validation.condition;

import com.arellomobile.validation.Field;

/**
 * Date: 01.11.2016
 * Time: 11:33
 *
 * @author Savin Mikhail
 */
public class ValidateAllCondition implements ValidatorCondition {
	@Override
	public boolean needDecorateField(final Field field, final boolean isValid) {
		return true;
	}
}

package com.arellomobile.validation.condition;

import com.arellomobile.validation.Field;

/**
 * Date: 24.11.2015
 * Time: 10:36
 *
 * @author Savin Mikhail
 */
public interface ValidatorCondition
{
	/**
	 * Strategy for decorate view
	 * @param field current decorated field
	 * @param isValid isValid before
	 * @return true if need decorate
	 */
	boolean needDecorateField(final Field field, boolean isValid);
}

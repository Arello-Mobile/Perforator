package com.arellomobile.validation.condition;

import com.arellomobile.validation.Field;

/**
 * Date: 24.11.2015
 * Time: 10:37
 *
 * @author Savin Mikhail
 */
public class FirstInvalidCondition implements ValidatorCondition
{
	private boolean mFirstInvalidCondition;

	@Override
	public boolean needDecorateField(final Field field, final boolean isValid)
	{
		if (!mFirstInvalidCondition)
		{
			mFirstInvalidCondition = !isValid;
			return mFirstInvalidCondition;
		}

		return false;
	}

}

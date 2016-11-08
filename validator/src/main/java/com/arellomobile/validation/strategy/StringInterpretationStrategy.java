package com.arellomobile.validation.strategy;


import com.arellomobile.validation.Field;
import com.arellomobile.validation.model.DecoratorParams;
import com.arellomobile.validation.model.ValidatorResult;

/**
 * Date: 07.11.2016
 * Time: 11:22
 *
 * @author Savin Mikhail
 */
public class StringInterpretationStrategy implements ResultInterpretationStrategy {

	@Override
	public DecoratorParams<String> interpretation(final Field field, final ValidatorResult<?> result) {
		if (result.getReason() instanceof String) {
			return new DecoratorParams<>((String) result.getReason());
		}

		return new DecoratorParams<String>();
	}
}

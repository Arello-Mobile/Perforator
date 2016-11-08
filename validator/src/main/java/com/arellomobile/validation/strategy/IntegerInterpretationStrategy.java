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
public class IntegerInterpretationStrategy implements ResultInterpretationStrategy {

	@Override
	public DecoratorParams<Integer> interpretation(final Field field, final ValidatorResult<?> result) {
		if (result.getReason() instanceof Integer) {
			return new DecoratorParams<>((Integer) result.getReason());
		}

		return new DecoratorParams<>();
	}
}

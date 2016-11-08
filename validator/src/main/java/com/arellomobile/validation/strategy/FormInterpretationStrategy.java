package com.arellomobile.validation.strategy;

import com.arellomobile.validation.Field;
import com.arellomobile.validation.Form;
import com.arellomobile.validation.decorator.FormDecoratorParams;
import com.arellomobile.validation.model.DecoratorParams;
import com.arellomobile.validation.model.ValidatorResult;

import java.util.Map;

/**
 * Date: 08.11.2016
 * Time: 11:24
 *
 * @author Savin Mikhail
 */
public abstract class FormInterpretationStrategy<T extends Form> implements ResultInterpretationStrategy {
	private final Class<T> mTClass;

	public FormInterpretationStrategy(final Class<T> TClass) {
		mTClass = TClass;
	}

	@Override
	public DecoratorParams<?> interpretation(final Field field, final ValidatorResult<?> result) {
		if (mTClass.isAssignableFrom(field.getClass())) {
			T form = (T) field;
			FormDecoratorParams formDecoratorParams = new FormDecoratorParams(form);
			formDecoratorParams.setMap(getMapByResult(form, result));
			return formDecoratorParams;
		}

		return null;
	}

	protected abstract Map<Field, DecoratorParams<?>> getMapByResult(final T form, final ValidatorResult<?> result);
}

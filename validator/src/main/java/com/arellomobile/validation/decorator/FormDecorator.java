package com.arellomobile.validation.decorator;

import com.arellomobile.validation.Field;
import com.arellomobile.validation.model.DecoratorParams;

import java.util.Map;

/**
 * Date: 08.11.2016
 * Time: 11:21
 *
 * @author Savin Mikhail
 */
public abstract class FormDecorator implements Decorator {

	@Override
	public void decorate(final Field field, final DecoratorParams<?> decoratorParams) {
		FormDecoratorParams formDecoratorParams = (FormDecoratorParams) decoratorParams;
		Map<Field, DecoratorParams<?>> map = formDecoratorParams.getMap();
		for (Map.Entry<Field, DecoratorParams<?>> entry : map.entrySet()) {
			decorateField(entry.getKey(), entry.getValue());
		}
	}

	protected abstract void decorateField(final Field key, final DecoratorParams<?> value);

	@Override
	public void reset(final Field field, final DecoratorParams<?> decoratorParams) {
		FormDecoratorParams formDecoratorParams = (FormDecoratorParams) decoratorParams;
		Map<Field, DecoratorParams<?>> map = formDecoratorParams.getMap();
		for (Map.Entry<Field, DecoratorParams<?>> entry : map.entrySet()) {
			resetField(entry.getKey(), entry.getValue());
		}
	}

	protected abstract void resetField(final Field key, final DecoratorParams<?> value);
}

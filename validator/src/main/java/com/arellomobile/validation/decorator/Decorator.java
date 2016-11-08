package com.arellomobile.validation.decorator;

import com.arellomobile.validation.Field;
import com.arellomobile.validation.model.DecoratorParams;

/**
 * Date: 08.11.2016
 * Time: 10:45
 *
 * @author Savin Mikhail
 */
public interface Decorator {
	void decorate(Field field, DecoratorParams<?> decoratorParams);

	void reset(Field field, DecoratorParams<?> decoratorParams);
}

package com.arellomobile.validation.decorator;

import android.support.annotation.NonNull;

import com.arellomobile.validation.Field;
import com.arellomobile.validation.model.DecoratorParams;

/**
 * Date: 08.11.2016
 * Time: 10:46
 *
 * @author Savin Mikhail
 */
public abstract class BaseFieldDecorator<Model, DecoratorParamsType> implements Decorator {
	private Class<DecoratorParamsType> mTClass;
	private Model mModel;

	public BaseFieldDecorator(Model model, final Class<DecoratorParamsType> TClass) {
		mTClass = TClass;
		mModel = model;
	}

	public Model getModel() {
		return mModel;
	}

	@Override
	public void decorate(Field field, final DecoratorParams<?> decoratorParams) {
		decorateField(getDecoratorParams(decoratorParams));
	}

	private DecoratorParams<DecoratorParamsType> getDecoratorParams(final DecoratorParams<?> decoratorParams) {
		if (decoratorParams == null || decoratorParams.getValue() == null) {
			return new DecoratorParams<>();
		} else {
			if (mTClass.isAssignableFrom(decoratorParams.getValue().getClass())) {
				//noinspection unchecked
				return ((DecoratorParams<DecoratorParamsType>) decoratorParams);
			} else {
				return new DecoratorParams<>();
			}
		}
	}

	@Override
	public void reset(final Field field, DecoratorParams<?> decoratorParams) {
		reset(getDecoratorParams(decoratorParams));
	}

	protected abstract void reset(final DecoratorParams<DecoratorParamsType> decoratorParams);

	protected abstract void decorateField(@NonNull final DecoratorParams<DecoratorParamsType> decoratorParams);
}

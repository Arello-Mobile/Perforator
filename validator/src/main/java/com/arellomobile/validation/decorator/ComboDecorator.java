package com.arellomobile.validation.decorator;


import com.arellomobile.validation.Field;
import com.arellomobile.validation.model.DecoratorParams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComboDecorator implements Decorator {

	private final List<Decorator> mDecorators = new ArrayList<>();

	public ComboDecorator(Decorator... decorators) {
		if (decorators != null) {
			mDecorators.addAll(Arrays.asList(decorators));
		}
	}

	public boolean addDecorator(Decorator decorator) {
		return mDecorators.add(decorator);
	}

	public boolean removeDecorator(Decorator decorator) {
		return mDecorators.remove(decorator);
	}

	public void removeAll() {
		mDecorators.clear();
	}


	@Override
	public void decorate(Field field, final DecoratorParams<?> decoratorParams) {
		for (Decorator decorator : mDecorators) {
			decorator.decorate(field, decoratorParams);
		}
	}

	@Override
	public void reset(Field field, DecoratorParams<?> decoratorParams) {
		for (Decorator decorator : mDecorators) {
			decorator.reset(field, decoratorParams);
		}
	}
}

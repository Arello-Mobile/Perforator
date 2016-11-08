package com.arellomobile.validation.decorator;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.arellomobile.validation.model.DecoratorParams;


public class TextErrorDecorator extends BaseFieldDecorator<TextView, CharSequence> {

	public TextErrorDecorator(final TextView model) {
		super(model, CharSequence.class);
	}

	@Override
	public void reset(final DecoratorParams<CharSequence> decoratorParams) {
		getModel().setError(null);
	}

	@Override
	protected void decorateField(@NonNull final DecoratorParams<CharSequence> decoratorParams) {
		getModel().setError(decoratorParams.getValue());

	}
}
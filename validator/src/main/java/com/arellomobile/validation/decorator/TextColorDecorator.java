package com.arellomobile.validation.decorator;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.arellomobile.validation.model.DecoratorParams;


public class TextColorDecorator extends BaseFieldDecorator<TextView, Integer> {

	@ColorInt
	private final int mDefaultBackground;
	@ColorInt
	private final int mInvalidBackground;

	public TextColorDecorator(TextView textView, @ColorInt int defaultBackgroundResource, @ColorInt int invalidBackgroundResource) {
		super(textView, Integer.class);
		mDefaultBackground = defaultBackgroundResource;
		mInvalidBackground = invalidBackgroundResource;
	}

	@Override
	public void reset(final DecoratorParams<Integer> decoratorParams) {
		getModel().setTextColor(mDefaultBackground);
	}

	@Override
	protected void decorateField(@NonNull final DecoratorParams<Integer> decoratorParams) {
		@ColorInt int color = decoratorParams.getValue() != null ? decoratorParams.getValue() : mInvalidBackground;
		getModel().setTextColor(color);
	}
}
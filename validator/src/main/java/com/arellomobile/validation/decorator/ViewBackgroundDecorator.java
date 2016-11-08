package com.arellomobile.validation.decorator;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.arellomobile.validation.model.DecoratorParams;

/**
 * Date: 08.11.2016
 * Time: 10:57
 *
 * @author Savin Mikhail
 */
public class ViewBackgroundDecorator extends BaseFieldDecorator<View, Integer> {
	private int mDefultColor;
	private int mDecorateColor;

	public ViewBackgroundDecorator(final View view, int defaultColor, int decorateColor) {
		super(view, Integer.class);
		mDefultColor = defaultColor;
		mDecorateColor = decorateColor;
	}

	@Override
	protected void decorateField(@NonNull final DecoratorParams<Integer> decoratorParams) {
		@ColorInt int color = decoratorParams.getValue() == null ? mDecorateColor : decoratorParams.getValue();
		getModel().setBackgroundColor(color);
	}

	@Override
	public void reset(final DecoratorParams<Integer> decoratorParams) {
		getModel().setBackgroundColor(mDefultColor);
	}
}

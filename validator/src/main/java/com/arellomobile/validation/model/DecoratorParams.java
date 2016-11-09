package com.arellomobile.validation.model;

import android.support.annotation.NonNull;

/**
 * Date: 08.11.2016
 * Time: 9:03
 *
 * @author Savin Mikhail
 */
public class DecoratorParams<T> extends AbstractField<T> {

	String mTag;

	public DecoratorParams(final T fieldValue) {
		super(fieldValue);
	}

	public DecoratorParams() {
	}

	public void setTag(final String tag) {
		mTag = tag;
	}

	@NonNull
	public String getTag() {
		return mTag == null ? getClass().getName() + "$" + (getValue() == null ? "null" : getValue()) : mTag;
	}
}

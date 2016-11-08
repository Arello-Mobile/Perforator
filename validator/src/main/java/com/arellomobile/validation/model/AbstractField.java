package com.arellomobile.validation.model;

/**
 * Date: 08.11.2016
 * Time: 11:11
 *
 * @author Savin Mikhail
 */
public class AbstractField<T> {
	T mValue;

	public AbstractField(final T fieldValue) {
		this.mValue = fieldValue;
	}

	public AbstractField() {/*do nothing*/}

	public T getValue() {
		return mValue;
	}

	public void setValue(final T fieldValue) {
		mValue = fieldValue;
	}
}

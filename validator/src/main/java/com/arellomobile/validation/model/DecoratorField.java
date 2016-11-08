package com.arellomobile.validation.model;

/**
 * Date: 08.11.2016
 * Time: 11:10
 *
 * @author Savin Mikhail
 */
public class DecoratorField<T> extends AbstractField<T>{
	public DecoratorField(final T fieldValue) {
		super(fieldValue);
	}

	public DecoratorField() {
	}
}

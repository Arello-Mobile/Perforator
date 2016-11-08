package com.arellomobile.validation.decorator;

import com.arellomobile.validation.Field;
import com.arellomobile.validation.Form;
import com.arellomobile.validation.model.DecoratorParams;

import java.util.Map;

/**
 * Date: 08.11.2016
 * Time: 11:10
 *
 * @author Savin Mikhail
 */
public class FormDecoratorParams extends DecoratorParams<Form> {
	private Map<Field, DecoratorParams<?>> mMap;

	public FormDecoratorParams(final Form fieldValue) {
		super(fieldValue);
	}

	public FormDecoratorParams() {
	}

	public void setMap(final Map<Field, DecoratorParams<?>> map) {
		mMap = map;
	}

	public Map<Field, DecoratorParams<?>> getMap() {
		return mMap;
	}
}

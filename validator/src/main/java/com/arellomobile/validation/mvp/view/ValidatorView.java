package com.arellomobile.validation.mvp.view;

import com.arellomobile.validation.Field;
import com.arellomobile.validation.Form;
import com.arellomobile.validation.model.DecoratorParams;

/**
 * Date: 07.11.2016
 * Time: 16:05
 *
 * @author Savin Mikhail
 */
public interface ValidatorView{

	void resetError(Field field, final DecoratorParams<?> interpretation);

	void showError(Field field, DecoratorParams<?> decoratorParams);

	void formCreated(Form form);
}

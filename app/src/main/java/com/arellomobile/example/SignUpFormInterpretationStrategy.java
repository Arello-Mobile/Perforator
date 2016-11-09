package com.arellomobile.example;

import com.arellomobile.validation.Field;
import com.arellomobile.validation.model.DecoratorParams;
import com.arellomobile.validation.model.ValidatorResult;
import com.arellomobile.validation.strategy.FormInterpretationStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 08.11.2016
 * Time: 12:19
 *
 * @author Savin Mikhail
 */
public class SignUpFormInterpretationStrategy extends FormInterpretationStrategy<SignUpForm> {

	public SignUpFormInterpretationStrategy() {
		super(SignUpForm.class);
	}

	@Override
	protected Map<Field, DecoratorParams<?>> getMapByResult(final SignUpForm form, final ValidatorResult<?> result) {
		if (result.getValidator().getTag().equals(SignUpForm.KEY_PASSWORD_CONFIRMATION)) {
			Map<Field, DecoratorParams<?>> map = new HashMap<>();
			map.put(SignUpFields.PASSWORD, new DecoratorParams<Integer>());
			map.put(SignUpFields.CONFIRM_PASSWORD, new DecoratorParams<Integer>());
			return map;
		} else if (result.getValidator().getTag().equals(SignUpForm.KEY_PASSWORD_EMPTY_VALIDATOR)) {
			Map<Field, DecoratorParams<?>> map = new HashMap<>();
			DecoratorParams<String> v = new DecoratorParams<>((String) result.getReason());
			v.setTag(SignUpForm.KEY_PASSWORD_EMPTY_VALIDATOR);
			map.put(SignUpFields.PASSWORD, v);
			return map;
		}
		return null;
	}
}

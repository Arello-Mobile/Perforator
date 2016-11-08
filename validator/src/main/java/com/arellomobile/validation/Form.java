package com.arellomobile.validation;

import com.arellomobile.validation.model.ValidatorField;
import com.arellomobile.validation.strategy.ResultInterpretationStrategy;
import com.arellomobile.validation.validator.Validator;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Date: 07.11.2016
 * Time: 15:18
 *
 * @author Savin Mikhail
 */
public abstract class Form implements Field {

	private Map<Field, ValidatorField<?>> mFieldMap = new HashMap<>();

	private final ValidatorField<Form> mFormValidatorField = new ValidatorField<>(this);

	public abstract LinkedHashMap<ValidatorField<?>, Collection<? extends Validator<?, ?>>> provideValidators();

	public abstract ResultInterpretationStrategy provideStrategy(Field field, Validator<?, ?> validator);

	protected abstract ResultInterpretationStrategy provideFormStrategy();

	protected ValidatorField<?> put(final Field field, final ValidatorField<?> validatorField) {
		return mFieldMap.put(field, validatorField);
	}

	public <S> ValidatorField<S> getByField(final Field field) {
		//noinspection unchecked
		return (ValidatorField<S>) mFieldMap.get(field);
	}

	public Field getByValidatorField(final ValidatorField<?> validatorField) {
		for (Map.Entry<Field, ValidatorField<?>> entry : mFieldMap.entrySet()) {
			if (entry.getValue().equals(validatorField)) {
				return entry.getKey();
			}
		}

		return null;
	}

	public ValidatorField<Form> getFormValidatorField() {
		return mFormValidatorField;
	}

	public Form updateField(final Field field, final ValidatorField<?> validatorField) {
		getByField(field).setValue(validatorField.getValue());
		return this;
	}

	@Override
	public String getType() {
		return this.getClass().getName();
	}
}

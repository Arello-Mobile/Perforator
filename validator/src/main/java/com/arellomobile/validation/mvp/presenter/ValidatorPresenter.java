package com.arellomobile.validation.mvp.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.validation.Field;
import com.arellomobile.validation.Form;
import com.arellomobile.validation.condition.ValidatorCondition;
import com.arellomobile.validation.model.DecoratorParams;
import com.arellomobile.validation.model.ValidatorField;
import com.arellomobile.validation.model.ValidatorResult;
import com.arellomobile.validation.mvp.view.ValidatorView;
import com.arellomobile.validation.validator.Validator;

import java.util.Collection;
import java.util.Map;

/**
 * Date: 07.11.2016
 * Time: 16:05
 *
 * @author Savin Mikhail
 */
public abstract class ValidatorPresenter<T extends MvpView & ValidatorView> extends MvpPresenter<T> {

	private Form mForm;
	private boolean mLastUpdate = true;

	protected boolean needDecorateView(ValidatorCondition validatorCondition, final Field field, boolean lastUpdate) {
		mLastUpdate = lastUpdate && mLastUpdate;
		if (validatorCondition == null) {
			return true;
		}
		return validatorCondition.needDecorateField(field, mLastUpdate);
	}

	public void setForm(Form form) {
		if (mForm == null) {
			mForm = form;
			notifyViewForm(mForm);
		}
	}

	protected abstract void notifyViewForm(final Form form);

	public void updateField(final Field field, final ValidatorField<?> validatorField) {
		mForm.updateField(field, validatorField);
	}

	protected Field getByValidatorField(final ValidatorField<?> validatorField) {
		return mForm.getByValidatorField(validatorField);
	}

	protected ValidatorField<?> getByField(final Field field) {
		return mForm.getByField(field);
	}

	public void validate(ValidatorCondition validatorCondition) {
		mLastUpdate = true;
		Map<ValidatorField<?>, Collection<? extends Validator<?, ?>>> validatorFieldCollectionMap = mForm.provideValidators();
		for (Map.Entry<ValidatorField<?>, Collection<? extends Validator<?, ?>>> entry : validatorFieldCollectionMap.entrySet()) {
			for (Validator<?, ?> validator : entry.getValue()) {
				updateValidateState(validatorCondition, entry.getKey(), validator.validate());
			}
		}
	}

	protected void updateValidateState(ValidatorCondition validatorCondition, final ValidatorField<?> key, final ValidatorResult<?> validatorResult) {
		Field field = getByValidatorField(key);
		if (validatorResult.isValid()) {
			resetError(field, mForm.provideStrategy(field, validatorResult.getValidator()).interpretation(field, validatorResult));
		} else if (needDecorateView(validatorCondition, field, validatorResult.isValid())) {
			showError(field, mForm.provideStrategy(field, validatorResult.getValidator()).interpretation(field, validatorResult));
		}
	}

	protected abstract void showError(final Field byValidatorField, final DecoratorParams<?> interpretation);

	protected abstract void resetError(final Field byValidatorField, final DecoratorParams<?> interpretation);
}

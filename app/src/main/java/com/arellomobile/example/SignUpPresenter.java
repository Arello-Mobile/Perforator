package com.arellomobile.example;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.validation.Field;
import com.arellomobile.validation.Form;
import com.arellomobile.validation.condition.FieldValidatorCondition;
import com.arellomobile.validation.condition.FirstInvalidCondition;
import com.arellomobile.validation.condition.ValidateAllCondition;
import com.arellomobile.validation.model.DecoratorParams;
import com.arellomobile.validation.mvp.presenter.ValidatorPresenter;

/**
 * Date: 08.11.2016
 * Time: 8:47
 *
 * @author Savin Mikhail
 */
@InjectViewState
public class SignUpPresenter extends ValidatorPresenter<SignUpView> {

	public SignUpPresenter() {
		setForm(new SignUpForm());
	}

	@Override
	protected void notifyViewForm(final Form form) {
		getViewState().formCreated(form);
	}

	@Override
	protected void showError(final Field byValidatorField, final DecoratorParams<?> interpretation) {
		getViewState().showError(byValidatorField, interpretation);
	}

	@Override
	protected void resetError(final Field byValidatorField, final DecoratorParams<?> interpretation) {
		getViewState().resetError(byValidatorField, interpretation);
	}

	public void validateField(Field field){
		validate(new FieldValidatorCondition(field));
	}

	public void validateAll(){
		validate(new ValidateAllCondition());
	}

	public void validateFirst(){
		validate(new FirstInvalidCondition());
	}
}

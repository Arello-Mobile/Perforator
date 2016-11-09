package com.arellomobile.example;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.validation.Field;
import com.arellomobile.validation.Form;
import com.arellomobile.validation.decorator.ComboDecorator;
import com.arellomobile.validation.decorator.Decorator;
import com.arellomobile.validation.decorator.TextColorDecorator;
import com.arellomobile.validation.decorator.TextErrorDecorator;
import com.arellomobile.validation.model.DecoratorParams;
import com.arellomobile.validation.model.ValidatorField;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends MvpAppCompatActivity implements SignUpView {
	@BindView(R.id.activity_sign_up__edit_email)
	EditText mEmailEdit;
	@BindView(R.id.activity_sign_up__edit_password)
	EditText mPasswordEdit;
	@BindView(R.id.activity_sign_up__edit_password_confirm)
	EditText mPasswordConfirmEdit;
	@BindView(R.id.activity_sign_up_text_view_password_error)
	TextView mPasswordErrorText;

	@BindView(R.id.activity_sign_up__edit_first_name)
	EditText mFirstNameEdit;
	@BindView(R.id.activity_sign_up__edit_surname)
	EditText mSurnameEdit;
	@BindView(R.id.activity_sign_up__edit_mobile_number)
	EditText mMobileNumberEdit;

	@BindView(R.id.activity_sign_up__btn_register)
	Button mRegisterButton;
	@BindView(R.id.activity_sign_up__btn_confirm)
	Button mConfirmButton;

	Map<Field, Decorator> mFieldViewTypes = new HashMap<>();

	@InjectPresenter
	SignUpPresenter mPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		ButterKnife.bind(this);

		setTitle(R.string.register);

		initViewFieldsMap();
		initListeners();
	}

	private void initViewFieldsMap() {
		mFieldViewTypes.put(SignUpFields.EMAIL, new TextErrorDecorator(mEmailEdit));
		mFieldViewTypes.put(SignUpFields.PASSWORD, new TextColorDecorator(mPasswordErrorText, ContextCompat.getColor(this, R.color.colorPrimary), ContextCompat.getColor(this, R.color.colorAccent)));
		mFieldViewTypes.put(SignUpFields.NAME, new TextErrorDecorator(mFirstNameEdit));
		mFieldViewTypes.put(SignUpFields.SURNAME, new TextErrorDecorator(mSurnameEdit));
		mFieldViewTypes.put(SignUpFields.PHONE, new ComboDecorator(
				new TextColorDecorator(mMobileNumberEdit, ContextCompat.getColor(this, R.color.colorPrimary), ContextCompat.getColor(this, R.color.colorAccent)),
				new TextErrorDecorator(mMobileNumberEdit)));
	}

	private void initListeners() {
		mConfirmButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View view) {
				updateData();
				mPresenter.validateAll();
			}
		});
		mRegisterButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View view) {
				updateData();
				mPresenter.validateFirst();
			}
		});

		mEmailEdit.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

			}

			@Override
			public void onTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

			}

			@Override
			public void afterTextChanged(final Editable editable) {
				mPresenter.updateField(SignUpFields.EMAIL, new ValidatorField<>(editable));
				mPresenter.validateField(SignUpFields.EMAIL);
			}
		});
	}

	private void updateData() {
		mPresenter.updateField(SignUpFields.EMAIL, new ValidatorField<>(mEmailEdit.getText()));
		mPresenter.updateField(SignUpFields.PASSWORD, new ValidatorField<>(mPasswordEdit.getText()));
		mPresenter.updateField(SignUpFields.CONFIRM_PASSWORD, new ValidatorField<>(mPasswordConfirmEdit.getText()));
		mPresenter.updateField(SignUpFields.NAME, new ValidatorField<>(mFirstNameEdit.getText()));
		mPresenter.updateField(SignUpFields.SURNAME, new ValidatorField<>(mSurnameEdit.getText()));
		mPresenter.updateField(SignUpFields.PHONE, new ValidatorField<>(mMobileNumberEdit.getText()));
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	@Override
	public void resetError(final Field field, final DecoratorParams<?> interpretation) {
		mFieldViewTypes.get(field).reset(field, interpretation);
	}

	@Override
	public void showError(final Field field, final DecoratorParams<?> decoratorParams) {
		mFieldViewTypes.get(field).decorate(field, decoratorParams);
	}

	@Override
	public void formCreated(final Form form) {
		mFieldViewTypes.put(form, new SignUpFormDecoration(mPasswordEdit, mPasswordConfirmEdit));
	}
}
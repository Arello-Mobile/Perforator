
package com.arellomobile.example;


import com.arellomobile.validation.Field;

public enum SignUpFields implements Field {
	EMAIL,
	PASSWORD,
	CONFIRM_PASSWORD,
	NAME,
	SURNAME,
	PHONE;

	@Override
	public String getType() {
		return name();
	}
}
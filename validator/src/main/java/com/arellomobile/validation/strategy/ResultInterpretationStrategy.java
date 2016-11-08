package com.arellomobile.validation.strategy;


import com.arellomobile.validation.Field;
import com.arellomobile.validation.model.DecoratorParams;
import com.arellomobile.validation.model.ValidatorResult;

/**
 * Date: 07.11.2016
 * Time: 11:18
 *
 * @author Savin Mikhail
 */
public interface ResultInterpretationStrategy {

	DecoratorParams<?> interpretation(final Field field, ValidatorResult<?> result);
}

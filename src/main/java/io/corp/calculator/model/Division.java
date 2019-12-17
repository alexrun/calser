package io.corp.calculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
public class Division implements Operation {

	@Override
	public BigDecimal compute(BigDecimal firstValue, BigDecimal secondValue) {
		return firstValue.divide(secondValue, 4, RoundingMode.HALF_UP);
	}

	@Override
	public boolean handles(String operation) {
		return "div".equals(operation);
	}

}

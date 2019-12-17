package io.corp.calculator.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Subtraction implements Operation {

	@Override
	public BigDecimal compute(BigDecimal firstValue, BigDecimal secondValue) {
		return firstValue.subtract(secondValue);
	}

	@Override
	public boolean handles(String operation) {
		return "sub".equals(operation);
	}

}

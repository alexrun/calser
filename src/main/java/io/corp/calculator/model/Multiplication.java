package io.corp.calculator.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Multiplication implements Operation {

	@Override
	public BigDecimal compute(BigDecimal firstValue, BigDecimal secondValue) {
		return firstValue.multiply(secondValue);
	}

	@Override
	public boolean handles(String operation) {
		return "mul".equals(operation);
	}

}

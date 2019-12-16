package io.corp.calculator.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Addition implements Operation {

	@Override
	public BigDecimal compute(BigDecimal firstValue, BigDecimal secondValue) {
		return firstValue.add(secondValue);
	}

	@Override
	public boolean handles(String operation) {
		return "add".equals(operation);
	}

}

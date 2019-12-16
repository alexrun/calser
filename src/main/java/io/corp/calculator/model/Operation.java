package io.corp.calculator.model;

import java.math.BigDecimal;

public interface Operation {
	BigDecimal compute(BigDecimal firstValue, BigDecimal secondValue);
	boolean handles(String operation);
}

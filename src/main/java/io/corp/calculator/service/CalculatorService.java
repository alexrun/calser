package io.corp.calculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.corp.calculator.TracerImpl;
import io.corp.calculator.model.Operation;

@Service
public class CalculatorService {
	
	@Autowired
	private TracerImpl tracer;
	
	@Autowired
	private Collection<Operation> operations;
	
	public BigDecimal calculate(BigDecimal firstValue, BigDecimal secondValue, String operationType) {
        for (Operation operation : operations) {
            if (operation.handles(operationType)) {
            	BigDecimal result = operation.compute(firstValue, secondValue).setScale(4, RoundingMode.HALF_UP).stripTrailingZeros();
        		tracer.trace(result.toPlainString());
                return result;
            }
        }
		String errorMessage = "Unknown operation " + operationType;
		tracer.trace(errorMessage);
        throw new IllegalArgumentException(errorMessage);
    }

}

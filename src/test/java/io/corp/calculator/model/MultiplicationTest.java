package io.corp.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MultiplicationTest {
	
	@Autowired
	Multiplication operation;
	
	@Test
	public void shouldHandleMultiplicationOperation() {
		assertTrue(operation.handles("mul"));
	}
	
	@Test
	public void shouldComputeAnAddition() {
		BigDecimal firstValue = new BigDecimal("4");
		BigDecimal secondValue = new BigDecimal("2");
		BigDecimal resultValue = new BigDecimal("8");
		assertEquals(resultValue, operation.compute(firstValue, secondValue));
	}

}

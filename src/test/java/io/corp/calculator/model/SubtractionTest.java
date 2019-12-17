package io.corp.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubtractionTest {
	
	@Autowired
	Subtraction operation;
	
	@Test
	public void shouldHandleSubtractionOperation() {
		assertTrue(operation.handles("sub"));
	}
	
	@Test
	public void shouldComputeASubtraction() {
		BigDecimal firstValue = new BigDecimal("8");
		BigDecimal secondValue = new BigDecimal("2");
		BigDecimal resultValue = new BigDecimal("6");
		assertEquals(resultValue, operation.compute(firstValue, secondValue));
	}

}

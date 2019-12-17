package io.corp.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdditionTest {
	
	@Autowired
	Addition operation;
	
	@Test
	public void shouldHandleAnAdditionOperation() {
		assertTrue(operation.handles("add"));
	}
	
	@Test
	public void shouldNotHandleOtherOperation() {
		assertFalse(operation.handles("other"));
	}
	
	@Test
	public void shouldComputeAnAddition() {
		BigDecimal firstValue = new BigDecimal("4");
		BigDecimal secondValue = new BigDecimal("2");
		BigDecimal resultValue = new BigDecimal("6");
		assertEquals(resultValue, operation.compute(firstValue, secondValue));
	}

}

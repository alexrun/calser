package io.corp.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import io.corp.calculator.model.Operation;

@SpringBootTest
public class CalculatorServiceTest {

	@Autowired
	CalculatorService service;

	@MockBean
	private Collection<Operation> operationsMock;

	@Test
	void shouldCalculateOperations() throws Exception {
		BigDecimal result = service.calculate(new BigDecimal("10"), new BigDecimal("9"), "add");
		assertEquals(new BigDecimal("19"), result);
		result = service.calculate(new BigDecimal("-10"), new BigDecimal("9"), "add");
		assertEquals(new BigDecimal("-1"), result);
		result = service.calculate(new BigDecimal("7"), new BigDecimal("8"), "mul");
		assertEquals(new BigDecimal("56"), result);
		result = service.calculate(new BigDecimal("-7"), new BigDecimal("8"), "mul");
		assertEquals(new BigDecimal("-56"), result);
	}

	@Test
	void shouldThrowExceptionWhenUnknownOperation() throws Exception {
		Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.calculate(new BigDecimal("1"), new BigDecimal("0"), "xor");
		});
		Assertions.assertEquals("Unknown operation xor", throwable.getMessage());
	}
	
	@Test
    void shouldTestCalculatorPrecision() {
		assertFalse(precisionLessThanOrEqualToFour("20.44567567"));
		assertTrue(precisionLessThanOrEqualToFour(service.calculate(new BigDecimal("10.48525"), new BigDecimal("9.15441"), "add").toPlainString()));
		assertTrue(precisionLessThanOrEqualToFour(service.calculate(new BigDecimal("10.00000"), new BigDecimal("9.00000"), "add").toPlainString()));
		assertTrue(precisionLessThanOrEqualToFour(service.calculate(new BigDecimal("10.48525"), new BigDecimal("9.15441"), "mul").toPlainString()));
		assertTrue(precisionLessThanOrEqualToFour(service.calculate(new BigDecimal("10.00000"), new BigDecimal("9.00000"), "mul").toPlainString()));
    }

    private boolean precisionLessThanOrEqualToFour(String value) {
        return value.replaceAll(".*\\.", "").length() <= 4;
    }
	
}

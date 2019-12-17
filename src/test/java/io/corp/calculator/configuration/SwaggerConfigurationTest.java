package io.corp.calculator.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SwaggerConfigurationTest {
	@Test
	public void shouldGetCalculatorServiceApiInfo() {
		SwaggerConfiguration config = new SwaggerConfiguration();
		assertEquals("Calculator Online REST api", config.buildCalculatorServiceApiInfo().getTitle());
	}
}

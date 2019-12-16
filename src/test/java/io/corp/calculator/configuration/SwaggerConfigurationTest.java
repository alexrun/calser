package io.corp.calculator.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SwaggerConfigurationTest {
	@Test
	public void shouldGetProFoodApiInfo() {
		SwaggerConfiguration config = new SwaggerConfiguration();
		assertEquals("Calculator Online REST api", config.buildProFoodApiInfo().getTitle());
	}
}

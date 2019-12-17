package io.corp.calculator.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.corp.calculator.service.CalculatorService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	
	@Autowired
	CalculatorService service;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Calculates an operation between two decimal numbers passed as parameters. Returns an exception when the operation is unknown")
	public BigDecimal calculateResult(
			@RequestParam(defaultValue="0") BigDecimal firstValue,
            @RequestParam(defaultValue="0") BigDecimal secondValue,
            @RequestParam String operationType) {
		return service.calculate(firstValue, secondValue, operationType);
	}

}

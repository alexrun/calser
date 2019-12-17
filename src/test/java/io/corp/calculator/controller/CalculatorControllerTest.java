package io.corp.calculator.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CalculatorControllerTest {

	@Autowired
	private MockMvc mockMvc;
	private MockHttpServletRequestBuilder request;

	@Test
	void shouldAddTwoParameters() throws Exception {
		request = get("/calculator")
				.param("firstValue", "40.8")
				.param("secondValue", "1.2")
				.param("operationType", "add").contentType(MediaType.TEXT_PLAIN);
		String content = mockMvc.perform(request).andDo(print()).andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		Assertions.assertEquals("42", content);
	}

	@Test
	void shouldMultiplyTwoParameters() throws Exception {
		request = get("/calculator")
				.param("firstValue", "12")
				.param("secondValue", "12")
				.param("operationType", "mul").contentType(MediaType.TEXT_PLAIN);
		String content = mockMvc.perform(request).andDo(print()).andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		Assertions.assertEquals("144", content);
	}

	@Test
	void shouldSubtractTwoParameters() throws Exception {
		request = get("/calculator")
				.param("firstValue", "1234.56")
				.param("secondValue", "78.9")
				.param("operationType", "sub").contentType(MediaType.TEXT_PLAIN);
		String content = mockMvc.perform(request)
				.andDo(print()).andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		Assertions.assertEquals("1155.66", content);
	}

	@Test
	void shouldDivideTwoParameters() throws Exception {
		request = get("/calculator")
				.param("firstValue", "360.125")
				.param("secondValue", "3.2")
				.param("operationType", "div").contentType(MediaType.TEXT_PLAIN);
		String content = mockMvc.perform(request)
				.andDo(print()).andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		Assertions.assertEquals("112.5391", content);
	}

}

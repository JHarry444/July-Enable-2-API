package com.qa.biscuits.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.biscuits.domain.Biscuit;

@SpringBootTest
@AutoConfigureMockMvc
public class BiscuitControllerIntegrationTest {

	@Autowired
	private MockMvc mvc; // used to send our test requests

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Biscuit testBiscuit = new Biscuit("Shortbread", 12, 36);
		RequestBuilder req = post("/createBiscuit").content(this.mapper.writeValueAsString(testBiscuit))
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isCreated();
		Biscuit testSavedBiscuit = new Biscuit(1, "Shortbread", 12, 36);
		ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testSavedBiscuit));

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testCreateButHardToRead() throws Exception {
		this.mvc.perform(
				post("/createBiscuit").content(this.mapper.writeValueAsString(new Biscuit("Shortbread", 12, 36)))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(this.mapper.writeValueAsString(new Biscuit(1, "Shortbread", 12, 36))));
	}
}

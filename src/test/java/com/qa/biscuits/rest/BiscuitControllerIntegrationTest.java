package com.qa.biscuits.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.biscuits.domain.Biscuit;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:biscuit-schema.sql",
		"classpath:biscuit-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test") // sets profile to "test" so it uses the application-test.properties
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
		Biscuit testSavedBiscuit = new Biscuit(3, "Shortbread", 12, 36);
		ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testSavedBiscuit));

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testCreateButHardToRead() throws Exception {
		this.mvc.perform(
				post("/createBiscuit").content(this.mapper.writeValueAsString(new Biscuit("Shortbread", 12, 36)))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(this.mapper.writeValueAsString(new Biscuit(3, "Shortbread", 12, 36))));
	}

	@Test
	void testGet() throws Exception {
		List<Biscuit> biscuits = List.of(new Biscuit(1, "Jammy Dodgers", 12, 44.94),
				new Biscuit(2, "Custard Creams", 24, 50));

		ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(biscuits));
		this.mvc.perform(get("/getAll")).andExpect(status().isOk()).andExpect(checkBody);
	}

	@Test
	void testGetById() throws Exception {
		ResultMatcher checkBody = content()
				.json(this.mapper.writeValueAsString(new Biscuit(1, "Jammy Dodgers", 12, 44.94)));

		this.mvc.perform(get("/get/1")).andExpect(status().isOk()).andExpect(checkBody);
	}
}

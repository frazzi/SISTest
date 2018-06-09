package com.fs.footballTeams;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fs.footballTeams.model.FootyTeamStub;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FootballTeamsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FootballTeamsApplicationTests {

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	ObjectMapper mapper = new ObjectMapper();
	FootyTeamStub footyTeamStub = new FootyTeamStub();

	@LocalServerPort
	private int port;

	@Test
	public void footyTeamControllerFindAllTeams() throws JSONException, JsonProcessingException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/teams"),
				HttpMethod.GET, entity, String.class);
		String expected = mapper.writeValueAsString(footyTeamStub.findAllTeams());
		JSONAssert.assertEquals(expected, response.getBody(), false);

	}

	@Test
	public void footyTeamControllerFindTeamByName() throws JSONException, JsonProcessingException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/team-by-name/white shirts"),
				HttpMethod.GET, entity, String.class);
		String expected = mapper.writeValueAsString(footyTeamStub.findTeamByName("White shirts"));
		JSONAssert.assertEquals(expected, response.getBody(), false);

	}

	@Test
	public void footyTeamControllerGetSortedTeamsByStadiumCapacity() throws JSONException, JsonProcessingException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/teams-sorted/capacity"),
				HttpMethod.GET, entity, String.class);
		String expected = mapper.writeValueAsString(footyTeamStub.findTeamsSortedByCapacity("capacity"));
		JSONAssert.assertEquals(expected, response.getBody(), false);

	}


	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}

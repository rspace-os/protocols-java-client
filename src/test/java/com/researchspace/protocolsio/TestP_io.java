package com.researchspace.protocolsio;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestP_io {
	File p8163 = new File("src/test/resources/p_io_8163.json");
	File titleComponent = new File("src/test/resources/titleComponent.json");
	File commentComponent = new File("src/test/resources/commentComponent.json");
	File reagentComponent = new File("src/test/resources/reagent.json");
	File protocolComponent = new File("src/test/resources/protocolComponent.json");
	File allComponent = new File("src/test/resources/allComponentExamples.json");
	File unknownComponent = new File("src/test/resources/unknown_component_id.json");

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Loads protocol 8163")
	public void testProtocol_8163() throws IOException {
		String json = readFile(p8163);
		Protocol p = parseJson(json, Protocol.class);
		System.err.println(p.getId());
	}

	@Test
	public void testProtocolComponent() throws IOException {
		String json = readFile(protocolComponent);
		ProtocolComponent title = parseJson(json, ProtocolComponent.class);

	}

	@Test
	@DisplayName("Loads  a title object")
	public void testTitle() throws IOException {
		String json = readFile(titleComponent);
		PIOTitleComponent title = parseJson(json, PIOTitleComponent.class);
		assertTrue(title.getSource().getTitle().contains("colorimetric"));
	}

	@Test
	@DisplayName("Loads  a Reagent object")
	public void loadReagent() throws IOException {
		String json = readFile(reagentComponent);
		PIOReagent reagentComponent = parseJson(json, PIOReagent.class);
		assertEquals("biorbyt", reagentComponent.getVendor().getName());
	}

	@Test
	@DisplayName("Loads  a Comment object")
	public void testComments() throws IOException {
		String json = readFile(commentComponent);
		PIOCommentComponent comment = parseJson(json, PIOCommentComponent.class);
		assertEquals(2, comment.getSource().getComments().size());
	}

	@Test
	@DisplayName("Loads all component types")
	public void testAll() throws IOException {
		String json = readFile(allComponent);
		Protocol protocol = parseJson(json, Protocol.class);
		assertEquals(18, protocol.getSteps().get(0).getComponents().size());
		assertEquals(1, protocol.getVersions().size());
	}

	@Test
	@DisplayName("Handles unknown component types")
	public void unknownStepComponent() throws IOException {
		String json = readFile(unknownComponent);
		Protocol protocol = parseJson(json, Protocol.class);
		PIOStep eightStep =  protocol.getSteps().get(8);
		PIOStepComponent centrifugeStep = eightStep.getComponents().get(4);
		assertEquals("centrifuge", centrifugeStep.getTitle());
	}

	private String readFile(File jsonFile) throws IOException {
		return FileUtils.readFileToString(jsonFile, "UTF-8");
	}

	private <T> T parseJson(String json, Class<T> clazz) throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		T p = mapper.readValue(json, clazz);
		return p;
	}

}

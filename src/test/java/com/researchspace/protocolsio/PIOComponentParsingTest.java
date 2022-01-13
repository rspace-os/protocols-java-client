package com.researchspace.protocolsio;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

public class PIOComponentParsingTest {
	File p8163 = new File("src/test/resources/p_io_8163.json");
	File titleComponent = new File("src/test/resources/titleComponent.json");
	File commentComponent = new File("src/test/resources/commentComponent.json");
	File reagentComponent = new File("src/test/resources/reagent.json");
	File protocolComponent = new File("src/test/resources/protocolComponent.json");
	File allComponent = new File("src/test/resources/allComponentExamples.json");
	File unknownComponent = new File("src/test/resources/unknown_component_id.json");
	File equipmentComponent = new File("src/test/resources/equipmentComponent.json");
	File fileComponent = new File("src/test/resources/fileComponent.json");
	File documentsComponent = new File("src/test/resources/documentsComponent.json");
	File shakerComponent = new File("src/test/resources/shakerComponent.json");

	@Test
	@DisplayName("Loads protocol 8163")
	public void testProtocol_8163() throws IOException {
		String json = readFile(p8163);
		Protocol p = parseJson(json, Protocol.class);
		assertNotNull(p.getId());
	}

	@Test
	public void testProtocolComponent() throws IOException {
		String json = readFile(protocolComponent);
		ProtocolComponent protocolComponent = parseJson(json, ProtocolComponent.class);
		assertNotNull(protocolComponent.getId());
	}

	@Test
	@DisplayName("Loads a title object")
	public void testTitle() throws IOException {
		String json = readFile(titleComponent);
		PIOTitleComponent title = parseJson(json, PIOTitleComponent.class);
		assertTrue(title.getSource().getTitle().contains("colorimetric"));
	}

	@Test
	@DisplayName("Loads a Reagent object")
	public void loadReagent() throws IOException {
		var json = readFile(reagentComponent);
		PIOReagent reagentComponent = parseJson(json, PIOReagent.class);
		assertEquals("biorbyt", reagentComponent.getVendor().getName());
	}

	@Test
	@DisplayName("Loads a Comment object")
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
	public void unknownStepComponentTest() throws IOException {
		String json = readFile(unknownComponent);
		Protocol protocol = parseJson(json, Protocol.class);
		PIOStep eightStep =  protocol.getSteps().get(8);
		PIOStepComponent centrifugeStep = eightStep.getComponents().get(4);
		assertEquals("centrifuge", centrifugeStep.getTitle());
	}

	@Test
	@DisplayName("Handles equipment component types")
	public void equipmentStepComponentTest() throws IOException {
		String json = readFile(equipmentComponent);
		Protocol protocol = parseJson(json, Protocol.class);
		PIOStep stepFour =  protocol.getSteps().get(2);
		PIOStepComponent equipmentStep = stepFour.getComponents().get(3);
		assertEquals("equipment", equipmentStep.getTitle());
	}

	@Test
	@DisplayName("Handles file component types")
	public void fileStepComponentTest() throws IOException {
		String json = readFile(fileComponent);
		Protocol protocol = parseJson(json, Protocol.class);
		PIOStep firstStep =  protocol.getSteps().get(0);
		PIOStepComponent fileComponent = firstStep.getComponents().get(2);
		assertEquals("file", fileComponent.getTitle());
	}

	@Test
	@DisplayName("Handles documents component types")
	public void documentsStepComponentTest() throws IOException {
		String json = readFile(documentsComponent);
		Protocol protocol = parseJson(json, Protocol.class);
		PIOStep stepEight =  protocol.getSteps().get(7);
		PIOStepComponent documentsStep = stepEight.getComponents().get(2);
		assertEquals("documents", documentsStep.getTitle());
	}

	@Test
	@DisplayName("Handles shaker component types")
	public void shakerStepComponent() throws IOException {
		String json = readFile(shakerComponent);
		Protocol protocol = parseJson(json, Protocol.class);
		PIOStep stepThree =  protocol.getSteps().get(2);
		PIOStepComponent shakerComponent = stepThree.getComponents().get(4);
		assertEquals("shaker", shakerComponent.getTitle());
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

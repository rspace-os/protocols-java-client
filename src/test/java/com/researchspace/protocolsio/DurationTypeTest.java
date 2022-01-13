package com.researchspace.protocolsio;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class DurationTypeTest {

	@Test
	@DisplayName("duration component formats millis to a time string")
	void getDurationString() {
		PIODurationComponentType duration = new PIODurationComponentType("incubate", 601);
		assertEquals("10 minutes 1 second", duration.getDurationString());
	}

}

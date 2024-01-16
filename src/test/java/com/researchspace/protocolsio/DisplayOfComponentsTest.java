package com.researchspace.protocolsio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DisplayOfComponentsTest {

	@Test
	@DisplayName("duration component formats millis to a time string")
	void getDurationString() {
		PIODurationComponentType duration = new PIODurationComponentType("incubate", 601);
		assertEquals("10 minutes 1 second", duration.getDurationString());
	}

	@Test
	@DisplayName("duration component formats millis to a time string")
	void getAmountString() {
		PIOAmountComponentType amount1 = new PIOAmountComponentType("µl", "", 10.0);
		assertEquals("10.0 µl", amount1.getAmountString());

		PIOAmountComponentType amount2 = new PIOAmountComponentType(null, "", 10.0);
		assertEquals("10.0", amount2.getAmountString());

	}

	@Test
	@DisplayName("Concentration component displays correctly")
	void getConcentrationString() {
		PIOConcentrationComponentType concentration = new PIOConcentrationComponentType("Milimolar (mM)", "",100.0);
		assertEquals("100.0 Milimolar (mM)", concentration.getConcentrationString());
	}

	@Test
	@DisplayName("Temperature component displays correctly")
	void getTemperatureString() {
		PIOTemperatureComponentType temp1 = new PIOTemperatureComponentType("°C", "", 10.0);
		assertEquals("10.0 °C", temp1.getTemperatureString());

		PIOTemperatureComponentType temp2 = new PIOTemperatureComponentType("Room temperature", "(storage)", 0.0);
		assertEquals("Room temperature (storage)", temp2.getTemperatureString());
	}


	@Test
	@DisplayName("Shaker component displays correctly")
	void getShakerString() {
		PIOShakerComponentType shaker1 = new PIOShakerComponentType(0, "", "200", "30", 10, 33);
		assertEquals("200 rpm, 30°C", shaker1.getShakerString());

		PIOShakerComponentType shaker2 = new PIOShakerComponentType(1000, "", "100", "25", 10, 34);
		assertEquals("100 x g, 25°C, 16 minutes 40 seconds", shaker2.getShakerString());
	}

	@Test
	@DisplayName("Centrifuge component displays correctly")
	void getCentrifugeString() {
		PIOCentrifugeComponentType centrifuge1 = new PIOCentrifugeComponentType("4000", 600, "", "4", 10, 34);
		assertEquals("4000 x g, 4°C, 10 minutes", centrifuge1.getCentrifugeString());

		PIOCentrifugeComponentType centrifuge2 = new PIOCentrifugeComponentType("400", 600, "", "4", 10, 33);
		assertEquals("400 rpm, 4°C, 10 minutes", centrifuge2.getCentrifugeString());
	}


}

package com.researchspace.protocolsio;

import lombok.Data;

@Data
public class PIOCentrifugeComponentType {

	private double amount;
	private int centrifuge, duration;
	private String label;
	private double temperature;
	private int temperatureUnit;
	private int unit;

}

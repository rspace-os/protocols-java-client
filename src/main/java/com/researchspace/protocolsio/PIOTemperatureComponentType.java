package com.researchspace.protocolsio;

import lombok.Data;

@Data
public class PIOTemperatureComponentType extends PIOStepComponentType {

	private String unit, title;
	private Double temperature;

}

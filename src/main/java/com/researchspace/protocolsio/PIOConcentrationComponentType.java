package com.researchspace.protocolsio;

import lombok.Data;

@Data
public class PIOConcentrationComponentType extends PIOStepComponentType {

	private String unit, title;
	private Double concentration;

}

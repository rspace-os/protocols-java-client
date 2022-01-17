package com.researchspace.protocolsio;

import lombok.Data;

@Data
public class PIOAmountComponentType extends PIOStepComponentType {

	private String unit, title;
	private Double amount;

}

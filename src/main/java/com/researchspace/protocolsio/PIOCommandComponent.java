package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOCommandComponent extends PIOStepComponent {
	public PIOCommandComponent() {
		super(TypeConstants.COMMAND);
	}

	private PIOCommandComponentType source;

}

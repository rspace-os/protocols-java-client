package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIODescription extends PIOStepComponent {
	public PIODescription() {
		super(TypeConstants.DESCRIPTION);
	}

	private PIODescriptionType source;
}

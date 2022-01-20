package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOReagentComponent extends PIOStepComponent {
	public PIOReagentComponent() {
		super(TypeConstants.REAGENT);
	}

	private PIOReagentComponentType source;
}

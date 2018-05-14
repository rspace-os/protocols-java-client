package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOCasesComponent extends PIOStepComponent {
	public PIOCasesComponent() {
		super(TypeConstants.STEP_CASES);
	}

	private PIOCasesComponentType source;

}

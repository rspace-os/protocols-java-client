package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOGotoPreviousStepComponent extends PIOStepComponent {
	public PIOGotoPreviousStepComponent() {
		super(TypeConstants.GOTO_PREVIOUS);
	}

	private PIOGotoPreviousStepComponentType source;

}

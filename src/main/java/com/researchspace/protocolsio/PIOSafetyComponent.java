package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOSafetyComponent extends PIOStepComponent {
	public PIOSafetyComponent() {
		super(TypeConstants.SAFETY);
	}

	private PIOSafetyComponentType source;

}

package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOSoftwareComponent extends PIOStepComponent {
	public PIOSoftwareComponent() {
		super(TypeConstants.SOFTWARE_PACKAGE);
	}

	private PIOSoftwareComponentType source;

}

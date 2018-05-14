package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOConcentrationComponent extends PIOStepComponent {
	public PIOConcentrationComponent() {
		super(TypeConstants.CONCENTRATION);
	}

	private PIOConcentrationComponentType source;

}

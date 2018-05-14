package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOTemperatureComponent extends PIOStepComponent {
	public PIOTemperatureComponent() {
		super(24);
	}

	private PIOTemperatureComponentType source;

}

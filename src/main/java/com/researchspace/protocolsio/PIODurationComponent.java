package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIODurationComponent extends PIOStepComponent {
	public PIODurationComponent() {
		super(TypeConstants.DURATION);
	}

	private PIODurationComponentType source;

}

package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOLinkComponent extends PIOStepComponent {
	public PIOLinkComponent() {
		super(TypeConstants.LINK);
	}

	private PIOLinkComponentType source;

}

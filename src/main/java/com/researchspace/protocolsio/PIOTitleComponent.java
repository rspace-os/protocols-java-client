package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOTitleComponent extends PIOStepComponent {
	public PIOTitleComponent() {
		super(TypeConstants.TITLE);
	}

	private PIOTitleComponentType source;

}

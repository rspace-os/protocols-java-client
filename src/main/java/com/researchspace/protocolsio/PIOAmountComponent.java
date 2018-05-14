package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOAmountComponent extends PIOStepComponent {
	public PIOAmountComponent() {
		super(TypeConstants.AMOUNT);
	}

	private PIOAmountComponentType source;

}

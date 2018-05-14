package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOExpectedResultComponent extends PIOStepComponent {
	public PIOExpectedResultComponent() {
		super(TypeConstants.EXPECTED_RESULT);
	}

	private PIOExpectedResultComponentType source;

}

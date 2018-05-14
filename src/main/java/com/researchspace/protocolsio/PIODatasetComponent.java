package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIODatasetComponent extends PIOStepComponent {
	public PIODatasetComponent() {
		super(TypeConstants.DATASET);
	}

	private PIODatasetComponentType source;

}

package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProtocolComponent extends PIOStepComponent {
	public ProtocolComponent() {
		super(TypeConstants.PROTOCOL);
	}

	private Protocol source;
}
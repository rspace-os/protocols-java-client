package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOCommentComponent extends PIOStepComponent {
	public PIOCommentComponent() {
		super(TypeConstants.COMMENT);
	}

	private PIOCommentComponentType source;

}

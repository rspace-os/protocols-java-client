package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOShakerComponent extends PIOStepComponent {

    public PIOShakerComponent() {
        super(TypeConstants.SHAKER);
    }

    private PIOShakerComponentType source;
}

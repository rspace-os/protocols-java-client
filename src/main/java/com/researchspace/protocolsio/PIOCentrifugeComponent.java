package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOCentrifugeComponent  extends  PIOStepComponent {

    public PIOCentrifugeComponent() {
        super(TypeConstants.CENTRIFUGE);
    }

    private PIOCentrifugeComponentType source;

}

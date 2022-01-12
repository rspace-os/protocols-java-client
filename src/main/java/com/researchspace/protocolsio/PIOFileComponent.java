package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOFileComponent extends PIOStepComponent {

    public PIOFileComponent() {
        super(TypeConstants.FILE);
    }

    private PIOFileComponentType source;

}

package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIODocumentsComponent extends PIOStepComponent {
    public PIODocumentsComponent() {
        super(TypeConstants.DOCUMENTS);
    }

    private Protocol source;

}

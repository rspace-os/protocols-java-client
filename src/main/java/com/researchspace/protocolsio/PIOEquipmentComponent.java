package com.researchspace.protocolsio;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PIOEquipmentComponent extends PIOStepComponent {
    public PIOEquipmentComponent() {
        super(TypeConstants.EQUIPMENT);
    }

    private PIOEquipmentComponentType source;

}

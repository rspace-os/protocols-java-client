package com.researchspace.protocolsio;

import lombok.Data;

@Data
public class PIOShakerComponentType extends PIOStepComponentType {

    // seconds
    private int duration;
    private String label;
    // shaker = amount of unit
    private String shaker;
    // empty = room temp
    private String temperature;
    // int representing temp unit, 10 = degrees C
    private int temperatureUnit;
    // int representing unit, 33 = rpm
    private int unit;

}

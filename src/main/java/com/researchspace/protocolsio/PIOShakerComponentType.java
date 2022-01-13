package com.researchspace.protocolsio;

import lombok.Data;

@Data
public class PIOShakerComponentType {

    // seconds
    private int duration;
    private String label;
    // shaker = rpm
    private String shaker;
    // empty = room temp
    private String temperature;

}

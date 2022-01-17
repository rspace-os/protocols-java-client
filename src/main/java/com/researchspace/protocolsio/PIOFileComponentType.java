package com.researchspace.protocolsio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PIOFileComponentType extends PIOStepComponentType {

    private String source;
    private String placeholder;
    @JsonProperty(value= "original_name")
    private String originalName;

}

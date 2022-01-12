package com.researchspace.protocolsio;

import lombok.Data;

import java.net.URL;

@Data
public class PIOEquipmentComponentType {

    private String brand;
    private String sku;
    private String specifications;
    @JsonProperty(value = "can_edit")
    private boolean canEdit;
    private String name;
    private String type;
    private URL link;
    private PIOFileComponent file;
    private Image image;

}

package com.researchspace.protocolsio;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PIOReagent {

	private Integer id;
	private String linfor, name, url, sku;
	private PIOUser vendor;
	@JsonProperty("mol_weight")
	private Float molWeight;
}

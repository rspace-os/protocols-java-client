package com.researchspace.protocolsio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PIOStep {

	private Integer id;
	private String guid;

	@JsonProperty("previous_id")
	private Integer previousId;

	@JsonProperty("previous_guid")
	private String previousGuid;

	@JsonProperty("modified_on")
	private Integer modifiedOn;

	private List<PIOStepComponent> components;

}

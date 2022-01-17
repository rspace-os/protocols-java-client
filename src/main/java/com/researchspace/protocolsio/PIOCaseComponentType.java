package com.researchspace.protocolsio;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PIOCaseComponentType extends PIOStepComponentType {

	private String title, label;

	@JsonProperty("step_id")
	private Integer stepId;

	@JsonProperty("step_guid")
	private String stepGuid;

}

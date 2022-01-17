package com.researchspace.protocolsio;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PIOGotoPreviousStepComponentType extends PIOStepComponentType {

	private String title;

	@JsonProperty("step_guid")
	private String stepGuid;

}

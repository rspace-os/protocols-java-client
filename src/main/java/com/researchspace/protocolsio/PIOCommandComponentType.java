package com.researchspace.protocolsio;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PIOCommandComponentType extends PIOStepComponentType {

	private String name, command;

	@JsonProperty("os_name")
	private String osName;

	@JsonProperty("os_version")
	private String osVersion;

}

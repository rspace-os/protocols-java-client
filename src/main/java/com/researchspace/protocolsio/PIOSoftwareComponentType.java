package com.researchspace.protocolsio;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PIOSoftwareComponentType extends PIOStepComponentType {

	private String name, developer, repository, link;

	@JsonProperty("os_name")
	private String osName;

	@JsonProperty("os_version")
	private String osVersion;

}

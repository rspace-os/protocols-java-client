package com.researchspace.protocolsio;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SmallProtocol {

	private Integer id;
	private String title, doi, uri;
	private Image image;
	@JsonProperty("published_on")
	private Long publishedOn;

	@JsonProperty("version_id")
	private Integer versionId;

}

package com.researchspace.protocolsio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PIOCommentComponentType extends PIOStepComponentType {

	private String title, body, uri;
	private Integer id;
	private PIOUser creator;

	@JsonProperty("created_on")
	private Integer createdOn;

	@JsonProperty("parent_id")
	private Integer parentId;

	@JsonProperty("changed_on")
	private Integer changedOn;

	private List<PIOCommentComponentType> comments;

}

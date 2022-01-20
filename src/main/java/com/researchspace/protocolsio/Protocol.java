package com.researchspace.protocolsio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Protocol {

	private Integer id;
	@JsonProperty(value = "has_versions")
	private Integer hasVersions;

	@JsonProperty("created_on")
	private Long createdOn;

	/**
	 * Corrects raw date format which is in seconds, not millis
	 * 
	 * @return
	 */
	public Date getCreationDate() {
		return new Date(createdOn * 1000);
	}

	/**
	 * Corrects raw date format
	 * 
	 * @return
	 */
	public Date getPublicationDate() {
		return new Date(publishedOn * 1000);
	}

	@JsonProperty("published_on")
	private Long publishedOn;

	@JsonProperty("version_id")
	private Integer versionId;

	@JsonProperty("public")
	private Integer publik;

	@JsonProperty("number_of_steps")
	Integer numberOfSteps;

	private String title;

	private String doi;

	private String uri;

	private String link;

	private String categories;

	private Image image;

	private PIOUser creator;

	private String description;

	@JsonProperty(value = "before_start")
    private String beforeStart;

	private List<SmallProtocol> versions;
	private List<PIOUser> authors = new ArrayList<>();
	private List<PIOStep> steps = new ArrayList<>();
	private List<PIOReagentComponentType> materials = new ArrayList<>();

	/**
	 * Order-in-place components in protocol steps according to the specified
	 * comparator
	 * 
	 * @param comparator
	 */
	public void orderComponents(Comparator<PIOStepComponent> comparator) {
		steps.forEach(step -> step.getComponents().sort(comparator));
	}
}
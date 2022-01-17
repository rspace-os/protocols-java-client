package com.researchspace.protocolsio;

import org.apache.commons.lang.time.DurationFormatUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PIODurationComponentType extends PIOStepComponentType {

	private String title;
	private Integer duration;



}

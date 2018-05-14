package com.researchspace.protocolsio;

import org.apache.commons.lang.time.DurationFormatUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PIODurationComponentType {

	private String title;
	private Integer duration;

	/**
	 * Gets the duration in words, e.g. '5 hours 30 minutes'
	 * 
	 * @return
	 */
	@JsonIgnore
	public String getDurationString() {
		if (duration != null) {
			return DurationFormatUtils.formatDurationWords(duration * 1000, true, true);
		} else {
			return "";
		}
	}

}

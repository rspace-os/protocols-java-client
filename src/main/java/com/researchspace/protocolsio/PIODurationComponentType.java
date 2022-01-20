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
		if (duration != 0) {
			return DurationFormatUtils.formatDurationWords(duration * 1000L, true, true);
		} else {
			return "";
		}
	}

}

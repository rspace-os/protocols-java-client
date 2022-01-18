package com.researchspace.protocolsio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.time.DurationFormatUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PIOCentrifugeComponentType {

	private String centrifuge;
	private int duration;
	private String label;
	private String temperature;
	private int temperatureUnit;
	private int unit;

	/**
	 * This method provides a string representing a centrifuge object retrieved from ProtocolsIO API
	 * @return the string representation of the centrifuge component e.g: 50 rpm, 37°C, 20 minutes
	 */
	@JsonIgnore
	public String getCentrifugeString() {
		StringBuilder result = new StringBuilder();

		// PIO API has several unit numbers that correspond to various units
		if(unit == 33) {
			result.append(centrifuge).append(" rpm");
		} else if(unit == 34) {
			result.append(centrifuge).append(" x g");
		}

		if(temperatureUnit == 10) {
			// temperature unit id 10 = °C
			result.append(", ").append(temperature).append("°C");
		}

		if(duration != 0) {
			result.append(", ").append(DurationFormatUtils.formatDurationWords(duration * 1000L, true, true));
		}


		return result.toString();
	}

}

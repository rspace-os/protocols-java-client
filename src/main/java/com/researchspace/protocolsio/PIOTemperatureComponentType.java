package com.researchspace.protocolsio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PIOTemperatureComponentType {

	private String unit;
	private String title;
	private Double temperature;

	@JsonIgnore
	public String getTemperatureString() {
		StringBuilder result = new StringBuilder();
		if(unit != null || !(unit.isEmpty())) {
			if(unit == "On ice" || unit == "Room temperature") {
				result.append(unit);
			} else {
				result.append(temperature).append(" ").append(unit);
			}
		}

		if(!title.isEmpty()) {
			result.append(" ").append(title);
		}

		return result.toString();
	}

}

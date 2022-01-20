package com.researchspace.protocolsio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PIOConcentrationComponentType {

	private String unit;
	private String title;
	private Double concentration;

	@JsonIgnore
	public String getConcentrationString() {
		StringBuilder result = new StringBuilder();
		if(unit != null && !(unit.isEmpty())) {
			result.append(concentration).append(" ").append(unit);
		} else {
			result.append(concentration);
		}

		if(!title.isEmpty()) {
			result.append(" ").append(title);
		}

		return result.toString();
	}

}

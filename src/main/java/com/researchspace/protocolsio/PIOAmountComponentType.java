package com.researchspace.protocolsio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PIOAmountComponentType {

	private String unit;
	private String title;
	private Double amount;

	@JsonIgnore
	public String getAmountString() {
		StringBuilder result = new StringBuilder();
		if(unit != null && !(unit.isEmpty())) {
			result.append(amount).append(" ").append(unit);
		} else {
			result.append(amount);
		}

		if(!(title.isEmpty())) {
			result.append(" ").append(title);
		}

		return result.toString();
	}

}

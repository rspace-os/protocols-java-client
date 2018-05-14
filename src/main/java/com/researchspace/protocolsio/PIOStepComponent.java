package com.researchspace.protocolsio;

import static com.researchspace.protocolsio.TypeConstants.AMOUNT;
import static com.researchspace.protocolsio.TypeConstants.COMMAND;
import static com.researchspace.protocolsio.TypeConstants.COMMENT;
import static com.researchspace.protocolsio.TypeConstants.CONCENTRATION;
import static com.researchspace.protocolsio.TypeConstants.DATASET;
import static com.researchspace.protocolsio.TypeConstants.DESCRIPTION;
import static com.researchspace.protocolsio.TypeConstants.DURATION;
import static com.researchspace.protocolsio.TypeConstants.EXPECTED_RESULT;
import static com.researchspace.protocolsio.TypeConstants.GOTO_PREVIOUS;
import static com.researchspace.protocolsio.TypeConstants.LINK;
import static com.researchspace.protocolsio.TypeConstants.NOTE;
import static com.researchspace.protocolsio.TypeConstants.PROTOCOL;
import static com.researchspace.protocolsio.TypeConstants.REAGENT;
import static com.researchspace.protocolsio.TypeConstants.SAFETY;
import static com.researchspace.protocolsio.TypeConstants.SOFTWARE_PACKAGE;
import static com.researchspace.protocolsio.TypeConstants.STEP_CASES;
import static com.researchspace.protocolsio.TypeConstants.TEMPERATURE;
import static com.researchspace.protocolsio.TypeConstants.TITLE;
import static com.researchspace.protocolsio.TypeConstants.UNKNOWN;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Data;

@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type_id")
@JsonSubTypes({ @Type(value = PIODescription.class, name = DESCRIPTION + ""),
		@Type(value = PIOAmountComponent.class, name = AMOUNT + ""),
		@Type(value = PIODurationComponent.class, name = DURATION + ""),
		@Type(value = PIOTitleComponent.class, name = TITLE + ""),
		@Type(value = PIOLinkComponent.class, name = LINK + ""),
		@Type(value = PIOSoftwareComponent.class, name = SOFTWARE_PACKAGE + ""),
		@Type(value = PIODatasetComponent.class, name = DATASET + ""),
		@Type(value = PIOCommentComponent.class, name = COMMENT + ""),
		@Type(value = PIOExpectedResultComponent.class, name = EXPECTED_RESULT + ""),
		@Type(value = PIOCommandComponent.class, name = COMMAND + ""),
		@Type(value = ProtocolComponent.class, name = PROTOCOL + ""),
		@Type(value = PIOSafetyComponent.class, name = SAFETY + ""),
		@Type(value = PIOReagentComponent.class, name = REAGENT + ""),
		@Type(value = PIOCasesComponent.class, name = STEP_CASES + ""),
		@Type(value = PIOGotoPreviousStepComponent.class, name = GOTO_PREVIOUS + ""),
		@Type(value = PIOTemperatureComponent.class, name = TEMPERATURE + ""),
		@Type(value = PIOConcentrationComponent.class, name = CONCENTRATION + ""),
		@Type(value = PIOCommentComponent.class, name = NOTE + ""),
		@Type(value = PIOUnknownComponent.class, name = UNKNOWN + ""),
		@Type(value = PIOUnknownComponent.class, name = "2"), @Type(value = PIOUnknownComponent.class, name = "5"),
		@Type(value = PIOUnknownComponent.class, name = "10"), @Type(value = PIOUnknownComponent.class, name = "11"),
		@Type(value = PIOUnknownComponent.class, name = "12"), @Type(value = PIOUnknownComponent.class, name = "16"),
		@Type(value = PIOUnknownComponent.class, name = "23") })
@Data()
public abstract class PIOStepComponent {

	/**
	 * Sorts so that title sections will be the part displayed first.
	 */
	public static Comparator<PIOStepComponent> DisplayOrder = (a, b) -> {
		if (a.getTypeId().equals(TypeConstants.TITLE)) {
			return -1;
		} else {
			return 0;
		}
	};

	public PIOStepComponent(Integer typeId) {
		this.typeId = typeId;
	}

	private Integer id;
	private String guid;
	@JsonProperty("order_id")
	private Integer orderId;

	@JsonProperty("type_id")
	private Integer typeId;

	private String title;

}

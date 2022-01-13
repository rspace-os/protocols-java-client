package com.researchspace.protocolsio;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class DisplayOrderOfComponentsTest {

	@Test
	@DisplayName("PIOStepComponent.DisplayOrder puts title first")
	void displayOrder() {
		List<PIOStepComponent> parts = createComponentsList();
		parts.sort(PIOStepComponent.DisplayOrder);
		assertEquals(TypeConstants.TITLE, parts.get(0).getTypeId().intValue());
	}

	@Test
	@DisplayName("title component is always first after ordering protocol")
	void orderProtocols() {
		List<PIOStepComponent> parts = createComponentsList();
		List<PIOStepComponent> part2 = createComponentsList();
		Protocol p = new Protocol();
		List<PIOStep> steps = new ArrayList<>();
		PIOStep step1 = new PIOStep();
		step1.setComponents(parts);
		PIOStep step2 = new PIOStep();
		step2.setComponents(part2);
		steps.add(step1);
		steps.add(step2);
		p.setSteps(steps);
		p.orderComponents(PIOStepComponent.DisplayOrder);
		p.getSteps().forEach(step -> {
			assertEquals(TypeConstants.TITLE, step.getComponents().get(0).getTypeId().intValue());
		});

	}

	private List<PIOStepComponent> createComponentsList() {
		List<PIOStepComponent> parts = new ArrayList<>();
		parts.add(new PIOSoftwareComponent());
		parts.add(new PIOLinkComponent());
		parts.add(new PIOTitleComponent());
		return parts;
	}

}

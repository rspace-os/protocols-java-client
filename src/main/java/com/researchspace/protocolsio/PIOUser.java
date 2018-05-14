package com.researchspace.protocolsio;

import lombok.Data;

@Data
public class PIOUser {
	private String name, username, affiliation, link;
	private Image image;

}

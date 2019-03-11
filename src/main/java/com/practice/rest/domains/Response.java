package com.practice.rest.domains;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Response {
	@JsonInclude(value = Include.NON_NULL)
	Set<String> mutualFunds;
	private UUID uuid;
	private String name;
	private Date timestamp;

	public Response(Set<String> mutualFunds, UUID uuid, String name, Date timestamp) {
		super();
		this.mutualFunds = mutualFunds;
		this.uuid = uuid;
		this.name = name;
		this.timestamp = timestamp;
	}

	public Set<String> getMutualFunds() {
		return mutualFunds;
	}

	public void setMutualFunds(Set<String> mutualFunds) {
		this.mutualFunds = mutualFunds;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}

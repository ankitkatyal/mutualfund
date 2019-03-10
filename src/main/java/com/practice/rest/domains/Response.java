package com.practice.rest.domains;

import java.util.Set;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Response {
	@JsonInclude(value=Include.NON_NULL)
	Set<String> mutualFunds;
	private UUID uuid;
	private String name;
	private HttpStatus responseCode;

	
	public Response(Set<String> mutualFunds, UUID uuid, String name, HttpStatus responseCode) {
		super();
		this.mutualFunds = mutualFunds;
		this.uuid = uuid;
		this.name = name;
		this.responseCode = responseCode;
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

	public HttpStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}

}

package com.practice.rest.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.rest.dao.DaoImpl;
import com.practice.rest.domains.MutualFund;
import com.practice.rest.domains.Response;

@RestController
public class RequestController {

	@Autowired
	private DaoImpl service;

	@GetMapping(path = "/mutualfunds/{name}")
	public MutualFund getMutualFundDetails(@PathVariable String name) {
		return service.getMutualFundDetails(name);
	}

	@PostMapping(path = "/mutualfunds")
	public Response addMutualFundDetails(@RequestBody MutualFund mutualFund) {
		service.insertMutualFund(mutualFund);
		return new Response(null, UUID.randomUUID(), "created", HttpStatus.CREATED);
	}

	@GetMapping(path = "/mutualfunds")
	public Response getAllMutualFundDetails() {
		return new Response(service.getAllMutualFundDetails(), UUID.randomUUID(), "sucess", HttpStatus.OK);
	}

}

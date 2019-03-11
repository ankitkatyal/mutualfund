package com.practice.rest.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.rest.dao.DaoImpl;
import com.practice.rest.domains.MutualFund;
import com.practice.rest.domains.MutualFundNotFound;
import com.practice.rest.domains.Response;

@RestController
public class RequestController {

	@Autowired
	private DaoImpl service;

	@GetMapping(path = "/mutualfunds/{name}")
	public ResponseEntity<Response> getMutualFundDetails(@PathVariable String name) throws MutualFundNotFound {
		MutualFund mutualFund = service.getMutualFundDetails(name);
		if (mutualFund == null) {
			Set<String> mutualList = new HashSet<String>();
			Response response = new Response(mutualList , UUID.randomUUID(), name, new Date());
			return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		}
		Set<String> mutualList = new HashSet<String>();
		mutualList.add(mutualList.toString());
		Response response = new Response(mutualList , UUID.randomUUID(), name, new Date());
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/mutualfunds")
	public ResponseEntity<Response> addMutualFundDetails(@RequestBody MutualFund mutualFund) {
		service.insertMutualFund(mutualFund);
		Response response = new Response(null, UUID.randomUUID(), "success", new Date());
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

	@GetMapping(path = "/mutualfunds")
	public ResponseEntity<Response> getAllMutualFundDetails() {
		Response response = new Response(service.getAllMutualFundDetails(), UUID.randomUUID(), "sucess", new Date());
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}

package com.practice.rest.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.practice.rest.domains.MutualFundNotFound;
import com.practice.rest.domains.Response;

@ControllerAdvice
@RestController
public class MutualFundResourceHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MutualFundNotFound.class)
	public Response mutualFundNotFound() {
		return new Response(null, UUID.randomUUID(), "You are looking for wrong name", new Date());
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Response> handleAllException(Exception ex, WebRequest request) {
		Response response = new Response(null, UUID.randomUUID(), request.getDescription(false),new Date() );
		return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

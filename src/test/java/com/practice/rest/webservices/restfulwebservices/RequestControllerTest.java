package com.practice.rest.webservices.restfulwebservices;

import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;

public class RequestControllerTest {
	
	@BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }
 
    @Test
    public void testUserFetchesSuccess() {
        get("/mutualfund/BlueChip")
        .then()
        .body("name", equalTo("BlueChip"));
    }

}

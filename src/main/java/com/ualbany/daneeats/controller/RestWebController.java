package com.ualbany.daneeats.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ualbany.daneeats.message.Response;

@RestController
@RequestMapping("/api")
public class RestWebController {

	@GetMapping(value = "/all")
	public Response getResource() {
		Response response = new Response("Done", "");
		return response;
	}

	@PostMapping(value = "/customer/save")
	public Response postCustomer(@RequestBody String customer) {
		//cust.add(customer);
		
		// Create Response Object
		Response response = new Response("Done", customer);
		return response;
	}
}
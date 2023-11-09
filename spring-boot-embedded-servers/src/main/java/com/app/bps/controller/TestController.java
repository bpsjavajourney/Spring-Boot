package com.app.bps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 
 * TestController
 * 
 * @author parth
 *
 */
@RestController
public class TestController {

	@GetMapping("/home")
	public String  test() {

		return "Hello...Go to pom.xml to modify the server configuration.";
	}

}

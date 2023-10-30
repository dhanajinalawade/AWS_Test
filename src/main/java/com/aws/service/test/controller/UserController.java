package com.aws.service.test.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.service.test.domain.Users;
import com.aws.service.test.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	private final UserService userService;
	
	@GetMapping(value =  "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Users getUser(@PathVariable long id) {
		
		Users user = userService.getUser(id);
		
		log.debug(" user" + user);
		return user;
	}
	
	@GetMapping(value = "/system_details")
	public String systemDetails() throws UnknownHostException {
		
		
		return InetAddress.getLocalHost().getHostName() + ":" + InetAddress.getLocalHost().getHostAddress();
	}
	
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public long saveUser(@RequestBody Users user) {
		log.debug("objeect {}" ,user);
		return userService.addUser(user);
	}

}

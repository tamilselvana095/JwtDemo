package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.dto.LoginDto;
import com.jwt.dto.SignUpDto;
import com.jwt.exception.UserNotFound;
import com.jwt.model.User;
import com.jwt.service.UserService;
import com.jwt.utils.JwtUtils;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signup")
	public String signUp(@RequestBody SignUpDto signUpDto ) { return userService.signUp(signUpDto);}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDto loginDto) throws UserNotFound { return userService.login(loginDto);}
	
	@GetMapping("/getall")
	public List<User> getAll(/* @RequestHeader String token */) {
		
				//jwtUtils.verify(token);
		
		return userService.getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) throws UserNotFound {
		return userService.deleteUser(id);
	}
		
	

}

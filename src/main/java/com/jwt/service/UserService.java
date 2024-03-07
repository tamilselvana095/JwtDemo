package com.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.Repository.UserRepository;
import com.jwt.dto.LoginDto;
import com.jwt.dto.SignUpDto;
import com.jwt.exception.UserNotFound;
import com.jwt.model.User;
import com.jwt.utils.JwtUtils;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtUtils jwtUtils;

	public String signUp(SignUpDto signUpDto) {
		
		User user=new User();
			 user.setId(signUpDto.getId());
			 user.setName(signUpDto.getName());
			 user.setEmailId(signUpDto.getEmailId());
			 user.setGender(signUpDto.getGender());
			 user.setPassword(signUpDto.getPassword());
			 user.setPhoneNumber(signUpDto.getPhoneNumber());
		
		userRepository.save(user);
		
		return "signup successfully";
	}

	public String login(LoginDto loginDto) throws UserNotFound {
		
		User user=userRepository.getAuthorizedUser(loginDto.getEmailId(),loginDto.getPassword());
		if (user==null) {
			throw new UserNotFound("User not found");
		}
		
		System.out.println(user);
		
		String token=jwtUtils.createToken(user);
		
		
		return token;
	}

	public List<User> getAll() {
		
		return userRepository.findAll();
	}

	public String deleteUser(Long id) throws UserNotFound {
	
		userRepository.deleteById(id);
		return "Deleted successfully";
	}
	
	

}

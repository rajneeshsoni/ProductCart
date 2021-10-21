package com.productcart.api.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.productcart.api.model.Users;
import com.productcart.api.repository.UserRepository;



@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
	
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users data = null;
		data = userRepo.findByUsername(username);
		return new User(data.getUsername(), data.getPassword(), new ArrayList<>()); 
	}

}

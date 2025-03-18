package com.valtech.training.springsecurity.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.valtech.training.springsecurity.entities.User;
import com.valtech.training.springsecurity.vos.ChangePasswordVO;

import jakarta.annotation.PostConstruct;

public interface UserManagerService {


	void registerUser(User user);

	void changePassword(String username, ChangePasswordVO changePassword);

	

}
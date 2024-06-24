package com.eloizaams.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloizaams.workshopmongo.domain.User;
import com.eloizaams.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo; //o Spring instancia automaticamente
	
	public List<User> findAll(){
		return repo.findAll();
	}
}

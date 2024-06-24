package com.eloizaams.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloizaams.workshopmongo.domain.User;
import com.eloizaams.workshopmongo.dto.UserDTO;
import com.eloizaams.workshopmongo.repository.UserRepository;
import com.eloizaams.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo; //o Spring instancia automaticamente
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert (User obj) {
		return repo.insert(obj);
	}
	
	public void delete (String id) {
		findById(id); //usado apenas para lançar a excessão caso o id nao exista
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(),objDTO.getEmail());
	}
	
}

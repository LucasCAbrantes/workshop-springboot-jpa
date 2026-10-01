package com.myhouse.couser.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.myhouse.couser.entities.User;
import com.myhouse.couser.repositories.CategoryRepository;
import com.myhouse.couser.repositories.UserRepository;
import com.myhouse.couser.services.exceptions.DatabaseException;
import com.myhouse.couser.services.exceptions.ResourceNotFoundException;

@Component
public class UserService {

    private final CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;

    UserService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
	
	public List<User> findAll(){
		return userRepository.findAll();
		
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		if (!userRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
			}
		try {
			userRepository.deleteById(id);;
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
			
	}
	
	public User update(Long id , User obj) {
		User entity = userRepository.getReferenceById(id);
		updateData(entity,obj);
		return userRepository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}

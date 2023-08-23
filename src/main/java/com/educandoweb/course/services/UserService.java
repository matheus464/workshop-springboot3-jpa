package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id){
        Optional<User> u =  userRepository.findById(id);
        return u.orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public User insert(User obj){
        return userRepository.save(obj);
    }

    @Transactional(readOnly = true)
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public User update(Long id, User obj){
        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    @Transactional(readOnly = false)
    public void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}

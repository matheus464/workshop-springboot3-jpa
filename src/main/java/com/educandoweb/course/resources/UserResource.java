package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<ArrayList<User>> findAll(){
        ArrayList<User> usuarios = new ArrayList<>();
        usuarios.add(new User(1l, "Maria", "maria@gmail.com", "999999", "123456"));
        usuarios.add(new User(2l, "Jorge", "jorge@gmail.com", "888888", "123456"));
        usuarios.add(new User(3l, "Matheus", "matheus@gmail.com", "77777", "123456"));
        usuarios.add(new User(4l, "Camila", "camila@gmail.com", "66666", "123456"));

        return ResponseEntity.ok().body(usuarios);
    }
}

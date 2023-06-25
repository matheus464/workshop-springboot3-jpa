package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository repository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(1l, "Matheus", "matheus@gmail.com", "98888888", "123456");
        User u2 = new User(2l, "Maria", "maria@gmail.com", "97777777", "123456");
        repository.saveAll(Arrays.asList(u1, u2));
    }
}

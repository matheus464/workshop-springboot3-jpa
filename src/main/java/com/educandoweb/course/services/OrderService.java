package com.educandoweb.course.services;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Order findById(Long id){
        Optional<Order> result = orderRepository.findById(id);
        return result.get();
    }
}

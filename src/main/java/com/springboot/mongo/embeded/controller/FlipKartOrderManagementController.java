package com.springboot.mongo.embeded.controller;

import com.springboot.mongo.embeded.model.User;
import com.springboot.mongo.embeded.repository.FlipKartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-service")
public class FlipKartOrderManagementController {


    @Autowired
    private FlipKartRepository repository;

    @PostMapping("/placeOrderNow")
    public String placeOrder(@RequestBody User user) {
        repository.save(user);
        return "Order placed successfully";
    }

    @GetMapping("/getUserByName/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return repository.findByName(name);
    }

    @GetMapping("/getUserByAddress/{city}")
    public List<User> getUserByAddress(@PathVariable String city) {
        return repository.findByCity(city);
    }
}

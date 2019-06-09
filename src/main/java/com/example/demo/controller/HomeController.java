package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.User;
import com.example.demo.repo.UserRepository;

@Controller
public class HomeController {
	private UserRepository repository;
    @Autowired
    public HomeController(UserRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/home")
    public String home(Model model) {
        List<User> users = repository.findAll();
        model.addAttribute("users", users);
        return "home";
    }
}

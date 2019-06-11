package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.actuator.metrics.LoginService;
import com.example.demo.dao.User;
import com.example.demo.repo.UserRepository;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.util.Random;

@Controller
public class HomeController {
	private UserRepository repository;

	@Autowired
	public HomeController(UserRepository repository) {
		this.repository = repository;
	}

	@Autowired
	LoginService loginService;

	@GetMapping("/home")
	public String home(Model model) {
		collectMatrix();
		List<User> users = repository.findAll();
		model.addAttribute("users", users);
		return "home";
	}

	public void collectMatrix() {
		Random rand = new Random();
		String emails[] = { "arun@gmail.com", "a.kr@gmail.com", "techarun@gmail.com" };
		int rand_int1 = rand.nextInt(3);
		givenGlobalRegistry_whenIncrementAnywhere_thenCounted();
		loginService.login(emails[rand_int1], "admin");
		loginService.login(emails[rand_int1], "adminxxx");
	}

	public void givenGlobalRegistry_whenIncrementAnywhere_thenCounted() {
		class CountedObject {
			private CountedObject() {
				Metrics.counter("objects.instance-x-x").increment(1.0);
			}
		}
		// Metrics.addRegistry(new SimpleMeterRegistry());
		new CountedObject();

	}
}

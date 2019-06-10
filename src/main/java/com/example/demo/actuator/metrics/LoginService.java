package com.example.demo.actuator.metrics;

import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Metrics;

@Service
public class LoginService {

	 public boolean login(String email, String password)
	    {
	        if("admin@gmail.com".equalsIgnoreCase(email) && "admin".equals(password)){
	            //counterService.increment("counter.login.success");
	        	Metrics.counter("counter.login.success").increment(1.0);
	            return true;
	        } else {
	        	Metrics.counter("counter.login.failure").increment(1.0);
	            //counterService.increment("counter.login.failure");
	            return false;
	        }
	    }
	}


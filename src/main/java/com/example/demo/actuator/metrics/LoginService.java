package com.example.demo.actuator.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;

@Service
public class LoginService {
@Autowired 
MeterRegistry meterRegistry;
	 public boolean login(String email, String password)
	    {
	        if("admin@gmail.com".equalsIgnoreCase(email) && "admin".equals(password)){
	            //counterService.increment("counter.login.success");
	        	Metrics.counter("counter.login.success").increment(1.0);
	        	meterRegistry.counter("login.access", "accessCounter",email).increment();
	            return true;
	        } else {
	        	Metrics.counter("counter.login.failure").increment(1.0);
	            //counterService.increment("counter.login.failure");
	            return false;
	        }
	    }
	}


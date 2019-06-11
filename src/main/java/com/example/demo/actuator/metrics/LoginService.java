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
		 meterRegistry.counter("login.access", "accessCounter",email).increment();
	        if("arun@gmail.com".equalsIgnoreCase(email)){
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


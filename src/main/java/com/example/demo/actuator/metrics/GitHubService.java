package com.example.demo.actuator.metrics;


import javax.persistence.PostPersist;

import org.springframework.context.annotation.Configuration;

import com.example.demo.dao.User;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

@Configuration
public class GitHubService {
	 @PostPersist
	    public void handleAfterCreate(User order) {
	        final Counter counter = Metrics.counter("entity.count", "type", "order");
	        counter.increment();
	    }
	}    
package com.example.demo.actuator.metrics;


import javax.persistence.PostPersist;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.User;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

//@Configuration
public class GitHubService {
	 @PostPersist
	    public void handleAfterCreate(User order) {
	        final Counter counter = Metrics.counter("entity.count", "type", "order");
	        counter.increment();
	    }
	}    
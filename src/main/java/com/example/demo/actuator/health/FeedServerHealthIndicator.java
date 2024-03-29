package com.example.demo.actuator.health;

import java.util.Date;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Component
public class FeedServerHealthIndicator implements HealthIndicator
{
	
	    @Override
	    public Health health() {
	        RestTemplate restTemplate = new RestTemplate();
	        String url = "https://www.google.co.in";
	        try {
	            String resp = restTemplate.getForObject(url, String.class);
	            if("OK".equalsIgnoreCase(resp)){
	                return Health.up().
	                        build();
	            } else {
	                return Health.down()
	                        .withDetail("ping_url", url)
	                        .withDetail("ping_time", new Date())
	                        .build();
	            }
	        } catch (RestClientException e) {
	            return Health.down(e)
	                    .withDetail("ping_url", url)
	                    .withDetail("ping_time", new Date())
	                    .build();
	        }
	    }
	
}
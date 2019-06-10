package com.example.demo.actuator.metrics;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;com.apress.demo.models.GitHubUser;

@Configuration
public class GitHubService {
	@Autowired
	GaugeService gaugeService;

	public GitHubUser getUserInfo(String username) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.github.com/users/" + username;
		GitHubUser gitHubUser = null;
		try {
			long start = System.currentTimeMillis();
			gitHubUser = restTemplate.getForObject(url, GitHubUser.class);
			long end = System.currentTimeMillis();
			gaugeService.submit("gauge.guthub.response-time", (end - start));
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return gitHubUser;
	}
}}
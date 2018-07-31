package com.shawpartners.resource;

import java.util.List;


import org.springframework.beans.support.PagedListHolder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shawpartners.model.Repos;
import com.shawpartners.model.User;


@RestController
@RequestMapping("/api/users")
public class GitHubResource {

	private final String URI = "https://api.github.com";
	
	@GetMapping("/{username}/details")
	public ResponseEntity<User> getUserDetails(@PathVariable String username){
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> response = restTemplate.getForEntity(URI + "/users/" + username, User.class);
		
		User user = response.getBody();		
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/{username}/repos")
	public ResponseEntity<List<Repos>> getUserRepo(@PathVariable String username){
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Repos>> response = restTemplate.exchange(URI + "/users/" + username + "/repos", HttpMethod.GET, null , 
				new ParameterizedTypeReference<List<Repos>>() {
		}); 		
		
		return response.ok().body(response.getBody());
	}
	
	@GetMapping()
	public PagedListHolder<User> getUsers(@RequestParam String since ){

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<User>> response = restTemplate.exchange(URI + "/users?since=" + since +"?pageSize=30", HttpMethod.GET, null , 
				new ParameterizedTypeReference<List<User>>() {
		}); 
	
		List<User> users = response.getBody();
		PagedListHolder<User> pages = new PagedListHolder<>(users);
		pages.setPageSize(46);
		pages.setMaxLinkedPages(1000);
		

		return pages;
	}
	
}

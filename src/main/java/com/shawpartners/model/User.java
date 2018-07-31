package com.shawpartners.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	private String login;
	private Long id;
	private String url;
	
	@JsonProperty("created_at")
	private LocalDateTime createdAt;
	
	@JsonProperty("repos_url")
	private String reposUrl;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getReposUrl() {
		return reposUrl;
	}

	public void setReposUrl(String reposUrl) {
		this.reposUrl = reposUrl;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", id=" + id + ", url=" + url + ", createdAt=" + createdAt + ", reposUrl="
				+ reposUrl + "]";
	}

	
	

}

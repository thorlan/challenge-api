package com.shawpartners.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	private String origin = "*"; 
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		httpResponse.setHeader("Access-Control-Allow-Origin", origin);
		httpResponse.setHeader("Accept", "application/json");
		
		if ("OPTIONS".equals(httpRequest.getMethod()) && origin.equals(httpRequest.getHeader("Origin"))){
			httpResponse.setHeader("Access-Control-Allow-Methods", "GET");
			httpResponse.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
			httpResponse.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(httpRequest, httpResponse);
		}
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	@Override
	public void destroy() {
		
	}

}

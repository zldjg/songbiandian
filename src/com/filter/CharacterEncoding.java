package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncoding implements Filter {

	private FilterConfig filterconfig = null;

	public void destroy() {
		this.filterconfig = null;
	}

	public void doFilter(ServletRequest Srequest, ServletResponse Sresponse,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) Srequest;
		ServletResponse response =(HttpServletResponse) Sresponse;
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
			
		chain.doFilter(Srequest, Sresponse);
	
	}

	public void init(FilterConfig filterconfig) throws ServletException {
		this.filterconfig = filterconfig;
	}

}

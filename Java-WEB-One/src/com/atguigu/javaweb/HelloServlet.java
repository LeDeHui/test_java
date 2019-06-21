package com.atguigu.javaweb;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("destory...");	
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig...");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo...");
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init...");	 
		String userString = servletConfig.getInitParameter("user");
		System.out.println("    user:   "+userString);
		Enumeration<String> names = servletConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			String nameString = names.nextElement();
			String valueString = servletConfig.getInitParameter(nameString);
			System.out.println("    name:   "+nameString + "    values:    " + valueString);
		}
		
		//String servlerName = servletConfig.getServletName();
		//System.out.println(servlerName);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service...");	
	}

	 public HelloServlet() {
		System.out.println("HelloServlet's constructor..."); 
	 }
}

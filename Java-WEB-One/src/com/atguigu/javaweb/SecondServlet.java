package com.atguigu.javaweb;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet implements Servlet {

	@Override
	public void destroy() {
		System.out.println("destroy.");

	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig.");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo.");
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("second Servlet init.");

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service.");

	}
	public SecondServlet() {
		System.out.println("SeconsServlet's constructor..."); 
	 }

}

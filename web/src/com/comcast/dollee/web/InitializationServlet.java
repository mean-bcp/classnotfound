package com.comcast.dollee.web;

import java.util.Properties;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

public class InitializationServlet extends HttpServlet {

	private static final long serialVersionUID = -114836509486488542L;

	private Logger log;

	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
	}
}

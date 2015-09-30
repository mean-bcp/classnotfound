package com.comcast.dollee.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

public class HealthcheckServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5574440937650614816L;

	private final Logger log = Logger.getLogger(getClass());
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {

			PrintWriter out = response.getWriter();

			out.println("Hello");
		} catch (Error er) {

			log.fatal("Healthcheck failed, Error caught and rethrown to app server: ", er);
			throw er;
		}
	}
}

package com.comcast.dollee.ws;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

/**
 * Class for defining the DOLLEE Webservices
 */
@WebService
public class Foo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1568942494036512599L;
	private Logger log;

	public Foo() {
		log = Logger.getLogger(this.getClass());
	}

	@WebMethod
	public String getStuff(String inputString) {
		return "whatever";
	}

	/**
	 * CMTS FQDN Mapping refresh.
	 *
	 * @param force
	 */
	@WebMethod
	public void cmtsRefreshWS(boolean force) {
		//stuff
	}
}

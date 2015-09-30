package com.comcast.dollee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

/**
 */
@Stateless
public class FooBean {

	private static final Logger logger = Logger
			.getLogger(FooBean.class.getName());
	private static final String CMTS_CHECK_NAME = "Foo CMTS Timer";

	@Resource
	TimerService timerService;

	public void initTimer() {

		try {

			cancelAllTimers();
			timerService.createTimer(0, CMTS_CHECK_NAME);

		} catch (Exception e) {

			String error = "ERROR in initialization of giaddr-to-CMTSFQDN refresh process";
			logger.error(error, e);
		}
	}

	private long getIntervalDuration() {

		long intervalDuration = 5;

		return intervalDuration;
	}

	private void cancelAllTimers() {

		Timer timer = null;
		logger.debug("Canceling any existing timers associated with CMTS Refresh!");
		Collection timers = timerService.getTimers();
		Iterator iter = timers.iterator();
		while (iter.hasNext()) {

			timer = (Timer) iter.next();
			if (CMTS_CHECK_NAME.equals(timer.getInfo())) {

				timer.cancel();
			}
		}
	}

	@Timeout
	public void timeout(Timer timer) {
	}
}

package com.yunfei.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
	protected static Logger logger = LoggerFactory.getLogger(LogUtil.class);
		
	public static void info(String msg) {
		logger.info(msg);
	}
	
	public static void debug(String msg) {
		logger.debug(msg);
	}
	
	public static void error(String msg) {
		logger.error(msg);
	}
}

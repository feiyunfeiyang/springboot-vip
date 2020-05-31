/**
 * Project Name:farben-recruit
 * File Name:CustomDateFormat.java
 * Package Name:com.farben.recruit.util
 * Date:2019年5月23日下午4:36:28
 * Copyright (c) 2019, Farben.com.cn All Rights Reserved.
 *
*/

package com.yunfei.util;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomDateFormat extends DateFormat {
	private static final long serialVersionUID = 2767000574712211974L;
	
	private static final String[] patterns = new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss" };
	
	private static final Logger logger = LoggerFactory.getLogger(CustomDateFormat.class);
	
	public CustomDateFormat() {
		setCalendar(Calendar.getInstance());
		setNumberFormat(NumberFormat.getInstance());
	}

	@Override
	public Date parse(String source) throws ParseException {
		return DateUtils.parseDate(source, patterns);
	}

	@Override
	public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
		toAppendTo.setLength(0);
		return toAppendTo.append(DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));
	}

	@Override
	public Date parse(String source, ParsePosition pos) {
		try {
			return parse(source);
		} catch (ParseException e) {
			logger.error("", e);
			return null;
		}
	}

	@Override
	public Object clone() {
		return super.clone();
	}
	
}
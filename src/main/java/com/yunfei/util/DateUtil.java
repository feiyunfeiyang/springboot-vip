package com.yunfei.util;

import java.text.SimpleDateFormat;

public class DateUtil {

    ThreadLocal<SimpleDateFormat> s = ThreadLocal.withInitial(() -> {return new SimpleDateFormat("yyyy-MM-dd");});
}

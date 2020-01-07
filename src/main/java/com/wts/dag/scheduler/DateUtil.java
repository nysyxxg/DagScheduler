package com.wts.dag.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public static String getFormatTimeStr() {
        return sf.format(new Date());
    }
}

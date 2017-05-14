package com.fm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by aiyi on 2017/5/13.
 */
public class TimeUtil {

    public static Date getTomorrow(Date date) {
        Date tomorrow = new Date(date.getTime() + 24 * 60 * 60 * 1000);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sf.format(tomorrow);
        try {
            tomorrow = sf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tomorrow;
    }

    public static Date getToday(Date date) {
        Date toDay = new Date(date.getTime());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sf.format(toDay);
        try {
            toDay = sf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return toDay;
    }
}

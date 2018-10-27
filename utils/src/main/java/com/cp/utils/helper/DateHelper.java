package com.cp.utils.helper;

import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    public static Date getTodayStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(11, 0);
        cal.set(13, 0);
        cal.set(12, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static Date getTodayEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(11, 24);
        cal.set(13, 0);
        cal.set(12, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static Date getDateStartTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        return cal.getTime();
    }

    public static Date getDateEndTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(11, 23);
        cal.set(12, 59);
        cal.set(13, 59);
        return cal.getTime();
    }

    public static Date getWeekStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(1), cal.get(2), cal.get(5), 0, 0, 0);
        cal.set(7, 2);
        return cal.getTime();
    }

    public static Date getWeekEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getWeekStartTime());
        cal.add(7, 7);
        return cal.getTime();
    }

    public static Date getMonthStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(1), cal.get(2), cal.get(5), 0, 0, 0);
        cal.set(5, cal.getActualMinimum(5));
        return cal.getTime();
    }

    public static Date getMonthEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(1), cal.get(2), cal.get(5), 0, 0, 0);
        cal.set(5, cal.getActualMaximum(5));
        cal.set(11, 24);
        return cal.getTime();
    }


}

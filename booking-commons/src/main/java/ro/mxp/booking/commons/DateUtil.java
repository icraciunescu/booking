package ro.mxp.booking.commons;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}
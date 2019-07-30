package ro.mxp.booking.commons;

import java.util.Calendar;
import java.util.Date;

/**
 * DateUtil helps to add or subtract the days
 */
public class DateUtil {
    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}

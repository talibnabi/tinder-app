package util;

import java.text.SimpleDateFormat;

public class DateFormatOperation {
    private static final SimpleDateFormat formatForDate = new SimpleDateFormat("HH:mm dd/MM/yyyy");

    public static String dateFormat(long dateWithMill) {
        return formatForDate.format(dateWithMill);
    }
}

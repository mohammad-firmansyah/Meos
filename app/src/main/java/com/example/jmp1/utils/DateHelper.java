package com.example.jmp1.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateHelper {

// Print the result!

    public static String convertDateToString(DateHelper date) {
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        String todayAsString = df.format(date);
        return todayAsString;
    }
}

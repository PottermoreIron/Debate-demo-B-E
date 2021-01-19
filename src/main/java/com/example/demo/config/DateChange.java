package com.example.demo.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateChange {
    public Date DateChange(String str)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        }
        catch (ParseException e ){
            System.out.println(e.getMessage());
        }
        return date;
    }
}

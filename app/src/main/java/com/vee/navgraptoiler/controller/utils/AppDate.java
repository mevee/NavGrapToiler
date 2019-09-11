package com.vee.navgraptoiler.controller.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AppDate {
    final static Calendar myCalendar = Calendar.getInstance();
    static Context context;
    static String mDate = "";
    static String format="yyyy-MM-dd";
    static String format1="yyyy-MM-dd";
    static String format2="yyyy-MM-dd";

    final static DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String myFormat = format; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.UK);
            String lTime = sdf.format(myCalendar.getTime());
            mDate = lTime;
        }
    };

    public static void setDate(Context context) {
        AppDate.context = context;
        new DatePickerDialog(context, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public static String getDate(){
        return mDate;
    }
}

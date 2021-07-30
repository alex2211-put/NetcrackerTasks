package ru.skillbench.tasks.fourthTask.date;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DateCalendar {
    public static Date getDate(String years, String minutes) {
        years = years.replaceAll("[^0-9]", "-");
        minutes = minutes.replaceAll("[^0-9]", "-");
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH-mm").parse(years + " " + minutes);
        } catch (ParseException e) {
            throw new IllegalStateException();
        }
    }

    public static @NotNull
    Calendar getCalendar(String years, String minutes) {
        Calendar myCal = new GregorianCalendar();
        myCal.setTime(getDate(years, minutes));
        return myCal;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter information: <Год><Месяц><Число> ");
        String years = in.nextLine();
        System.out.print("Enter information: <Часы><минуты> ");
        String minutes = in.nextLine();
        System.out.println(getDate(years, minutes));
        System.out.println(getCalendar(years, minutes).getTime());
    }
}

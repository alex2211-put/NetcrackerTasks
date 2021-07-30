package ru.skillbench.tasks.fourthTask.date;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DateCalendarTest {

    @Test
    void getDate() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH-mm");

        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.APRIL, 22, 15, 12, 0);
        Date date1 = cal.getTime();
        cal.set(2012, Calendar.JANUARY, 12, 6, 33, 0);
        Date date2 = cal.getTime();

        Date actualDate1 = DateCalendar.getDate("2000 4 22", "15-12");
        Date actualDate2 = DateCalendar.getDate("2012/1/12", "6.33");
        boolean[] res = new boolean[2];
        res[0] = f.format(date1).equals(f.format(actualDate1));
        res[1] = f.format(date2).equals(f.format(actualDate2));
        assertArrayEquals(new boolean[]{true, true}, res);
    }

    @Test
    void getCalendar() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2000, Calendar.APRIL, 22, 15, 12, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2012, Calendar.JANUARY, 12, 6, 33, 0);

        Calendar actualDate1 = DateCalendar.getCalendar("2000 4 22", "15-12");
        Calendar actualDate2 = DateCalendar.getCalendar("2012/1/12", "6.33");
        boolean[] res = new boolean[2];
        res[0] = f.format(cal1.getTime()).equals(f.format(actualDate1.getTime()));
        res[1] = f.format(cal2.getTime()).equals(f.format(actualDate2.getTime()));
        assertArrayEquals(new boolean[]{true, true}, res);
    }
}
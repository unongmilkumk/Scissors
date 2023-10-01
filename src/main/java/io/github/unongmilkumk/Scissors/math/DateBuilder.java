package io.github.unongmilkumk.Scissors.math;

import java.util.Calendar;
import java.util.Date;

public class DateBuilder {
    private Date date;
    public static DateBuilder newInstance() {
        return new DateBuilder();
    }

    public DateBuilder setMonth(int month) {
        date.setMonth(month);
        return this;
    }

    public DateBuilder setYear(int year) {
        date.setYear(year);
        return this;
    }

    public DateBuilder setHours(int hours) {
        date.setHours(hours);
        return this;
    }

    public DateBuilder setMinutes(int minutes) {
        date.setMinutes(minutes);
        return this;
    }

    public DateBuilder setSeconds(int seconds) {
        date.setSeconds(seconds);
        return this;
    }

    public DateBuilder setDate(int date) {
        this.date.setDate(date);
        return this;
    }

    public Date build() {
        return date;
    }
}

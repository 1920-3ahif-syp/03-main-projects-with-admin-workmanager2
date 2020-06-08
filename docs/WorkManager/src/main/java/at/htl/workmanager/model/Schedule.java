package at.htl.workmanager.model;

import java.sql.Time;

public class Schedule {

    private static long id;
    private Time startTime;
    private Time endTime;
    private short calendarWeek;

    public Schedule(long id, Time startTime, Time endTime, short calendarWeek) {
        this.id = id;
        setStartTime(startTime);
        setEndTime(endTime);
        setCalendarWeek(calendarWeek);
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public short getCalendarWeek() {
        return calendarWeek;
    }

    public void setCalendarWeek(short calendarWeek) {
        this.calendarWeek = calendarWeek;
    }

    public static long getId() {
        return id;
    }

}

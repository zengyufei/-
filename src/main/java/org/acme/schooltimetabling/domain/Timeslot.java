package org.acme.schooltimetabling.domain;

import ai.timefold.solver.core.api.domain.lookup.PlanningId;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.DayOfWeek;
import java.time.LocalTime;

@JsonIdentityInfo(scope = Timeslot.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Timeslot {

    @PlanningId
    private String id;

    private DayOfWeek dayOfWeek;
    private String dayOfWeekStr;
    private LocalTime startTime;
    private LocalTime endTime;

    public Timeslot() {
    }

    public Timeslot(String id, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeekStr = switch (dayOfWeek) {
            case MONDAY -> "周一";
            case TUESDAY -> "周二";
            case WEDNESDAY -> "周三";
            case THURSDAY -> "周四";
            case FRIDAY -> "周五";
            case SATURDAY -> "周六";
            case SUNDAY -> "周日";
        };
    }

    public Timeslot(String id, DayOfWeek dayOfWeek, LocalTime startTime) {
        this(id, dayOfWeek, startTime, startTime.plusMinutes(50));
    }

    @Override
    public String toString() {
        return dayOfWeek + " " + startTime;
    }

    // ************************************************************************
    // Getters and setters
    // ************************************************************************

    public String getId() {
        return id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getDayOfWeekStr() {
        return dayOfWeekStr;
    }

}

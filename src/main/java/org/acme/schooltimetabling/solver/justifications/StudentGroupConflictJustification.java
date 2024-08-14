package org.acme.schooltimetabling.solver.justifications;

import ai.timefold.solver.core.api.score.stream.ConstraintJustification;
import org.acme.schooltimetabling.domain.Lesson;

public record StudentGroupConflictJustification(String studentGroup, Lesson lesson1, Lesson lesson2, String description)
        implements
            ConstraintJustification {
    public StudentGroupConflictJustification(String studentGroup, Lesson lesson1, Lesson lesson2) {
        this(studentGroup, lesson1, lesson2,
                "班级 '%s' 不允许同一时间点 '%s %s' 同时教学 '%s' 和 '%s'"
                        .formatted(studentGroup,
                                lesson1.getTimeslot().getDayOfWeekStr(),
                                lesson1.getTimeslot().getStartTime(),
                                lesson1.getSubject(),
                                lesson2.getSubject())
        );
    }
}

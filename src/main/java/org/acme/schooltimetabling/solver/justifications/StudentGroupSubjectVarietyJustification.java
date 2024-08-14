package org.acme.schooltimetabling.solver.justifications;

import ai.timefold.solver.core.api.score.stream.ConstraintJustification;
import org.acme.schooltimetabling.domain.Lesson;

public record StudentGroupSubjectVarietyJustification(String studentGroup, Lesson lesson1, Lesson lesson2, String description)
        implements
            ConstraintJustification {

    public StudentGroupSubjectVarietyJustification(String studentGroup, Lesson lesson1, Lesson lesson2) {
        this(studentGroup, lesson1, lesson2,
                "班级 '%s' 有 2 节连续课程 '%s' 在 '%s %s' 和 '%s %s'."
                        .formatted(studentGroup,
                                lesson1.getSubject(),
                                lesson1.getTimeslot().getDayOfWeekStr(),
                                lesson1.getTimeslot().getStartTime(),
                                lesson2.getTimeslot().getDayOfWeekStr(),
                                lesson2.getTimeslot().getStartTime()));
    }
}

package org.acme.schooltimetabling.solver.justifications;

import ai.timefold.solver.core.api.score.stream.ConstraintJustification;
import org.acme.schooltimetabling.domain.Lesson;

public record TeacherConflictJustification(String teacher, Lesson lesson1, Lesson lesson2, String description)
        implements
        ConstraintJustification {

    public TeacherConflictJustification(String teacher, Lesson lesson1, Lesson lesson2) {
        this(teacher, lesson1, lesson2,
                //    "Teacher '%s' needs to teach lesson '%s' for student group '%s' and lesson '%s' for student group '%s' at '%s %s'"
                " '%s' 老师需要在 '%s %s' 同时为班级 '%s' 和 '%s' 教授 '%s' 和 '%s' 课程"
                        .formatted(teacher,
                                lesson1.getTimeslot().getDayOfWeekStr(),
                                lesson1.getTimeslot().getStartTime(),
                                lesson1.getStudentGroup(),
                                lesson2.getStudentGroup(),
                                lesson1.getSubject(),
                                lesson2.getSubject())
        );
    }
}

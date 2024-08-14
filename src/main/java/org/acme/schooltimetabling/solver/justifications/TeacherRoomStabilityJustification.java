package org.acme.schooltimetabling.solver.justifications;

import ai.timefold.solver.core.api.score.stream.ConstraintJustification;
import org.acme.schooltimetabling.domain.Lesson;

public record TeacherRoomStabilityJustification(String teacher, Lesson lesson1, Lesson lesson2, String description)
        implements
            ConstraintJustification {

    public TeacherRoomStabilityJustification(String teacher, Lesson lesson1, Lesson lesson2) {
        this(teacher, lesson1, lesson2,
                "教师 '%s' 有 2 节不同的课程在不同的教学场地教学: '%s %s' 在教学场地1 '%s' 和 '%s %s' 教学场地2 '%s' "
                        .formatted(teacher,
                                lesson1.getTimeslot().getDayOfWeekStr(),
                                lesson1.getTimeslot().getStartTime(),
                                lesson1.getRoom(),
                                lesson2.getTimeslot().getDayOfWeekStr(),
                                lesson2.getTimeslot().getStartTime(),
                                lesson2.getRoom()
                        )
        );
    }
}

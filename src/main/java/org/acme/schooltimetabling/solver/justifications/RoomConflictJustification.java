package org.acme.schooltimetabling.solver.justifications;

import ai.timefold.solver.core.api.score.stream.ConstraintJustification;
import org.acme.schooltimetabling.domain.Lesson;
import org.acme.schooltimetabling.domain.Room;

public record RoomConflictJustification(Room room, Lesson lesson1, Lesson lesson2, String description)
        implements
        ConstraintJustification {

    public RoomConflictJustification(Room room, Lesson lesson1, Lesson lesson2) {
        this(room, lesson1, lesson2,
                // "Room '%s' is used for lesson '%s' for student group '%s' and lesson '%s' for student group '%s' at '%s %s'"
                "教学场地 '%s' 在 '%s %s' 时间被同时使用, 分别是班级 '%s' 和 '%s', 分别教学 '%s' 和 '%s'."
                        .formatted(room,
                                lesson1.getTimeslot().getDayOfWeekStr(),
                                lesson1.getTimeslot().getStartTime(),
                                lesson1.getStudentGroup(),
                                lesson2.getStudentGroup(),
                                lesson1.getSubject(),
                                lesson2.getSubject())
        );
    }
}

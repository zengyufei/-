package org.acme.schooltimetabling.solver.justifications;

import ai.timefold.solver.core.api.score.stream.ConstraintJustification;
import org.acme.schooltimetabling.domain.Lesson;

public record TeacherTimeEfficiencyJustification(String teacher, Lesson lesson1, Lesson lesson2, String description)
        implements
        ConstraintJustification {

    public TeacherTimeEfficiencyJustification(String teacher, Lesson lesson1, Lesson lesson2) {
        this(teacher, lesson1, lesson2,
                //    "Teacher '%s' has 2 consecutive lessons: lesson '%s' for student group '%s' at '%s %s'
                //    and lesson '%s' for student group '%s' at '%s %s' (gap)"
                " '%s' 老师将在 '%s' 为 '%s' 班级的学生安排了 2 节连续的 '%s' 课。第一节课在 '%s %s' 开始，紧接着第二节课在 '%s %s' 开始，两节课之间有间隙"
                        .formatted(teacher,
                                lesson1.getTimeslot().getDayOfWeekStr(),
                                lesson1.getStudentGroup(),
                                lesson1.getSubject(),
                                lesson1.getTimeslot().getDayOfWeekStr(),
                                lesson1.getTimeslot().getStartTime(),
                                lesson2.getTimeslot().getDayOfWeekStr(),
                                lesson2.getTimeslot().getStartTime())
        );
    }
}

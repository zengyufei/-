package org.acme.schooltimetabling.rest;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.acme.schooltimetabling.domain.Lesson;
import org.acme.schooltimetabling.domain.Room;
import org.acme.schooltimetabling.domain.Timeslot;
import org.acme.schooltimetabling.domain.Timetable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "Demo data", description = "Timefold-provided demo school timetable data.")
@RestController
@RequestMapping("/demo-data")
public class TimetableDemoController {

    public enum DemoData {
        SMALL,
        LARGE
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of demo data represented as IDs.",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = DemoData.class, type = "array")))})
    @Operation(summary = "List demo data.")
    @GetMapping()
    public DemoData[] list() {
        return DemoData.values();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Unsolved demo timetable.",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Timetable.class)))})
    @Operation(summary = "Find an unsolved demo timetable by ID.")
    @GetMapping(value = "/{demoDataId}")
    public ResponseEntity<Timetable> generate(@Parameter(description = "Unique identifier of the demo data.",
            required = true) @PathVariable("demoDataId") DemoData demoData) {
		demoData =  DemoData.LARGE;
        List<Timeslot> timeslots = new ArrayList<>(10);
        long nextTimeslotId = 0L;
        timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
        timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.MONDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
        timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
        timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.MONDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
        timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.MONDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));

        timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.TUESDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
        timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.TUESDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
        timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.TUESDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
        timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.TUESDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
        timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.TUESDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
        if (demoData == DemoData.LARGE) {
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.WEDNESDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.WEDNESDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.WEDNESDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.WEDNESDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.THURSDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.THURSDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.THURSDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.THURSDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.THURSDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.FRIDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.FRIDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.FRIDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId++), DayOfWeek.FRIDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
            timeslots.add(new Timeslot(Long.toString(nextTimeslotId), DayOfWeek.FRIDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
        }

        List<Room> rooms = new ArrayList<>(3);
        long nextRoomId = 0L;
        rooms.add(new Room(Long.toString(nextRoomId++), "大会堂"));
        rooms.add(new Room(Long.toString(nextRoomId++), "广场"));
        rooms.add(new Room(Long.toString(nextRoomId++), "阶梯教室"));
        if (demoData == DemoData.LARGE) {
            rooms.add(new Room(Long.toString(nextRoomId++), "实训楼"));
            rooms.add(new Room(Long.toString(nextRoomId++), "音乐楼"));
            rooms.add(new Room(Long.toString(nextRoomId), "行政楼"));
        }

        List<Lesson> lessons = new ArrayList<>();
        long nextLessonId = 0L;
        lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计1班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计1班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "物理", "黄渤", "会计1班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "化学", "黄渤", "会计1班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "生物学", "黄雅莉", "会计1班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "历史", "孙红雷", "会计1班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "英语", "孙红雷", "会计1班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "英语", "孙红雷", "会计1班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "西班牙语", "六小龄童", "会计1班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "西班牙语", "六小龄童", "会计1班"));
        if (demoData == DemoData.LARGE) {
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "信息和通信技术", "陈坤", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "物理", "黄渤", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "地理", "黄雅莉", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "地质学", "黄雅莉", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "历史", "孙红雷", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "英语", "孙红雷", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "戏剧", "孙红雷", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "美术", "刘亦菲", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "美术", "刘亦菲", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "体育", "汪东城", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "体育", "汪东城", "会计1班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "体育", "汪东城", "会计1班"));
        }

        lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计2班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计2班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计2班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "物理", "黄渤", "会计2班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "化学", "黄渤", "会计2班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "法语", "黄渤", "会计2班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "地理", "黄雅莉", "会计2班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "历史", "孙红雷", "会计2班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "英语", "六小龄童", "会计2班"));
        lessons.add(new Lesson(Long.toString(nextLessonId++), "西班牙语", "六小龄童", "会计2班"));
        if (demoData == DemoData.LARGE) {
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "信息和通信技术", "陈坤", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "物理", "黄渤", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "生物学", "黄雅莉", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "地质学", "黄雅莉", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "历史", "孙红雷", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "英语", "六小龄童", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "英语", "六小龄童", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "戏剧", "孙红雷", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "美术", "刘亦菲", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "美术", "刘亦菲", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "体育", "汪东城", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "体育", "汪东城", "会计2班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "体育", "汪东城", "会计2班"));

            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "信息和通信技术", "陈坤", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "物理", "黄渤", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "化学", "黄渤", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "法语", "黄渤", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "物理", "黄渤", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "地理", "黄雅莉", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "生物学", "黄雅莉", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "地质学", "黄雅莉", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "历史", "孙红雷", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "历史", "孙红雷", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "英语", "六小龄童", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "英语", "六小龄童", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "英语", "六小龄童", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "西班牙语", "六小龄童", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "戏剧", "六小龄童", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "美术", "刘亦菲", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "美术", "刘亦菲", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "体育", "汪东城", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "体育", "汪东城", "会计3班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "体育", "汪东城", "会计3班"));

            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "数学", "陈坤", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "信息和通信技术", "陈坤", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "物理", "黄渤", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "化学", "黄渤", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "法语", "黄渤", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "物理", "黄渤", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "地理", "黄雅莉", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "生物学", "黄雅莉", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "地质学", "黄雅莉", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "历史", "孙红雷", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "历史", "孙红雷", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "英语", "六小龄童", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "英语", "六小龄童", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "英语", "六小龄童", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "西班牙语", "六小龄童", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "戏剧", "六小龄童", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "美术", "刘亦菲", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "美术", "刘亦菲", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "体育", "汪东城", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId++), "体育", "汪东城", "会计4班"));
            lessons.add(new Lesson(Long.toString(nextLessonId), "体育", "汪东城", "会计4班"));
        }
        return ResponseEntity.ok(new Timetable(demoData.name(), timeslots, rooms, lessons));
    }

}

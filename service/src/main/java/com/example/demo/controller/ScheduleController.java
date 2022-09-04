package com.example.demo.controller;

import com.example.demo.model.Days;
import com.example.demo.services.ScheduleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleServices scheduleService;

    @GetMapping
    public Map<String, List<String>> findAllSchedule(){
        //db query
        Map<String, List<String>> allSchedule = scheduleService.getAllActivities();

        return allSchedule;
    }

    @GetMapping(path = {"/{day}"})
    public Map<String, List<String>> findActivitiesByDays(@PathVariable("day") String day){
        Days d = null;

        switch (day){
            case "monday": d = Days.MONDAY; break;
            case "tuesday": d = Days.TUESDAY; break;
            case "wednesday": d = Days.WEDNESDAY; break;
            case "thursday": d = Days.THURSDAY; break;
            case "friday": d = Days.FRIDAY; break;
            case "saturday": d = Days.SATURDAY; break;
            case "sunday": d = Days.SUNDAY; break;
            default: break;
        }

        Map<String, List<String>> activities = new HashMap<>();
        activities.put(d.getDay(), scheduleService.getActivitiesByDay(d));
        return activities;
    }
}

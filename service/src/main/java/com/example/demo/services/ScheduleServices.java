package com.example.demo.services;

import com.example.demo.model.Activities;
import com.example.demo.model.Days;

import java.util.List;
import java.util.Map;

public interface ScheduleServices {
    Map<String, List<String>> getAllActivities();
    List<String> getActivitiesByDay(Days day);
}

package com.example.demo.services.impl;

import com.example.demo.factory.ActivitiesFactory;
import com.example.demo.model.Activities;
import com.example.demo.model.Days;
import com.example.demo.services.ScheduleServices;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduleImpl implements ScheduleServices {
    Map<Days, List<Activities>> schedule;

    ScheduleImpl(){
        schedule = new HashMap<>();
        List<Activities> monSchedule = Arrays.asList(Activities.FISHING);
        List<Activities> tueSchedule = Arrays.asList(Activities.CLIMBING);
        List<Activities> wedSchedule = Arrays.asList(Activities.SWIMMING);
        List<Activities> thurSchedule = Arrays.asList(Activities.FISHING, Activities.SWIMMING);
        List<Activities> friSchedule = Arrays.asList(Activities.FISHING, Activities.CLIMBING, Activities.SWIMMING);
        List<Activities> satSchedule = Arrays.asList();
        List<Activities> sunSchedule = Arrays.asList();
        schedule.put(Days.MONDAY, monSchedule);
        schedule.put(Days.TUESDAY, tueSchedule);
        schedule.put(Days.WEDNESDAY, wedSchedule);
        schedule.put(Days.THURSDAY, thurSchedule);
        schedule.put(Days.FRIDAY, friSchedule);
        schedule.put(Days.SATURDAY, satSchedule);
        schedule.put(Days.SUNDAY, sunSchedule);
    }

    @Override
    public Map<String, List<String>> getAllActivities() {
        Map<String, List<String>> allSchedule = new HashMap<>();
        for (Map.Entry<Days, List<Activities>> entry : schedule.entrySet()) {
            List<String> activities = new ArrayList<>();
            if(entry.getValue().size() == 0){
                String activityName = ActivitiesFactory.createActivity("break").getActivityName();
                activities.add(activityName);
            }
            else {
                entry.getValue().forEach(activity -> {
                    String activityName = ActivitiesFactory.createActivity(activity.getActivityName()).getActivityName();
                    activities.add(activityName);
                });
            }
            allSchedule.put(entry.getKey().getDay(), activities);
        }
        return allSchedule;
    }

    @Override
    public List<String> getActivitiesByDay(Days day) {
        List<Activities> activitiesList = schedule.get(day);
        List<String> activities = new ArrayList<>();
        if(activitiesList.size() == 0){
            String activityName = ActivitiesFactory.createActivity("break").getActivityName();
            activities.add(activityName);
        }
        else
            activitiesList.forEach(activity -> {
                String activityName = ActivitiesFactory.createActivity(activity.getActivityName()).getActivityName();
                activities.add(activityName);
            });
        return activities;
    }
}

package com.example.demo.factory;

import com.example.demo.SpringHelper;
import com.example.demo.model.Activity;

public class ActivitiesFactory {
    public static Activity createActivity(String activity){
        return SpringHelper.getBean(activity, Activity.class);
    }
}

package com.example.demo.model;

public enum Activities {
    FISHING("fishing"),
    SWIMMING("swimming"),
    CLIMBING("climbing"),
    BREAK("break");

    public String activityName;

    private Activities(String value){
        this.activityName = value;
    }

    public String getActivityName(){
        return activityName;
    }
}

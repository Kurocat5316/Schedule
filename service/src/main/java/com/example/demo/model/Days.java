package com.example.demo.model;

public enum Days {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    public String day ;

    private Days(String value){
        this.day = value;
    }

    public String getDay(){
        return day;
    }
}

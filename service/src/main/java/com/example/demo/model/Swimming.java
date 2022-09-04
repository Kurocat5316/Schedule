package com.example.demo.model;

import org.springframework.stereotype.Service;

@Service("swimming")
public class Swimming extends Activity{
    public Swimming(){
        setActivityName("Swimming");
    }
}

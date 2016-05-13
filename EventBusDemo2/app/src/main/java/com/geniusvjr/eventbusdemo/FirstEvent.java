package com.geniusvjr.eventbusdemo;

/**
 * Created by dream on 16/5/13.
 */
public class FirstEvent {

    private String mMsg;
    public FirstEvent(String msg){
        mMsg = msg;
    }

    public String getMsg(){
        return mMsg;
    }
}

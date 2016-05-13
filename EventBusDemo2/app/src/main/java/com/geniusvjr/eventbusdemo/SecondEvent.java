package com.geniusvjr.eventbusdemo;

/**
 * Created by dream on 16/5/13.
 */
public class SecondEvent {

    private String mMsg;
    public SecondEvent(String msg){
        mMsg = "MainEvent:" + msg;
    }

    public String getMsg(){
        return mMsg;
    }
}

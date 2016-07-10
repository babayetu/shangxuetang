package com.vip.oomtest;

public class StartObject {

    private static int totalTime = 0;

    public int work(int sleepTime) throws InterruptedException{

//        System.out.println("sleep " + sleepTime);
        
//        Thread.sleep(sleepTime);

        totalTime += sleepTime;

        return totalTime;

    }

}
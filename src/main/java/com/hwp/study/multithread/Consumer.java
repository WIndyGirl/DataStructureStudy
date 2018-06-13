package com.hwp.study.multithread;

import java.util.concurrent.CountDownLatch;

public class Consumer implements Runnable {
    private String topic = null;
    private boolean threadSuspended = true;
    private CountDownLatch latch = null;

    public Consumer(String topic){
        this.topic = topic;
    }

    public Consumer(String topic, CountDownLatch latch){
        this.topic = topic;
        this.latch = latch;
    }

    @Override
    public void run() {
        try{
            System.out.println("Consumer for topic " + topic + " is ready");
            latch.countDown();
            synchronized(this){
                if(threadSuspended){
                    wait();
                }
            }

            System.out.println("Start to poll message from topic " + topic);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void suspendThread(){
        threadSuspended = true;
    }

    public synchronized void resumeThread(){
        threadSuspended = false;

        if (!threadSuspended){
            notify();
        }
    }
}

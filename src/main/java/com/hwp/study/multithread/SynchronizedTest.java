package com.hwp.study.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SynchronizedTest {
    public static void main(String[] args){
        CountDownLatch latch = new CountDownLatch(2);

        Consumer c1 = new Consumer("alarm", latch);
        Thread thread1 = new Thread(c1);

        Consumer c2 = new Consumer("state", latch);
        Thread thread2 = new Thread(c2);

        thread1.start();
        thread2.start();

        // Wait the consumers be ready
        System.out.println("Wait the consumer be ready");
        try{
            latch.await(10, TimeUnit.SECONDS);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Consumers are ready");

        //c1.resumeThread();
        //c2.resumeThread();
    }
}

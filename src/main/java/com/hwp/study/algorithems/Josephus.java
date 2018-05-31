package com.hwp.study.algorithems;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Josephus {
    public static void main(String[] args){
        int totalNum = 7;
        int deadNum = 2;

        Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
        for(int i = 0; i < totalNum; i++){
            queue.add(i);
        }

        while(! queue.isEmpty()){
            for(int i = 0; i < deadNum - 1; i++){
                int num = queue.remove();

                if(queue.isEmpty()){
                    queue.add(num);
                    break;
                }
                queue.add(num);
            }

            System.out.println(queue.remove());
        }
    }
}

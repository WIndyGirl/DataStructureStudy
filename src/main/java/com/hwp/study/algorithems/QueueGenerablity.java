package com.hwp.study.algorithems;

public class QueueGenerablity {
    public boolean generable(int[] nums){
        int lastNum = nums[0];

        for(int i = 1; i < nums.length; i++){
            if (lastNum == 9 && nums[i] != 0){
                return false;
            }

            if(lastNum == 9){
                lastNum = 0;
                continue;
            }

            if(nums[i] <= lastNum){
                return false;
            }

            if(nums[i] > lastNum + 1){
                return false;
            }

            lastNum = nums[i];
        }

        return true;
    }

    public static void main(String[] args){
        QueueGenerablity queue = new QueueGenerablity();
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(queue.generable(nums));

        int[] nums2 = {4, 6, 8, 7, 5, 3, 2, 9, 0, 1};
        System.out.println(queue.generable(nums2));

        int[] nums3 = {2, 5, 6, 7, 4, 8, 9, 3, 1, 0};
        System.out.println(queue.generable(nums3));

        int[] nums4 = {4, 3, 2, 1, 0, 5, 6, 7, 8, 9};
        System.out.println(queue.generable(nums4));

    }
}

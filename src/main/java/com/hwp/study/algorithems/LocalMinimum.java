/*
given an array a[] of N distinct integers,
finds a local minimum: an index i such that botha[i] < a[i-1] and a[i] < a[i+1]
(assuming the neighboring entry is in bounds)
 */

package com.hwp.study.algorithems;

public class LocalMinimum {
    public void getLocalMini(int[] nums){
        int min = nums[0];
        int minIndex = 0;

        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]){
                System.out.println(i);
                break;
            }
        }
    }
}

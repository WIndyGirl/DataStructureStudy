package com.hwp.study.algorithems;

import java.util.Stack;

public class StackGenerablity {
    public boolean generablity(int[] output){

        int lastPush = -1;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < output.length; i++){
            int tmp = output[i];

            if (tmp > lastPush + 1){
                for (int j = lastPush + 1; j < tmp; j++){
                    stack.push(j);
                }

                lastPush = tmp;
            } else if (tmp == lastPush + 1){
                lastPush = tmp;
            } else if (tmp < lastPush && lastPush > 1){
                if (tmp != stack.pop()){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args){
        StackGenerablity sg = new StackGenerablity();

        int[] output = {4, 6, 8, 7, 5, 3, 2, 9, 0, 1};
        boolean result = sg.generablity(output);
        System.out.println(result);

        int[] output2 = {2, 5, 6, 7, 4, 8, 9, 3, 1, 0};
        result = sg.generablity(output2);
        System.out.println(result);

        int[] output3 = {0, 4, 6, 5, 3, 8, 1, 7, 2, 9};
        result = sg.generablity(output3);
        System.out.println(result);

        int[] output4 = {1, 4, 7, 9, 8, 6, 5, 3, 0, 2};
        result = sg.generablity(output4);
        System.out.println(result);

        int[] output5 = {2, 1, 4, 3, 6, 5, 8, 7, 9, 0};
        result = sg.generablity(output5);
        System.out.println(result);

    }
}
